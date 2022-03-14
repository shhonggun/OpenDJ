/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions Copyright [year] [name of copyright owner]".
 *
 * Copyright 2010 Sun Microsystems, Inc.
 * Portions Copyright 2011-2016 ForgeRock AS.
 */
package com.forgerock.opendj.ldap.tools;

import static com.forgerock.opendj.ldap.tools.Utils.printErrorMessage;
import static java.util.concurrent.TimeUnit.*;

import static org.forgerock.util.Utils.*;

import static com.forgerock.opendj.ldap.tools.ToolsMessages.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.opendj.ldap.Connection;
import org.forgerock.opendj.ldap.ConnectionEventListener;
import org.forgerock.opendj.ldap.ConnectionFactory;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.ldap.LdapResultHandler;
import org.forgerock.opendj.ldap.requests.BindRequest;
import org.forgerock.opendj.ldap.responses.ExtendedResult;
import org.forgerock.opendj.ldap.responses.Result;
import org.forgerock.util.promise.Promise;

import com.forgerock.opendj.cli.ArgumentException;
import com.forgerock.opendj.cli.ArgumentParser;
import com.forgerock.opendj.cli.BooleanArgument;
import com.forgerock.opendj.cli.ConsoleApplication;
import com.forgerock.opendj.cli.IntegerArgument;
import com.forgerock.opendj.cli.StringArgument;
import com.forgerock.opendj.util.StaticUtils;

/** Benchmark application framework. */
abstract class PerformanceRunner implements ConnectionEventListener {
    private static final double[] DEFAULT_PERCENTILES = new double[] { 99.9, 99.99, 99.999 };

    class TimerThread extends Thread {
        private final long timeToWait;

        TimerThread(long timeToWait) {
            this.timeToWait = timeToWait;
        }

        void performStopOperations() {
            stopTool();
        }

        @Override
        public void run() {
            try {
                Thread.sleep(timeToWait);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            } finally {
                performStopOperations();
            }
        }
    }

    /**
     * Statistics update result handler implementation.
     *
     * @param <S>
     *            The type of expected result.
     */
    class UpdateStatsResultHandler<S extends Result> implements LdapResultHandler<S> {
        protected final long operationStartTimeNs;

        UpdateStatsResultHandler(final long currentTimeNs) {
            this.operationStartTimeNs = currentTimeNs;
        }

        @Override
        public final void handleException(final LdapException exception) {
            statsThread.incrementFailedCount();
            updateResponseTime();
            app.errPrintVerboseMessage(LocalizableMessage.raw(exception.getResult().toString()));
        }

        @Override
        public final void handleResult(final S result) {
            statsThread.incrementSuccessCount();
            updateResponseTime();
            updateAdditionalStatsOnResult();
        }

        /** Do nothing by default, child classes which manage additional stats need to override this method. */
        void updateAdditionalStatsOnResult() { }

        private void updateResponseTime() {
            statsThread.addResponseTime(System.nanoTime() - operationStartTimeNs);
        }
    }

    /** Worker thread base implementation. */
    abstract class WorkerThread extends Thread {
        private int count;
        private final Connection connection;
        private final ConnectionFactory connectionFactory;
        boolean localStopRequested;

        WorkerThread(final Connection connection, final ConnectionFactory connectionFactory) {
            super("Worker Thread");
            this.connection = connection;
            this.connectionFactory = connectionFactory;
        }

        public abstract Promise<?, LdapException> performOperation(
                Connection connection, DataSource[] dataSources, long currentTimeNs);

        @Override
        public void run() {
            Promise<?, LdapException> promise;
            Connection connection;
            final double targetTimeMs = 1000.0 / (targetThroughput / (double) (numThreads * numConnections));
            double sleepTimeMs = 0;

            while (!stopRequested && !localStopRequested
                    && (maxIterations <= 0 || count < maxIterations)) {
                try {
                    connection = getConnectionToUse();
                } catch (final InterruptedException e) {
                    // Ignore and check stop requested
                    continue;
                } catch (final LdapException e) {
                    handleConnectionError(false, e);
                    break;
                }

                long startTimeNs = System.nanoTime();
                promise = performOperation(connection, dataSources.get(), startTimeNs);
                statsThread.incrementOperationCount();
                try {
                    promise.getOrThrow();
                } catch (final InterruptedException e) {
                    // Ignore and check stop requested
                    continue;
                } catch (final LdapException e) {
                    if (!stopRequested && e.getCause() instanceof IOException) {
                        e.getCause().printStackTrace(app.getErrorStream());
                        stopTool(true);
                        break;
                    }
                    // Ignore. Handled by result handler
                } finally {
                    if (this.connection == null) {
                        connection.close();
                    }
                }

                if (targetThroughput > 0) {
                    try {
                        if (sleepTimeMs > 1) {
                            sleep((long) Math.floor(sleepTimeMs));
                        }
                    } catch (final InterruptedException e) {
                        continue;
                    }

                    sleepTimeMs += targetTimeMs - NANOSECONDS.toMillis(System.nanoTime() - startTimeNs);
                    final long oneMinuteMs = MINUTES.toMillis(1);
                    if (sleepTimeMs + oneMinuteMs < 0) {
                        // If we fall behind by 60 seconds, just forget about catching up
                        sleepTimeMs = -oneMinuteMs;
                    }
                }
            }
        }

        private Connection getConnectionToUse() throws InterruptedException, LdapException {
            if (this.connection == null) {
                return connectionFactory.getConnectionAsync().getOrThrow();
            } else {
                final Connection resultConnection = this.connection;
                if (!noRebind && bindRequest != null) {
                    resultConnection.bindAsync(bindRequest).getOrThrow();
                }
                return resultConnection;
            }
        }

        void incrementIterationCount() {
            count++;
        }
    }

    private final ConsoleApplication app;
    private DataSource[] dataSourcePrototypes;

    /** Thread local copies of the data sources. */
    private final ThreadLocal<DataSource[]> dataSources = new ThreadLocal<DataSource[]>() {
        @Override
        protected DataSource[] initialValue() {
            final DataSource[] prototypes = getDataSources();
            final int sz = prototypes.length;
            final DataSource[] threadLocalCopy = new DataSource[sz];
            for (int i = 0; i < sz; i++) {
                threadLocalCopy[i] = prototypes[i].duplicate();
            }
            return threadLocalCopy;
        }

    };

    int numThreads;
    int numConnections;
    private boolean stopRequested;

    private int targetThroughput;
    private int maxIterations;
    /** Warm-up duration time in ms. */
    private long warmUpDurationMs;
    /** Max duration time in ms, 0 for unlimited. */
    private long maxDurationTimeMs;
    private boolean noRebind;
    private BindRequest bindRequest;
    private int statsIntervalMs;
    private final IntegerArgument numThreadsArgument;
    private final IntegerArgument maxDurationArgument;
    private final IntegerArgument statsIntervalArgument;
    private final IntegerArgument targetThroughputArgument;
    private final IntegerArgument numConnectionsArgument;
    private final IntegerArgument percentilesArgument;
    private final BooleanArgument keepConnectionsOpen;
    private final BooleanArgument noRebindArgument;
    private final StringArgument arguments;
    protected final IntegerArgument maxIterationsArgument;
    protected final IntegerArgument warmUpArgument;

    private final List<Thread> workerThreads = new ArrayList<>();
    StatsThread statsThread;

    PerformanceRunner(final PerformanceRunnerOptions options) throws ArgumentException {
        ArgumentParser argParser = options.getArgumentParser();

        this.app = options.getConsoleApplication();

        numThreadsArgument =
                IntegerArgument.builder("numThreads")
                        .shortIdentifier('t')
                        .description(LocalizableMessage.raw("Number of worker threads per connection"))
                        .lowerBound(1)
                        .defaultValue(1)
                        .valuePlaceholder(LocalizableMessage.raw("{numThreads}"))
                        .buildArgument();
        if (options.supportsMultipleThreadsPerConnection()) {
            argParser.addArgument(numThreadsArgument);
        } else {
            numThreadsArgument.addValue("1");
        }

        numConnectionsArgument =
                IntegerArgument.builder("numConnections")
                        .shortIdentifier('c')
                        .description(LocalizableMessage.raw("Number of connections"))
                        .lowerBound(1)
                        .defaultValue(1)
                        .valuePlaceholder(LocalizableMessage.raw("{numConnections}"))
                        .buildAndAddToParser(argParser);
        maxIterationsArgument =
                IntegerArgument.builder("maxIterations")
                        .shortIdentifier('m')
                        .description(LocalizableMessage.raw("Max iterations, 0 for unlimited"))
                        .defaultValue(0)
                        .valuePlaceholder(LocalizableMessage.raw("{maxIterations}"))
                        .buildAndAddToParser(argParser);
        maxDurationArgument =
                IntegerArgument.builder("maxDuration")
                        .shortIdentifier('d')
                        .description(LocalizableMessage.raw("Maximum duration in seconds, 0 for unlimited"))
                        .lowerBound(1)
                        .defaultValue(0)
                        .valuePlaceholder(LocalizableMessage.raw("{maxDuration}"))
                        .buildAndAddToParser(argParser);
        warmUpArgument =
                IntegerArgument.builder("warmUpDuration")
                        .shortIdentifier('B')
                        .description(LocalizableMessage.raw("Warm up duration in seconds"))
                        .defaultValue(0)
                        .valuePlaceholder(LocalizableMessage.raw("{warmUpDuration}"))
                        .buildAndAddToParser(argParser);
        statsIntervalArgument =
                IntegerArgument.builder("statInterval")
                        .shortIdentifier('i')
                        .description(LocalizableMessage.raw("Display results each specified number of seconds"))
                        .lowerBound(1)
                        .defaultValue(5)
                        .valuePlaceholder(LocalizableMessage.raw("{statInterval}"))
                        .buildAndAddToParser(argParser);
        targetThroughputArgument =
                IntegerArgument.builder("targetThroughput")
                        .shortIdentifier('M')
                        .description(LocalizableMessage.raw("Target average throughput to achieve"))
                        .defaultValue(0)
                        .valuePlaceholder(LocalizableMessage.raw("{targetThroughput}"))
                        .buildAndAddToParser(argParser);
        percentilesArgument =
                IntegerArgument.builder("percentile")
                        .shortIdentifier('e')
                        .description(
                                LocalizableMessage.raw("Calculate max response time for a percentile of operations"))
                        .multiValued()
                        .range(0, 100)
                        .valuePlaceholder(LocalizableMessage.raw("{percentile}"))
                        .buildAndAddToParser(argParser);
        keepConnectionsOpen =
                BooleanArgument.builder("keepConnectionsOpen")
                        .shortIdentifier('f')
                        .description(LocalizableMessage.raw("Keep connections open"))
                        .buildAndAddToParser(argParser);
        noRebindArgument =
                BooleanArgument.builder("noRebind")
                        .shortIdentifier('F')
                        .description(LocalizableMessage.raw("Keep connections open and do not rebind"))
                        .buildArgument();
        if (options.supportsRebind()) {
            argParser.addArgument(noRebindArgument);
        }

        arguments =
                StringArgument.builder("argument")
                        .shortIdentifier('g')
                        .description(LocalizableMessage
                                .raw("Argument used to evaluate the Java "
                                        + "style format strings in program parameters (ie. Base DN, "
                                        + "Search Filter). The set of all arguments provided form the "
                                        + "the argument list in order. Besides static string "
                                        + "arguments, they can be generated per iteration with the "
                                        + "following functions: " + StaticUtils.EOL
                                        + DataSource.getUsage()))
                        .multiValued()
                        .valuePlaceholder(LocalizableMessage.raw("{generator function or static string}"))
                        .buildArgument();
        if (options.supportsGeneratorArgument()) {
            argParser.addArgument(arguments);
        }
    }

    @Override
    public void handleConnectionClosed() {
        // Ignore
    }

    @Override
    public synchronized void handleConnectionError(final boolean isDisconnectNotification, final LdapException error) {
        if (!stopRequested) {
            app.errPrintln(ERROR_RATE_TOOLS_CANNOT_GET_CONNECTION.get(error.getMessage()));
            if (error.getCause() != null && app.isVerbose()) {
                error.getCause().printStackTrace(app.getErrorStream());
            }
            stopTool(true);
        }
    }

    @Override
    public void handleUnsolicitedNotification(final ExtendedResult notification) {
        // Ignore
    }

    public final void validate() throws ArgumentException {
        numConnections = numConnectionsArgument.getIntValue();
        numThreads = numThreadsArgument.getIntValue();
        warmUpDurationMs = warmUpArgument.getIntValue() * 1000L;
        maxIterations = maxIterationsArgument.getIntValue() / numConnections / numThreads;
        maxDurationTimeMs = maxDurationArgument.getIntValue() * 1000L;
        statsIntervalMs = statsIntervalArgument.getIntValue() * 1000;
        targetThroughput = targetThroughputArgument.getIntValue();

        noRebind = noRebindArgument.isPresent();

        if (!noRebindArgument.isPresent() && this.numThreads > 1) {
            throw new ArgumentException(ERR_TOOL_ARG_MUST_BE_USED_WHEN_ARG_CONDITION.get(
                "--" + noRebindArgument.getLongIdentifier(), "--" + numThreadsArgument.getLongIdentifier(), "> 1"));
        }

        if (maxIterationsArgument.isPresent() && maxIterations <= 0) {
            throw new ArgumentException(ERR_TOOL_NOT_ENOUGH_ITERATIONS.get(
                "--" + maxIterationsArgument.getLongIdentifier(), numConnections * numThreads,
                numConnectionsArgument.getLongIdentifier(), numThreadsArgument.getLongIdentifier()));
        }

        dataSourcePrototypes = DataSource.parse(arguments.getValues());
    }

    final DataSource[] getDataSources() {
        if (dataSourcePrototypes == null) {
            throw new IllegalStateException("dataSources are null - validate() must be called first");
        }
        return dataSourcePrototypes;
    }

    abstract WorkerThread newWorkerThread(final Connection connection, final ConnectionFactory connectionFactory);
    abstract StatsThread newStatsThread(final PerformanceRunner performanceRunner, final ConsoleApplication app);

    TimerThread newEndTimerThread(final long timeToWait) {
        return new TimerThread(timeToWait);
    }

    final int run(final ConnectionFactory connectionFactory) {
        final List<Connection> connections = new ArrayList<>();
        statsThread = newStatsThread(this, app);

        try {
            validateCanConnectToServer(connectionFactory);
            for (int i = 0; i < numConnections; i++) {
                Connection connection = null;
                if (keepConnectionsOpen.isPresent() || noRebindArgument.isPresent()) {
                    connection = connectionFactory.getConnection();
                    connection.addConnectionEventListener(this);
                    connections.add(connection);
                }
                for (int j = 0; j < numThreads; j++) {
                    final Thread thread = newWorkerThread(connection, connectionFactory);
                    workerThreads.add(thread);
                    thread.start();
                }
            }

            if (maxDurationTimeMs > 0) {
                newEndTimerThread(maxDurationTimeMs).start();
            }

            statsThread.startReporting();
            joinAllWorkerThreads();
            stopTool();
        } catch (final InterruptedException e) {
            stopTool(true);
        } catch (final LdapException e) {
            stopTool(true);
            printErrorMessage(app, e);
            return e.getResult().getResultCode().intValue();
        } finally {
            closeSilently(connections);
        }

        return 0;
    }

    // detects wrong bind parameters, server unreachable (server down, network problem?), etc.
    private void validateCanConnectToServer(ConnectionFactory connectionFactory) throws LdapException {
        connectionFactory.getConnection().close();
    }

    synchronized void stopTool() {
        stopTool(false);
    }

    synchronized void stopTool(final boolean stoppedByError) {
        if (!stopRequested) {
            stopRequested = true;
            statsThread.stopRecording(stoppedByError);
        }
    }

    void setBindRequest(final BindRequest request) {
        this.bindRequest = request;
    }

    protected void joinAllWorkerThreads() throws InterruptedException {
        for (final Thread t : workerThreads) {
            t.join();
        }
    }

    double[] getPercentiles() {
        if (percentilesArgument.isPresent()) {
            double[] percentiles = new double[percentilesArgument.getValues().size()];
            int index = 0;
            for (final String percentile : percentilesArgument.getValues()) {
                percentiles[index++] = Double.parseDouble(percentile);
            }
            Arrays.sort(percentiles);
            return percentiles;
        }

        return DEFAULT_PERCENTILES;
    }

    long getWarmUpDurationMs() {
        return warmUpDurationMs;
    }

    long getStatsInterval() {
        return statsIntervalMs;
    }
}

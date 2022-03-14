
@echo off
rem The contents of this file are subject to the terms of the Common Development and
rem Distribution License (the License). You may not use this file except in compliance with the
rem License.
rem
rem You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
rem specific language governing permission and limitations under the License.
rem
rem When distributing Covered Software, include this CDDL Header Notice in each file and include
rem the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
rem Header, with the fields enclosed by brackets [] replaced by your own identifying
rem information: "Portions Copyright [year] [name of copyright owner]".
rem
rem Copyright 2006-2008 Sun Microsystems, Inc.
rem Portions Copyright 2011 ForgeRock AS.

setlocal

set OPENDJ_INVOKE_CLASS="org.opends.server.tools.ManageTasks"
set SCRIPT_NAME=manage-tasks
call "%~dp0\..\lib\_client-script.bat" %*


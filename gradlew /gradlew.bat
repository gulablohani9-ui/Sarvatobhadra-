@echo off
set DIR=%~dp0
set APP_HOME=%DIR%
set DEFAULT_JVM_OPTS=
set JAVA=java.exe
"%JAVA%" %DEFAULT_JVM_OPTS% -cp "%APP_HOME%\gradle\wrapper\gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain %*

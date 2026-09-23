#!/usr/bin/env sh
DIR="$(cd "$(dirname "$0")" && pwd)"
APP_HOME="$DIR"
DEFAULT_JVM_OPTS=""
JAVA="java"
exec "$JAVA" $DEFAULT_JVM_OPTS -cp "$APP_HOME/gradle/wrapper/gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain "$@"

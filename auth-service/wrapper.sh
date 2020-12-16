#!/usr/bin/env sh
echo "java ${JVM_OPTS} -Djava.security.egd=file:/dev/./urandom -Dserver.port=${SERVER_PORT} -jar ${APP_NAME}-${APP_VERSION}.jar"
exec  java ${JVM_OPTS} -Djava.security.egd=file:/dev/./urandom -Dserver.port=${SERVER_PORT} -jar ${APP_NAME}-${APP_VERSION}.jar

#!/bin/bash

#JAVA_HOME=/data1/install/jdk1.8.0_192
JAVA=${JAVA_HOME}/bin/java
cwd=$(dirname "$0")
debug=$1

SERVING_OPTS="-server -XX:+UseG1GC -Xmx8g -Xms8g -Xmn6g -Xss512k "
CLAZZ="com.mininglamp.matrix.api.MatrixWebApplication "
CLASS_PATH=" -classpath ${cwd}/../lib:${cwd}/../config:${cwd}/../lib/* "
DEBUG="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8055"
if [ "x$debug" == "x" ];then
    echo "nohup ${JAVA} ${SERVING_OPTS} ${CLASS_PATH} ${CLAZZ} > start.out 2>&1 &"
    nohup ${JAVA} ${SERVING_OPTS} ${CLASS_PATH} ${CLAZZ} > start.out 2>&1 &
else
    echo  "${JAVA} ${DEBUG} ${SERVING_OPTS} ${CLASS_PATH} ${CLAZZ}"
    nohup ${JAVA} ${DEBUG} ${SERVING_OPTS} ${CLASS_PATH} ${CLAZZ}  > start.out 2>&1 &
fi

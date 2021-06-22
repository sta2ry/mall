FROM adoptopenjdk/openjdk16:alpine as builder

ENV LANG=en_US.utf8 \
    TZ=Asia/Shanghai \
    SVC_HOME=/home/featx \
    SVC_ENV=DEV

COPY . $SVC_HOME/mall/

RUN set -ex &&\
#    apk add -U git &&\
    cd $SVC_HOME/mall &&\
#    git clone https://github.com/sta2ry/mall.git &&\
#    cd mall &&\
    chmod +x ./gradlew &&\
    ./gradlew build -x test --refresh-dependencies

FROM adoptopenjdk/openjdk16:alpine-jre

ENV LANG=en_US.utf8 \
    TZ=Asia/Shanghai \
    SVC_HOME=/home/featx \
    SVC_ENV=DEV

#   SW_AGENT_NAME=api-search \
#   SW_AGENT_COLLECTOR_BACKEND_SERVICES=172.17.0.6:11800
#   -javaagent:/mnt/local/apache.com/skywalking/agent/skywalking-agent.jar
COPY --from=builder $SVC_HOME/mall/build/libs/mall-0.0.1-SNAPSHOT.jar ${SVC_HOME}/

WORKDIR $SVC_HOME

RUN set -ex &&\
  mkdir log &&\
  cp /usr/share/zoneinfo/$TZ /etc/localtime &&\
  date

EXPOSE 7101
# Remote Debug Usage: Expose the debug port to host, And add the agent JOPTS to java CMD
# EXPOSE 5005
# "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005",
HEALTHCHECK --interval=5s --timeout=3s CMD curl -f http://127.0.0.1:7101/actuator/health || exit 1
CMD ["java", "-Xms512m", "-Xmx512m", "-XX:MetaspaceSize=128m", "-XX:MaxMetaspaceSize=256m", "-jar", "mall-0.0.1-SNAPSHOT.jar", ">", "mall.log"]
#FROM openjdk:17-jdk-alpine
#MAINTAINER Lamadrid
#COPY target/demo-api-server-0.0.1-SNAPSHOT.jar demo-api-server.jar
#ENTRYPOINT ["java","-jar","/demo-api-server.jar"]

FROM maven:latest AS maven

WORKDIR /usr/src/app
COPY . /usr/src/app
# Compile and package the application to an executable JAR
RUN mvn package

FROM openjdk:17-jdk-alpine

ARG JAR_FILE=demo-api-server-redis.jar

WORKDIR /opt/app

# Copy the jar from the maven stage to the /opt/app directory of the current stage.
COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/

EXPOSE 8080

ENTRYPOINT ["java","-jar","demo-api-server-redis.jar"]

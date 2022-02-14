# For Java 11, try this
# FROM adoptopenjdk/openjdk11:alpine-jre

# For Java 8, try this
FROM openjdk:8-jdk-alpine

WORKDIR /opt/app
ARG JAR_FILE=../target/demo-0-0-1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
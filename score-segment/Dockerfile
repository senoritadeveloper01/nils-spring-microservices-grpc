FROM openjdk:16-jdk-alpine
LABEL MAINTAINER="https://github.com/senoritadeveloper01"
LABEL APPLICATION="Score Segment"
WORKDIR /usr/app
COPY target/score-segment-0.0.1-SNAPSHOT.jar score-segment-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","score-segment-0.0.1-SNAPSHOT.jar"]
EXPOSE 8100
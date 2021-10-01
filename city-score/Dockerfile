FROM openjdk:16-jdk-alpine
LABEL MAINTAINER="https://github.com/senoritadeveloper01"
LABEL APPLICATION="City Score"
WORKDIR /usr/app
COPY target/city-score-0.0.1-SNAPSHOT.jar city-score-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","city-score-0.0.1-SNAPSHOT.jar"]
EXPOSE 8000
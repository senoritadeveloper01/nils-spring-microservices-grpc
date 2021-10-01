FROM openjdk:16-jdk-alpine
LABEL MAINTAINER="https://github.com/senoritadeveloper01"
LABEL APPLICATION="Score Calculator"
WORKDIR /usr/app
COPY target/score-calculator-0.0.1-SNAPSHOT.jar score-calculator-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","score-calculator-0.0.1-SNAPSHOT.jar"]
EXPOSE 8200
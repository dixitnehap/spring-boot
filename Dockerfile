FROM openjdk:8-jdk-alpine
MAINTAINER dixitnehap
EXPOSE 8080
COPY target/employee-db-operation-0.0.1-SNAPSHOT.jar employee-db-operation-0.0.1.jar
ENTRYPOINT ["java","-jar","/employee-db-operation-0.0.1.jar"]
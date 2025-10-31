#FROM amazoncorretto:21-alpine3.22
#
#WORKDIR /app
#
#COPY target/*.jar app.jar
#
#EXPOSE 8080
#
#ENTRYPOINT ["java","-jar","app.jar"]

#===============================Multi-stage Dockerfile=================================

#Build
FROM maven:3.9-amazoncorretto-21-alpine AS builder

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean test package -DskipTests=false

#Runtime
FROM amazoncorretto:21-alpine3.22 AS runtime

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

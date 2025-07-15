# Etapa 1: build
FROM maven:3.9.4-eclipse-temurin-17 AS builder

WORKDIR /app

COPY demo/ /app

RUN mvn clean package -DskipTests

# Etapa 2: run
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]

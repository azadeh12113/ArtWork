# Use official Maven with OpenJDK 17 for build stage
FROM maven:3.8.8-eclipse-temurin-17 AS build

WORKDIR /app

# Copy the project files
COPY . .

# Build the application (Creates JAR file in target/)
RUN mvn clean package -DskipTests

# Use a lightweight JDK image for running the app
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the built JAR from previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]

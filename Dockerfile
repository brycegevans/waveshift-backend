# Use JDK 20 as your app is built with Java 20
FROM openjdk:20-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy the built JAR into the container
COPY target/wave-api-1.0-SNAPSHOT.jar app.jar

# Expose the port Spring Boot runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
# Use a base image with JDK installed
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built jar file into the container
COPY target/combined-service-0.0.1-SNAPSHOT.jar combined-service.jar

# Specify the command to run the application
ENTRYPOINT ["java", "-jar", "combined-service.jar"]

# Expose port 8083 for the service

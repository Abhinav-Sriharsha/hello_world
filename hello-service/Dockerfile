# Use the official OpenJDK image as a base
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory into the container
COPY target/hello-service-0.0.1-SNAPSHOT.jar hello-service.jar

# Specify the command to run the JAR file
ENTRYPOINT ["java", "-jar", "hello-service.jar"]

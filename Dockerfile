# Use a base image that supports Java
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY build/libs/matchup2-0.0.1-SNAPSHOT.jar /app/matchup2.jar

# Specify the command to run your application
CMD ["java", "-jar", "matchup2.jar"]


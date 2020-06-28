# Use official base image of Java Runtim
FROM openjdk:8-jdk-alpine

# Set volume point to /tmp
VOLUME /tmp

# Set application's JAR file
ARG JAR_FILE=target/*.jar

# Add the application's JAR file to the container
ADD ${JAR_FILE} app.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app.jar"]
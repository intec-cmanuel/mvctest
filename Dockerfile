# Use the official OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /MVCDeploymentDemo

# Copy the build file(s) needed for dependency resolution
COPY build.gradle settings.gradle /MVCDeploymentDemo/

# Copy the gradle wrapper files
COPY gradlew /MVCDeploymentDemo/
COPY gradle /MVCDeploymentDemo/gradle

# Grant execute permissions to the Gradle wrapper script
RUN chmod +x /MVCDeploymentDemo/gradlew

# Download and resolve dependencies
RUN ./gradlew --no-daemon build -x test || return 0

# Copy the entire project
COPY . /MVCDeploymentDemo/

# Grant execute permissions to the Gradle wrapper script
RUN chmod +x /MVCDeploymentDemo/gradlew

# Build the application
RUN ./gradlew --no-daemon build -x test

# Expose the port that your application will run on
EXPOSE 8080

# Specify the command to run on container startup
CMD ["java", "-jar", "build/libs/MVCDeploymentDemo-0.0.1-SNAPSHOT.jar"]

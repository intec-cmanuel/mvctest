# Use the official OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the build file(s) needed for dependency resolution
COPY build.gradle settings.gradle /app/

# Copy the gradle wrapper files
COPY gradlew /app/
COPY gradle /app/gradle

# Grant execute permissions to the Gradle wrapper script
RUN chmod +x /app/gradlew

# Download and resolve dependencies
RUN ./gradlew --no-daemon build || return 0

# Copy the entire project
COPY . /app/

# Build the application
RUN ./gradlew --no-daemon build

# Expose the port that your application will run on
EXPOSE 8080

# Specify the command to run on container startup
CMD ["java", "-jar", "build/libs/your-application-name.jar"]

# Use Java 21 JDK
FROM eclipse-temurin:21-jdk-jammy

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml first (for caching)
COPY mvnw pom.xml ./
COPY .mvn .mvn

# Copy the rest of your source code
COPY src src

# Make Maven wrapper executable
RUN chmod +x mvnw

# Build the app (skip tests to make it faster)
RUN ./mvnw clean package -DskipTests

# Expose port your app uses
EXPOSE 8081

# Run the Spring Boot application
CMD ["java", "-jar", "target/roommate-portal-api-0.0.1-SNAPSHOT.jar"]

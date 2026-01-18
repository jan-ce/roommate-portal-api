# Use Java 21 JDK
FROM eclipse-temurin:21-jdk-jammy

# Set working directory
WORKDIR /app

# Copy pom.xml first (for caching)
COPY pom.xml ./

# Copy source code
COPY src src

# Install Maven (inside container)
RUN apt-get update && apt-get install -y maven

# Build the app (skip tests to make it faster)
RUN mvn clean package -DskipTests

# Expose port your app uses
EXPOSE 8081

# Run the Spring Boot application
CMD ["java", "-jar", "target/roommate-portal-api-0.0.1-SNAPSHOT.jar"]

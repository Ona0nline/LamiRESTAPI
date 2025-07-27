# Stage 1: Build the JAR
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copy Maven project
COPY . .

# Build the JAR
RUN mvn clean package -DskipTests

# Stage 2: Run the app
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/lami-backend-0.0.1-SNAPSHOT.jar lami-backend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "lami-backend-0.0.1-SNAPSHOT.jar"]


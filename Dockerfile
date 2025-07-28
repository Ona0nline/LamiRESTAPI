# Stage 1: Build the application
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app
COPY . .

# Build the application and skip tests
RUN mvn clean package -DskipTests

# DEBUG: List contents of target to verify the jar was built
RUN ls -l /app/target

# Stage 2: Run the application
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy wait-for-it script
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# Copy the jar from the build stage
COPY --from=build /app/target/lami-backend-0.0.1-SNAPSHOT.jar /app/lami-backend-0.0.1-SNAPSHOT.jar


# DEBUG: List contents of /app to ensure jar is present
RUN ls -l /app

# Use wait-for-it to wait for the database before starting the app
ENTRYPOINT ["/wait-for-it.sh", "lami-sql:3306", "--", "java", "-jar", "/app/lami-backend-0.0.1-SNAPSHOT.jar"]

# Stage 1: Build the JAR
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copy Maven project
COPY . .

# Build the JAR
RUN mvn clean package -DskipTests

# Copy wait-for-it script
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# Stage 2: Run the app
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copy the JAR and wait-for-it.sh script from the build stage
COPY --from=build /app/target/lami-backend-0.0.1-SNAPSHOT.jar lami-backend-0.0.1-SNAPSHOT.jar
COPY --from=build /wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# Use wait-for-it to wait for the MySQL container
ENTRYPOINT ["/wait-for-it.sh", "lami-mysql:3306", "--", "java", "-jar", "app.jar"]

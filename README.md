# LamiRESTAPI
## Project Overview
Lami is a private backend API built with Spring Boot to power a ride-sharing concept app.
It is not intended for public use or collaboration — this project exists solely as a showcase
to demonstrate backend engineering skills, working with databases, API design, and containerization.

## Project Background
Lami began as a simple object-oriented programming exercise focused on inheritance. As I expanded its
functionality, my curiosity led me to dive deeper into backend development using Spring Boot and MySQL
instead of SQLite3. Along the way, I also learned how to integrate external APIs — specifically the Google Maps 
API in Java — which was a new challenge beyond my previous experience with other APIs like weather or AI APIs.

This project became a personal journey of growth, combining backend skills, database management, and API integrations.


🛠️ Tech Stack

Java 21, Spring Boot, Spring Data JPA (Hibernate), MySQL, Docker & Docker Compose, Maven

## Features
1. User registration and login functionality
2. Profile management and editing
3. Endpoint to view available rides based on user location
4. Ride request submission and management
5. Automatic database schema update using Hibernate’s DDL auto feature
6. SQL query logging for easy debugging

## 🐳 Getting Started with Docker
You can run the entire Lami application (backend + MySQL database) using Docker in just a few commands.

✅ Prerequisites
1. Docker installed
2. Docker Compose installed (included by default with Docker Desktop)

Clone or download the project if you want to access the docker-compose.yml file.
 ```
git clone https://github.com/<your-username>/lami-backend.git
cd lami-backend
docker-compose up --build
```

## 🔧Run with Maven (If Docker isn’t available)
Start a local MySQL instance with:
DB name: lami_db
Username: root
Password: On@0nlin3SQL

```bash
./mvnw clean install
java -jar target/lami-0.0.1-SNAPSHOT.jar
```

📌 What this does:
Spins up a MySQL container (lami_db) with seeded credentials
Launches the Spring Boot backend API on port 9090, already connected to the database

🌐 Access
Backend is available at:
👉 http://localhost:9090

## 📬 Postman Collections
[Lami](./Lamis.postman_collection.json)
[LamiLux](./Lux.postman_collection.json)
[Taxi](./Taxi.postman_collection.json)
[Users](./User.postman_collection.json)

## How to Test the API

1. Download and install [Postman](https://www.postman.com/downloads/).  
2. Import any of the Postman collection files from this repo (e.g., `Lamis.postman_collection.json`) via File → Import.  
3. Use the preconfigured requests to explore and test the API endpoints.  
4. Make sure the backend is running locally on port 9090 (or your configured port).


## 🙋‍♂️ Author
Onalerona Sihle Zwane
I’m a junior full stack engineer and final year WeThinkCode_ student passionate about backend development and building scalable, maintainable systems.
I find joy in crafting APIs that solve real problems and appreciate challenges that push me to learn new technologies.

While I’ve dabbled in frontend development, backend work excites me more — especially designing robust APIs and connecting with external services.


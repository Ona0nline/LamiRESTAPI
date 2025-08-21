# LamiRESTAPI
## Project Overview
**Lami** is a ride-sharing app designed to serve users across South Africa, regardless of socio-economic status.
The service empowers users by letting them choose their own drivers based on optional perks that each driver may offer — such as curated playlists, bottled water, and more. This user-driven approach gives people control over the kind of ride experience they want.

**LamiLux** is the premium tier of the platform, offering luxury rides for high-end users with active subscriptions. 
These rides feature more upscale vehicles and exclusive perks.

**LamiTaxi** is a practical feature that, based on a user's current location, lists all taxi ranks that have routes that contain that route, whether it is exact or accurate to about 100m away. It also has the ability to let a user know whether or not a taxi is likely on it's way based off of whether the location they are currently on falls within a taxi route. Users can then choose the relevant taxi rank/ wait for the taxi to come along. The service also includes a hand signals guide for users who are not too sure how to stop a taxi.

🛠️ Next Steps
* Implement an AI chatbot to advise users on the best ride type based on their location, preferences, and urgency.
* I am in the process of migrating the entire persistance logic to work with postgresSQL instead of MySQL for easier geospatial querying.

## Project Background
Lami began as a simple object-oriented programming exercise focused on inheritance. As I expanded its
functionality in the console asking questions such as "How would I even hypothetically track drivers?" or "How would I calculate the fare?", my curiosity led me to dive deeper into backend development using Spring Boot and MySQL instead of SQLite3. Along the way, I also learned how to integrate external APIs — specifically the Google Maps 
API in Java and now more recently the OSRM API — which was a new challenge beyond my previous experience with other APIs like weather or OpenAI APIs.

This project became a personal journey of growth, combining backend skills, database management, and API integrations.

🛠️ Tech and Tool Stack

Java 21, Spring Boot, MySQL and PostgresSQL, Postman for Api documentation, Docker for containerization, looking to migrate to AWS services very soon.

## Features
1. User registration and login functionality
2. Profile management and editing
3. Endpoint to view available rides based on user location
4. Ride request submission and management
5. Functionality to easily add new snapped taxi routes to the database


## 🐳 Getting Started with Docker
You can run the entire Lami application (backend + MySQL database) using Docker in just a few commands.

✅ Prerequisites
1. Docker installed
2. Docker Compose installed (included by default with Docker Desktop)

Clone or download the project if you want to see the codebase.
 ```
git clone https://github.com/<your-username>/lami-backend.git
```

🌐 Access
Backend is available at if you would like to test a few endpoints, project is still heavily in development though so I can't promise you that they will work all teh time:
👉 http://localhost:9090

## 📬 Postman Collections
1. [Lami](./Lamis.postman_collection.json)
2. [LamiLux](./Lux.postman_collection.json)
3. [Taxi](./Taxi.postman_collection.json)
4. [Users](./User.postman_collection.json)

## How to Test the API
1. Download and install [Postman](https://www.postman.com/downloads/).  
2. Import any of the Postman collection files from this repo (e.g., `Lamis.postman_collection.json`) via File → Import.  
3. Use the preconfigured requests to explore and test the API endpoints.  
4. Make sure the backend is running locally on port 9090 (or your configured port).

## 🙋‍♂️ Author
Onalerona Sihle Zwane
I’m a junior full stack engineer, solutions architect and final year WeThinkCode_ student passionate about backend development and building scalable, maintainable systems.
I find joy in crafting APIs that solve real problems and appreciate challenges that push me to learn new technologies.

While I’ve dabbled in frontend development, backend work excites me more — especially designing robust APIs and connecting with external services.


# Waveshift Backend – `wave-api`

This is the backend API for the Waveshift project, built with **Spring Boot**, deployed to **Fly.io**, and using **Neon PostgreSQL** for the database.

---

## 📁 Project Structure

wave-api/

    Dockerfile

    src/
 
    target/

    pom.xml

    fly.toml

    README.md

### 🔧 1. Build the JAR

Before deploying, build the project using Maven:

    cd wave-api
    mvnw clean package
---
## 🚀 Deploying to Fly.io

This project is fully Dockerized and deploys via the Fly.io CLI. 
    
    fly launch
Select a region (closest to you or your users)

Use the detected Dockerfile

Skip database setup — Neon handles the DB

Configure Neon PostgreSQL credentials
---
    fly secrets set \
    SPRING_DATASOURCE_URL="jdbc:postgresql://<neon-host>:5432/waveshift?sslmode=require" \
    SPRING_DATASOURCE_USERNAME=neondb_owner \
    SPRING_DATASOURCE_PASSWORD=<your_password>
in application.properties change properties to 

    spring.datasource.url=${SPRING_DATASOURCE_URL}
    spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
    spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}
Deploy
---
once secrets are set

    fly deploy

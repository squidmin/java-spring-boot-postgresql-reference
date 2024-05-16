# java17-spring-boot-postgresql-reference

Reference repository for Spring Boot applications that interact with a PostgreSQL database.

## Build the application

```bash
./gradlew build
```

## Build and run the containers

```bash
docker-compose run --rm -it app ./gradlew bootRun
```

## Stop and remove all containers

```bash
docker-compose down
```

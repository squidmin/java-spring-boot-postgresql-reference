FROM openjdk:17-jdk-slim
COPY . /app
WORKDIR /app
RUN ./gradlew clean build -x test
CMD ["./gradlew", "bootRun"]


FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/gokapture-0.0.1-SNAPSHOT.jar /app/gokapture-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "gokapture-0.0.1-SNAPSHOT.jar"]

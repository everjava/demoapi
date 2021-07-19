FROM adoptopenjdk/openjdk11:latest
FROM maven

WORKDIR "/app"
ADD . /app
RUN mvn clean package install


ENTRYPOINT ["java", "-jar", "target/demoapi-0.0.1-SNAPSHOT.jar"]
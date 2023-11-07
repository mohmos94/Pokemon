FROM openjdk:21-jdk

WORKDIR /app
COPY ./src/main/config-sets opt/api/etc
COPY target/Pokemon-0.0.1-SNAPSHOT.jar Pokemon-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "Pokemon-0.0.1-SNAPSHOT.jar"]

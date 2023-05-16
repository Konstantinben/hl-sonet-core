FROM marceloagmelo/maven-3.6.3-openjdk-11 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

FROM openjdk:11
COPY --from=build /home/app/target/sonet-core-0.0.1-SNAPSHOT.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
EXPOSE 8080
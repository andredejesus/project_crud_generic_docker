FROM openjdk:11

EXPOSE 8080

WORKDIR /app

COPY target/project-0.0.1-SNAPSHOT.jar /app/spring-app.jar

ENTRYPOINT ["java", "-jar", "spring-app.jar"]


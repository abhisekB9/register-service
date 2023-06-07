FROM openjdk:11

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} registerservice.jar

ENTRYPOINT ["java", "-jar", "/registerservice.jar"]

EXPOSE 8080
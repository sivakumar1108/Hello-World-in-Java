FROM openjdk:17

WORKDIR /app

COPY HelloWorld-release.jar /app/HelloWorld-release.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/HelloWorld-release.jar"]
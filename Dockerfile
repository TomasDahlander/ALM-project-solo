FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8080

ARG JAR_FILE=target/*.jar

WORKDIR /myfolder

COPY ${JAR_FILE} app.jar

#ENV SPRING_PROFILES_ACTIVE=prod

ENTRYPOINT ["java", "-jar", "app.jar"]

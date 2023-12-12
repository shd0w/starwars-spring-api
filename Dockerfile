FROM amazoncorretto:17-alpine-jdk

LABEL authors="shd0w (Johnny Rios)"

WORKDIR /app

COPY ./target/*.jar ./starwars-api.jar

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} -jar starwars-api.jar"]
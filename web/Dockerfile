FROM openjdk:11
EXPOSE 8080
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} restaurant-review.jar
ENTRYPOINT ["java", "-jar", "restaurant-review.jar"]

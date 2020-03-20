FROM openjdk:8-jdk
ADD build/libs/*.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 8080

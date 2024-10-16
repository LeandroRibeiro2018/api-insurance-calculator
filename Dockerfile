FROM maven:3.8.3-openjdk-17 As build

# Copy folder in docker
WORKDIR /opt/app

COPY ./ /opt/app
RUN mvn clean install -DskipTests


# Run spring boot in Docker
FROM openjdk:17-jdk-alpine

COPY --from=build /opt/app/target/api-insurance-calculator-0.0.1-SNAPSHOT.jar app.jar


ENV PORT 8080
EXPOSE $PORT
ENTRYPOINT ["java","-jar","-Xmx1024M","-Dserver.port=${PORT}","app.jar"]
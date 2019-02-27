FROM maven:latest as maven-build
WORKDIR /build
COPY pom.xml .
RUN mvn verify --fail-never
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:8
WORKDIR /opt/website
COPY --from=maven-build /build/target/InspectorFacade-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "app.jar"]

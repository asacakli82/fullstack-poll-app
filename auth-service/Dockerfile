#### Stage 1: Build the application
FROM maven:3.6.3-adoptopenjdk-11-openj9 as target

WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ /build/src/
RUN mvn package

# Step : Package image
FROM maven:3.6.3-adoptopenjdk-11-openj9
CMD exec java $JAVA_OPTS -jar /app/my-app.jar
COPY --from=target /build/target/*.jar /app/my-app.jar
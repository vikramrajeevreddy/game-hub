#FROM openjdk:8-jdk-alpine
#COPY target/*.jar app.jar
#EXPOSE 5000
#ENTRYPOINT ["java","-jar","/app.jar"]

# Start with a base image containing Java runtime
FROM adoptopenjdk:8-jdk


# Make port 8080 available to the world outside this container
#EXPOSE 9025

# The application's jar file
ARG JAR_FILE=target/game-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} game-0.0.1-SNAPSHOT.jar

ENV JAVA_OPTS="-Dfile.encoding=UTF-8 -Xms128m -Xmx2500m -XX:PermSize=64m -XX:MaxPermSize=3000m"

# Run the jar file
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/mrkecom.jar"]

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /game-0.0.1-SNAPSHOT.jar" ]


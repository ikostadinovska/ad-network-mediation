# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
# copy WAR into image
COPY target/admediation-1.0-SNAPSHOT.jar /opt/admediation-1.0-SNAPSHOT.jar
# run application with this command line
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/opt/admediation-1.0-SNAPSHOT.jar"]
FROM openjdk:jre-alpine

COPY target/qa-0.0.1-SNAPSHOT.jar /opt/gft.jar

EXPOSE 8080
# preferIPv4Stack is needed to keep wildfly-swarm happy
ENTRYPOINT ["java", "-Djava.net.preferIPv4Stack=true", "-jar", "/opt/gft.jar"]

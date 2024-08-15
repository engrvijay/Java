FROM openjdk:21-jdk
COPY build/jar/ClientJTCP.jar /app/java/
WORKDIR /app/java
ENTRYPOINT ["java", "-jar", "ClientJTCP.jar"]
CMD ["server","port"]

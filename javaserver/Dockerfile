FROM openjdk:21-jdk
COPY build/jar/ServerJTCP.jar /app/java/
WORKDIR /app/java
ENV JAVA_HOME /usr/lib/jvm/java-21-openjdk-amd64
ENV PATH $PATH:$JAVA_HOME/bin
ENTRYPOINT ["java", "-jar", "ServerJTCP.jar", "6066"]

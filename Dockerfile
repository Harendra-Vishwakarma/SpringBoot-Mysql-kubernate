FROM openjdk:17.0.1-jdk

WORKDIR /app

COPY target/root.jar /app

ENTRYPOINT ["java","-jar","root.jar"]
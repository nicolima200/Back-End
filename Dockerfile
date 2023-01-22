FROM amazoncorretto:19-alpine-jdk 
MAINTAINER nico
COPY target/nico-0.0.1-SNAPSHOT.jar  nico-app.jar
ENTRYPOINT["java","-jar","/nico-app.jar"]
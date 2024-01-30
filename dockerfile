FROM openjdk:17-jdk-alpine
COPY target/urlcorto-0.0.1-SNAPSHOT.jar urlcorto.jar

ENTRYPOINT [ "java", "-jar" , "urlcorto.jar"]
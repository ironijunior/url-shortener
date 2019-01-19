FROM openjdk:8
COPY target/url-shortener.jar url-shortener.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "url-shortener.jar"]
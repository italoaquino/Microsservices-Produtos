FROM openjdk:11

RUN mkdir -p /app/produto

COPY /target/produtos-0.0.1-SNAPSHOT.jar /app/produto/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/produto/produtos-0.0.1-SNAPSHOT.jar"]
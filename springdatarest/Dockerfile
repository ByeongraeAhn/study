# docker pull openjdk:8-jdk-alpine
# docker build --tag test:0.1 ./
# docker run -p 8080:8080 test:0.1
# curl -H "Content-Type: application/json" -X GET http://localhost:8080/users

FROM openjdk:8-jdk-alpine
VOLUME ./tmp
COPY test.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
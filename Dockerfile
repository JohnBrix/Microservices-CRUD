FROM openjdk:11
ADD target/microservices-crud.jar microservices-crud.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","microservices-crud.jar"]


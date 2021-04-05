FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/microservices-crud.jar microservices-crud.jar
EXPOSE 8081
#ENTRYPOINT ["./wait-for-it.sh", "mysql-standalone:3306", "--", "java", "-jar", "microservices-crud.jar"]
ENTRYPOINT ["java","-jar","microservices-crud.jar"]


FROM amazoncorretto:17
ADD /target/*.jar application.jar
CMD apt-get update -y
ENTRYPOINT ["java", "-Xmx2048M", "-jar", "/application.jar"]
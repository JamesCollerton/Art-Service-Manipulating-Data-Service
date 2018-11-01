FROM openjdk:8-jdk-alpine
LABEL maintainer="jamescollerton@live.co.uk"
VOLUME /tmp
ADD /target/artservicegateway*.jar artservicegateway.jar
CMD java -jar artservicegateway.jar
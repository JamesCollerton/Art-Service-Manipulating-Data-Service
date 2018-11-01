FROM openjdk:8-jdk-alpine
LABEL maintainer="jamescollerton@live.co.uk"
VOLUME /tmp
ADD /target/artservicemanipulatingdataservice*.jar artservicemanipulatingdataservice.jar
CMD java -jar artservicemanipulatingdataservice.jar

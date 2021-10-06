FROM java:8
EXPOSE 8080
ADD /target/conference.jar conference.jar
ENTRYPOINT ["java","-war","conference.war"]

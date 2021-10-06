FROM java:8
EXPOSE 8080
ADD /target/conference.war conference.war
ENTRYPOINT ["java","-war","conference.war"]

FROM tomcat
EXPOSE 8080
ADD /target/conference.war conference.war
ENTRYPOINT ["catalina.sh","run"]

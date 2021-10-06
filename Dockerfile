FROM tomcat:9.0.53
EXPOSE 8080
ADD /target/conference.war /usr/local/tomcat/webapps/conference.war
ENTRYPOINT ["catalina.sh","run"]

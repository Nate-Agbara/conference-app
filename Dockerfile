FROM tomcat
EXPOSE 8080
ADD /target/conference.war /usr/local/tomcat/webapps/conference.war
ENTRYPOINT ["catalina.sh","run"]

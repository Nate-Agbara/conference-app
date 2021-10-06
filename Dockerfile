FROM tomcat:9.0.53
EXPOSE 8080
RUN adduser -D tomcat; chown -R tomcat:tomcat /usr/local/tomcat
USER tomcat
ADD /target/conference.war /usr/local/tomcat/webapps/conference.war
ENTRYPOINT ["catalina.sh","run"]

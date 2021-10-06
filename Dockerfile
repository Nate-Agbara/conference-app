FROM tomcat
EXPOSE 8080
ADD /target/conference.war conference.war
ENTRYPOINT ["tomcat","-war","conference.war"]

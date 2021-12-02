FROM openjdk:17.0.1
ADD MoesCrud.jar MoesCrud.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar","/MoesCrud.jar"]
# VOLUME /tmp
# ARG JAR_FILE
# COPY ${JAR_FILE} app.jar



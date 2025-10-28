FROM eclipse-temurin:17-jre-windowsservercore-ltsc2022

SHELL ["cmd", "/S", "/C"]
WORKDIR C:/app

# MUDA ISSO:
# ARG JAR_FILE=target\EmployeeManagementAPI-0.0.1-SNAPSHOT.jar
# COPY %JAR_FILE% C:/app/app.jar

# PARA ISSO:
COPY target/*.jar C:/app/app.jar

ENV SERVER_PORT=8092
ENV SERVER_SERVLET_CONTEXT_PATH=/api
ENV SPRING_DATASOURCE_URL=
ENV SPRING_DATASOURCE_USERNAME=
ENV SPRING_DATASOURCE_PASSWORD=
ENV JAVA_OPTS=

EXPOSE 8092
ENTRYPOINT ["cmd","/S","/C","java %JAVA_OPTS% -Dserver.port=%SERVER_PORT% -Dserver.servlet.context-path=%SERVER_SERVLET_CONTEXT_PATH% -jar C:/app/app.jar"]
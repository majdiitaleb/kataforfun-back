FROM adoptopenjdk/openjdk8:alpine-slim
EXPOSE 8080
ARG JAR_FILE=target/*.jar
RUN addgroup -S pipeline && adduser -S k8s-pipeline -G mejditest
COPY ${JAR_FILE}  /home/k8s-pipeline-test/app.jar
USER mejditest
ENTRYPOINT ["java","-jar","/home/k8s-pipeline-test/kataforfun.jar"]
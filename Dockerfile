FROM adoptopenjdk/openjdk8:alpine-slim
EXPOSE 8080
ARG JAR_FILE=target/*.jar
RUN addgroup -S mejditest && adduser -S k8s-pipeline-test -G mejditest
COPY ${JAR_FILE}  /home/k8s-pipeline-test/app.jar
USER k8s-pipeline-test
ENTRYPOINT ["java","-jar","/home/k8s-pipeline-test/kataforfun.jar"]
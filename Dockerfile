FROM amazoncorretto:17-alpine

ENV APP_HOME=/usr/app
ENV JAR_FILE=auth-security-0.0.1-SNAPSHOT.jar

WORKDIR $APP_HOME
COPY ./build/libs/$JAR_FILE .

EXPOSE 9000

ENTRYPOINT ["sh", "-c", "java -jar $JAR_FILE"]

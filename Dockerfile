FROM store/oracle/serverjre:8

RUN cd / && mkdir -p /haa/services

WORKDIR /haa/services

COPY target/restful*.jar .

# RUN JAR_FILE=`ls | grep restful`

CMD java -jar restful-web-services-0.0.1-SNAPSHOT.jar

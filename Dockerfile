FROM openjdk:11
VOLUME /tmp
ADD target/piexchange-0.1.jar piexchange-0.1.jar
EXPOSE 8080
COPY wait-for-it.sh wait-for-it.sh 
RUN chmod +x wait-for-it.sh
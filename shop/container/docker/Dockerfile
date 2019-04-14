FROM openjdk:8-jdk-alpine
RUN mkdir -p /app
ADD shop-0.0.1-SNAPSHOT.jar /app
ADD run.sh run.sh 
RUN chmod +x run.sh
CMD ./run.sh

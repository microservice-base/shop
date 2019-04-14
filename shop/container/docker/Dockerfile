FROM openjdk:8-jdk-alpine
RUN mkdir -p /app
ADD app.jar /app
ADD run.sh run.sh 
RUN chmod +x run.sh
CMD ["./run.sh"]

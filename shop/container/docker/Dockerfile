FROM openjdk:8-jdk-alpine
RUN mkdir -p /app
ADD app.jar /app
ADD app.sh app.sh 
RUN chmod +x app.sh
EXPOSE 8001
CMD ["./app.sh"]

# FROM openjdk:8-jdk-alpine
FROM gradle:jdk8 as builder
RUN printenv

RUN git clone https://github.com/microservice-base/shop.git

WORKDIR shop/shop

#RUN ./gradlew build --refresh-dependencies
#RUN ./gradlew build
RUN gradle build 


 #FROM alpine:latest
FROM openjdk:8-jdk-alpine
 #RUN apk add -U tzdata
 #RUN cp /usr/share/zoneinfo/Europe/Istanbul /etc/localtime
COPY --from=builder /home/gradle/shop/shop/build/libs/ .
COPY --from=builder /home/gradle/shop/container/observability/ .

CMD ["/bin/echo", "Hello world"]


#VOLUME /myvol

#CMD ["java", "-jar", "shop-0.0.1-SNAPSHOT.jar"]

# RUN mkdir -p /app
# ADD app.jar /app
# ADD app.sh app.sh 
# RUN chmod +x app.sh
# # EXPOSE 8001 bu dışarı açmak yerine diğer containerler için miş araştır?
# CMD ["./app.sh"]

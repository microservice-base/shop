# FROM openjdk:8-jdk-alpine
FROM gradle:alpine as builder
RUN printenv

# WORKDIR /Users/ko/workspace/ws-eclipse/shop

COPY --chown=gradle:gradle . $HOME

RUN echo $HOME

RUN  cd $HOME/shop && \
    gradle build
    

# FROM alpine:latest
FROM openjdk:8-jdk-alpine
#RUN apk add -U tzdata
#RUN cp /usr/share/zoneinfo/Europe/Istanbul /etc/localtime
COPY --from=builder /home/gradle/shop/build/libs/ .
CMD ["java", "-jar", "shop-0.0.1-SNAPSHOT.jar"]

# RUN mkdir -p /app
# ADD app.jar /app
# ADD app.sh app.sh 
# RUN chmod +x app.sh
# # EXPOSE 8001 bu dışarı açmak yerine diğer containerler için miş araştır?
# CMD ["./app.sh"]

# shop

https://microservice-base.github.io/

# API

## ui

http://localhost:8001/shop/swagger-ui.html

## terminal

curl --request GET http://localhost:8001/shop/prouductapi/products



## docker image oluşturmak

Gradle yüklü olmalıdır.
```
git clone https://github.com/microservice-base/shop.git


cd shop/shop && ./gradlew build && cp build/libs/*.jar ./container/docker/app.jar && cd container/docker/ && docker build -t image-shop:v1 . && docker run -d --name shopproject -p 8001:8001 image-shop:v1

docker run -d --name shopproject -p 8001:8001 openjdk:8-jdk-alpine

docker ps

docker exec -it shopproject /bin/sh

```


## yapılacaklar
image dişarıya bir port üzerinden açılacak.(uygulamanını portu)

container klasörü projenin bir üst klasörüne çıkartabilirim

# shop

https://microservice-base.github.io/



## docker image oluşturmak

Gradle yüklü olmalıdır.
```
git clone https://github.com/microservice-base/shop.git


cd shop/shop && ./gradlew build --refresh-dependencies && cp build/libs/*.jar ./container/docker/app.jar && cd container/docker/ && docker build -t image-shop:v1 . && docker run -d --name project-shop -p 8001:8001 image-shop:v1

docker ps

docker exec -it shopproject /bin/sh

```

# API

## ui

http://localhost:8001/shop/swagger-ui.html

## terminal

curl --request GET http://localhost:8001/shop/prouductapi/products


## yapılacaklar
konteyner oluşturulurken otomatik dockerfile üzerinden port alabilr mi ?

container klasörü projenin bir üst klasörüne çıkartabilirim

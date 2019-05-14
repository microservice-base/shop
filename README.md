# shop

https://microservice-base.github.io/


## docker image link
```
docker pull keramiozsoy/image-shop:v1

docker run -d --name project-shop -p 8001:8001 keramiozsoy/image-shop:v1

$ git clone https://github.com/microservice-base/shop.git
$ cd shop 
$ docker build  -t image-shop  -f container/docker/Dockerfile .
$ docker run -d --name project-shop -p 8001:8001 keramiozsoy/image-shop:latest

```

## api swagger ui

http://localhost:8001/shop/swagger-ui.html

## api terminal

curl --request GET http://localhost:8001/shop/prouductapi/products


## yapılacaklar
konteyner oluşturulurken otomatik dockerfile üzerinden port alabilr mi ?

container klasörü projenin bir üst klasörüne çıkartabilirim

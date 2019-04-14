# shop

https://microservice-base.github.io/

# API

## ui

http://localhost:8001/shop/swagger-ui.html

## terminal

curl --request GET http://localhost:8001/shop/prouductapi/products

##
git clone https://github.com/microservice-base/shop.git

## docker image oluşturuyor
```
cd shop/shop && ./gradlew build && cp build/libs/*.jar ./container/docker/app.jar && cd container/docker/ && docker build .


--
image dişarıya bir port üzerinden açılacak.(uygulamanını portu)
image a bir isim verilecek çünkü sadece bir image id si oluşuyor (isim ile oluşmalı)
container otomatik oluşmalıdır.

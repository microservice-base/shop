# shop

https://microservice-base.github.io


## docker image link
```
$ docker pull keramiozsoy/image-shop:latest

or 

$ git clone https://github.com/microservice-base/shop.git
$ cd shop 
$ docker build  -t image-shop  -f container/docker/Dockerfile .
$ docker run -d --name project-shop -p 8001:8001 keramiozsoy/image-shop:latest

```

## api swagger-ui

http://localhost:8001/shop/swagger-ui.html#/product-api

## kubernetes ( minikube )
```
$  kubectl create deployment image-shop-deployment --image=keramiozsoy/image-shop
$  kubectl expose deployment image-shop-deployment --type=LoadBalancer --port=8001

$  minikube service image-shop-deployment

$  kubectl delete service image-shop-deployment
$  kubectl delete deployment image-shop-deployment

```

## api terminal
```
$  curl --request GET http://localhost:8001/shop/prouductapi/products
```

## yapılacaklar
konteyner oluşturulurken otomatik dockerfile üzerinden port alabilr mi ?

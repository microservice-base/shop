# shop

https://microservice-base.github.io


## how to create project

```
Spring initializr

 https://start.spring.io/ 

project : gradle
language : java
spring boot : 2.0.6
group : com.shop
artifact : shop
name : shop
packaging : jar
java version : 8
dependencies : spring web
```


## how to run project

```
$ git clone https://github.com/microservice-base/shop.git
$ cd shop/shop/

$ ./gradlew build  # no need install Gradle for this command.
$ java -jar build/libs/shop-0.0.1-SNAPSHOT.jar
$ open http://localhost:8001/
$ open http://localhost:8001/swagger-ui.html

$ ./gradlew javadoc # for looking all class and methods
$ open build/docs/javadoc/index.html
```

## contributing

[Contributing guide](CONTRIBUTING.md).

## docker image
```
$ docker pull keramiozsoy/image-shop:latest

or 

$ git clone https://github.com/microservice-base/shop.git
$ cd shop 
$ docker build --no-cache  -t image-shop  -f container/docker/Dockerfile .
$ docker run -d --name app-shop -p 8001:8001 image-shop:latest

```

## api swagger-ui

open http://localhost:8001/swagger-ui.html#/product-api


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
$  curl --request GET http://localhost:8001/prouductapi/products
```

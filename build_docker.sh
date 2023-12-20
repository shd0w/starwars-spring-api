#!/bin/bash

IMAGE_NAME=riosjohnny/study:starwars-spring-api

docker rm \
  $(docker stop \
    $(docker ps -a -q --filter ancestor=$IMAGE_NAME)
  )

docker image rm $IMAGE_NAME

sleep 2

docker build -t $IMAGE_NAME .

sleep 2

docker run -dit --name SWAPI -p 8080:8080 -e SPRING_PROFILES_ACTIVE=teste \
$IMAGE_NAME
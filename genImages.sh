#!/usr/bin/env bash

sudo docker build -t $DMALL_DOCKER_REGISTRY/dmall/product-service:$BUILD_NUMBER .
sudo docker tag $DMALL_DOCKER_REGISTRY/dmall/product-service:$BUILD_NUMBER $DMALL_DOCKER_REGISTRY/dmall/product-service:latest

sudo docker push $DMALL_DOCKER_REGISTRY/dmall/product-service:$BUILD_NUMBER
sudo docker push $DMALL_DOCKER_REGISTRY/dmall/product-service:latest


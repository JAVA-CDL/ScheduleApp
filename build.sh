#!/bin/bash

echo "start........."

CLOUD_USERNAME=$1
CLOUD_PASSWORD=$2
CLOUD_IMAGE_PREFIX=$3
TAG=$4

echo "构建镜像"
docker build -t "$CLOUD_IMAGE_PREFIX":"$TAG" .
docker tag "$CLOUD_IMAGE_PREFIX":"$TAG" "$CLOUD_IMAGE_PREFIX":latest
echo "上传镜像"
docker login ccr.ccs.tencentyun.com --username="$CLOUD_USERNAME" --password="$CLOUD_PASSWORD"
docker push "$CLOUD_IMAGE_PREFIX":"$TAG"
docker push "$CLOUD_IMAGE_PREFIX":latest

echo "end........."
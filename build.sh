#!/bin/bash

echo "start........."

CLOUD_USERNAME=$1
CLOUD_PASSWORD="此处填写密码"
CLOUD_IMAGE_PREFIX=$2
TAG=$3

echo "构建镜像"
docker build -t "$CLOUD_IMAGE_PREFIX":"$TAG" .
docker tag "$CLOUD_IMAGE_PREFIX":"$TAG" "$CLOUD_IMAGE_PREFIX":latest
echo "上传镜像"
docker login ccr.ccs.tencentyun.com --username="$CLOUD_USERNAME" --password="$CLOUD_PASSWORD"
docker push "$CLOUD_IMAGE_PREFIX":"$TAG"
docker push "$CLOUD_IMAGE_PREFIX":latest
docker "删除镜像"
docker rmi "$CLOUD_IMAGE_PREFIX":"$TAG"
docker rmi "$CLOUD_IMAGE_PREFIX":latest

echo "end........."
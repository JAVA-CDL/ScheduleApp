#!/bin/bash

CLOUD_USERNAME="100011397258"
CLOUD_PASSWORD=""
CLOUD_IMAGE_PREFIX="ccr.ccs.tencentyun.com/luke_app/hot_list"
TAG=$1

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
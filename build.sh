#!/bin/bash

#读取配置文件   具体参考./build_env-demo.sh
source ./build_env.sh

mvn clean install -DskipTests

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
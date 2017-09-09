#!/bin/bash
# -pl is used to skip bootstrap module here
# -amd is to install the dependency automically
mvn clean -pl '!bootstrap' install -amd

# 编译镜像
docker build -f deploy/dockerfile/eureka -t="$REGISTRY/eureka:$VERSION" .

# 推送镜像
docker push $REGISTRY/eureka:$VERSION
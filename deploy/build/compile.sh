#!/bin/bash
REGISTRY=registry.cn-hangzhou.aliyuncs.com/dsw/
VERSION=0.001
mvn clean
# maven is installed '/var/jenkins_home'
export PATH=$PATH:/var/jenkins_home/maven/bin
# -pl is used to skip bootstrap module here
# -amd is to install the dependency automically
mvn -pl '!bootstrap' install -amd -X

# 编译并且推送镜像
# 192.168.28.12:5000应该被写入环境变量
docker build -f deploy/dockerfile/eureka -t="$REGISTRY/eureka:$VERSION" .
docker login --username=18115198992 registry.cn-hangzhou.aliyuncs.com --password=14162536binchen
docker push $REGISTRY/eureka:$VERSION
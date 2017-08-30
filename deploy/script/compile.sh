#!/bin/bash

mvn clean
# maven is installed '/var/jenkins_home'
export PATH=$PATH:/var/jenkins_home/maven/bin
# -pl is used to skip bootstrap module here
# -amd is to install the dependency automically
mvn -pl '!bootstrap' install -amd -X

# 编译并且推送镜像
docker build -f deploy/dockerfile/eureka -t="$REGISTRY_NAMESPACE/eureka:$VERSION" .
docker login --username=REGISTRY_USERNAME  --password=REGISTRY_PASSWORD
docker push $REGISTRY_NAMESPACE/eureka:$VERSION
#!/bin/bash
which mvn 
echo $PATH

mvn clean
# maven is installed '/var/jenkins_home'
export PATH=$PATH:/var/jenkins_home/maven/bin
# -pl is used to skip bootstrap module here
# -amd is to install the dependency automically
mvn -pl '!bootstrap' install -amd -X

# 编译镜像
docker build -f deploy/dockerfile/eureka -t="$REGISTRY_NAMESPACE/eureka:$VERSION" .
# 登录镜像站
docker login --username=$REGISTRY_USERNAME  --password=$REGISTRY_PASSWORD $REGISTRY_ADDRESS
# 推送镜像
docker push $REGISTRY_NAMESPACE/eureka:$VERSION
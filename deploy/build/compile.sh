#!/bin/bash
mvn clean
# maven is installed '/var/jenkins_home'
export PATH=$PATH:/var/jenkins_home/maven/bin
# -pl is used to skip bootstrap module here
# -amd is to install the dependency automically
mvn -pl '!bootstrap' install -amd -X

# 编译并且推送镜像
# 192.168.28.12:5000应该被写入环境变量
docker build -f deploy/dockerfile/eureka -t='192.168.28.12:5000/eureka' .
docker push 192.168.28.12:5000/eureka
#!/bin/bash
# -pl is used to skip bootstrap module here
# -amd is to install the dependency automically
cd $WORKSPACE_HOME
mvn clean -pl '!bootstrap' install -amd

# compile images
docker build -f deploy/dockerfile/eureka -t="$REGISTRY/eureka:$VERSION" .
docker build -f deploy/dockerfile/zuul -t="$REGISTRY/zuul:$VERSION" .

# push images
docker push $REGISTRY/eureka:$VERSION
docker push $REGISTRY/zuul:$VERSION

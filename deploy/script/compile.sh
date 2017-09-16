#!/bin/bash
# -pl is used to skip bootstrap module here
# -amd is to install the dependency automically
cd $WORKSPACE_HOME
mvn clean -pl '!bootstrap' install -amd -Dmaven.test.skip=true

# compile images
docker build -f deploy/dockerfile/eureka -t="$REGISTRY/eureka:$VERSION" .
docker build -f deploy/dockerfile/zuul -t="$REGISTRY/zuul:$VERSION" .
docker build -f deploy/dockerfile/admin -t="$REGISTRY/admin:$VERSION" .
docker build -f deploy/dockerfile/frontend -t="$REGISTRY/frontend:$VERSION" .
docker build -f deploy/dockerfile/zipkin -t="$REGISTRY/zipkin:$VERSION" .

# push images
docker push $REGISTRY/eureka:$VERSION
docker push $REGISTRY/zuul:$VERSION
docker push $REGISTRY/admin:$VERSION
docker push $REGISTRY/frontend:$VERSION
docker push $REGISTRY/zipkin:$VERSION

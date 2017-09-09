#!/usr/bin/env bash

# replace registry address and container version
for file in `ls $WORKSPACE_HOME/deploy/k8s`;
do
    echo "replace $file content....";
    sed -i 's@${REGISTRY}@'"$REGISTRY"'@g' $WORKSPACE_HOME/deploy/k8s/$file;
    sed -i 's@${VERSION}@'"$VERSION"'@g'  $WORKSPACE_HOME/deploy/k8s/$file;
done

# 存在就删除
kubectl delete --ignore-not-found=true -f $WORKSPACE_HOME/deploy/k8s/

kubectl delete -f $WORKSPACE_HOME/deploy/k8s/

kubectl create -f $WORKSPACE_HOME/deploy/k8s/
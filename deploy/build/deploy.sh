#!/usr/bin/env bash

# replace registry address and container version
for file in `ls $WORKSPACE_HOME/deploy/k8s`;
do
    echo "replace $file content....";
    sed -i 's/${REGISTRY}/REGISTRY_NAMESPACE/g'  $WORKSPACE_HOME/deploy/k8s/$file;
    sed -i 's/${VERSION}/$VERSION/g'  $WORKSPACE_HOME/deploy/k8s/$file;
done

kubectl create -f $WORKSPACE_HOME/deploy/k8s/
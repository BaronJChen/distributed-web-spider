#!/usr/bin/env bash
REGISTRY_ADDRESS=registry.cn-hangzhou.aliyuncs.com
REGISTRY_USERNAME=18115198992
REGISTRY_PASSWORD=14162536binchen
REGISTRY_NAMESPACE=registry.cn-hangzhou.aliyuncs.com/dsw
VERSION=0.001
WORKSPACE_HOME=`pwd`

# 切换用户
echo ' ' | su root

source $WORKSPACE_HOME/deploy/script/compile.sh
source $WORKSPACE_HOME/deploy/script/deploy.sh
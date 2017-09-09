#!/usr/bin/env bash
# 切换用户
echo $PASSWORD | su $USER

source $WORKSPACE_HOME/deploy/script/compile.sh
source $WORKSPACE_HOME/deploy/script/deploy.sh
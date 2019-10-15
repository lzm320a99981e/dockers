#!/usr/bin/env bash
# 创建网络环境
docker network create c001
docker network create c101

# 启动容器
v_dir_current=$(cd `dirname $0`; pwd)

cd ${v_dir_current}/01Nexus
./install.sh

cd ${v_dir_current}/02Gitlab
./install.sh

cd ${v_dir_current}/04Atlassian
./install.sh

cd ${v_dir_current}/03Nginx
./install.sh
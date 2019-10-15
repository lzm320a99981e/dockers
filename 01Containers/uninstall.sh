#!/usr/bin/env bash
# 停止容器
docker stop $(docker ps | grep customized | awk '{print $1}')

# 删除容器
docker rm $(docker container ls -a | grep customized | awk '{print $1}')

# 删除容器镜像
docker rmi $(docker images | grep customized | awk '{print $3}')

# 删除网络环境
docker network create c001
docker network create c101
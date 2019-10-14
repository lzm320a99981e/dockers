#!/usr/bin/env bash
# 拉取基础镜像
docker pull cptactionhank/atlassian-jira-software
docker pull cptactionhank/atlassian-confluence
docker pull mysql:5.7
# 创建共享网络
docker network create customized-atlassian

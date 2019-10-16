#!/usr/bin/env bash

v_dir_current=$(cd `dirname $0`; pwd)
cd ${v_dir_current}/

# 下载配置模板(wget https://raw.githubusercontent.com/antirez/redis/5.0.6/redis.conf -O redis.conf)
wget http://download.redis.io/redis-stable/redis.conf -O redis.conf

# 修改配置
sed -i 's/logfile ""/logfile "access.log"/' redis.conf
sed -i 's/appendonly no/appendonly yes/' redis.conf
sed -i 's/protected-mode yes/protected-mode no/' redis.conf
sed -i 's/bind 127.0.0.1/# bind 127.0.0.1/' redis.conf

docker-compose up -d
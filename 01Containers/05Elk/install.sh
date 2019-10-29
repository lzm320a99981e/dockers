#!/usr/bin/env bash

docker network create elk

v_dir_current=$(cd `dirname $0`; pwd)
v_dir_data_elasticsearch=${v_dir_current}/data/elasticsearch

mkdir -p ${v_dir_data_elasticsearch}

chown -R 1000:1000 ${v_dir_data_elasticsearch}

docker-compose up -d --build
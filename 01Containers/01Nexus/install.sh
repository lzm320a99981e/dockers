#!/usr/bin/env bash

v_dir_current=$(cd `dirname $0`; pwd)
mkdir -p ${v_dir_current}/nexus-data
chown -R 200 ${v_dir_current}/nexus-data

docker-compose up -d
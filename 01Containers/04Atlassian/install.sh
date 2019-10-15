#!/usr/bin/env bash

docker network create c101

v_dir_current=$(cd `dirname $0`; pwd)

cd ${v_dir_current}/mysql
./install.sh

cd ${v_dir_current}/jira
./install.sh

cd ${v_dir_current}/confluence
./install.sh
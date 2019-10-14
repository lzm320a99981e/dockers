#!/usr/bin/env bash
docker volume create customized-atlassian-mysql
docker build -t customized-atlassian-mysql .
docker-compose up -d
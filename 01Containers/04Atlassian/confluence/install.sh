#!/usr/bin/env bash
docker volume create customized-atlassian-confluence
docker build -t customized-atlassian-confluence .
docker-compose up -d

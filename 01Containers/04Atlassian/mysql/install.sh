#!/usr/bin/env bash
docker build -t customized-atlassian-mysql .
docker-compose up -d
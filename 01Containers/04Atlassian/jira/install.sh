#!/usr/bin/env bash
docker volume create customized-atlassian-jira
docker build -t customized-atlassian-jira .
docker-compose up -d
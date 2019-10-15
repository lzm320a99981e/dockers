#!/usr/bin/env bash
docker build -t customized-atlassian-jira .
docker-compose up -d
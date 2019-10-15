#!/usr/bin/env bash
docker build -t customized-atlassian-confluence .
docker-compose up -d

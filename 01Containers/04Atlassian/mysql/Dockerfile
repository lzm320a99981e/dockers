FROM mysql:5.7
USER root
ENV MYSQL_ROOT_PASSWORD=atlassian
COPY my.cnf /etc/mysql/
COPY init.sql /docker-entrypoint-initdb.d/

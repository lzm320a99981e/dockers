CREATE DATABASE jira CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
GRANT ALL PRIVILEGES ON jira.* TO 'jira'@'%' IDENTIFIED BY 'jira';
flush privileges;

CREATE DATABASE confluence CHARACTER SET utf8 COLLATE utf8_bin;
GRANT ALL PRIVILEGES ON confluence.* TO 'confluence'@'%' IDENTIFIED BY 'confluence';
flush privileges;

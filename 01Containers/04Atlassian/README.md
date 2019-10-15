### 生成序列号 
```
# Jira 注册号（产品类型：jira）
java -jar atlassian-agent.jar -d -m 9527deyouxiang@gmail.com -n 9527 -p jira -o http://192.168.0.201 -s B3JE-KZPS-A5UA-NG71

# Confluence 注册号（产品类型：conf） 
java -jar atlassian-agent.jar -d -m 9527deyouxiang@gmail.com -n 9527 -p conf -o http://192.168.0.201 -s BLTV-OSQ3-2TY9-W5ZA
```

### Jira 安装
```
1. 配置Mysql数据库
# 找到Mysql的IP地址
docker network inspect customized-atlassian

2. 配置邮箱
2.1 勾选上 ssl
2.2 填写授权用户名密码
- 如果是QQ企业邮箱，则需要去获取授权码
- 设置 >> 客户端设置 >> 获取授权码

```

### Confluence 安装
```
1. 配置Mysql数据库（同Jira）
需要在路径后面加上?useSSL=false

2. 使用Jira已配置的用户
```
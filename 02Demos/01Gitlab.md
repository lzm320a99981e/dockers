### 使用教程
#### SSH KEY 配置
```bash

# 生成秘钥，使用ed25519算法，性能比rsa要好
ssh-keygen -q -t ed25519 -N '' -C "zhangguangyong@gitlab.com" -f ~/.ssh/id_ed25519 

# 绑定秘钥与gitlab服务器
cat >> ~/.ssh/config <<EOF
# Private GitLab instance
Host gitlab.local.com
  Preferredauthentications publickey
  IdentityFile ~/.ssh/id_ed25519
EOF

# 复制秘钥添加到gitlab服务器
# Mac
pbcopy < ~/.ssh/id_ed25519.pub
# Linux
xclip -sel clip < ~/.ssh/id_ed25519.pub
# Windows(Git Bash)
cat ~/.ssh/id_ed25519.pub | clip

```
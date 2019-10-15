#!/usr/bin/env bash

# 生成秘钥，使用ed25519算法，性能比rsa要好
ssh-keygen -q -t ed25519 -N '' -C "zhangguangyong@gitlab.com" -f ~/.ssh/id_ed25519

# 绑定秘钥与gitlab服务器
v_exited=$(cat ~/.ssh/config | grep "Host gitlab.local.com")
if [[ ! ${v_exited} ]]; then
cat >> ~/.ssh/config <<EOF
# Private GitLab instance
Host gitlab.local.com
  Preferredauthentications publickey
  IdentityFile ~/.ssh/id_ed25519
EOF
fi

# 复制公钥-添加到gitlab
pbcopy < ~/.ssh/id_ed25519.pub
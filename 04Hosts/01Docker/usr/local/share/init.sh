#!/usr/bin/env bash

############################################################
#  docker 常用软件：https://github.com/vimagick/dockerfiles
#
#
#
#
############################################################

v_dir_current=$(cd $(dirname $0);pwd)
echo "************************** 当前目录($v_dir_current) **************************"

# 备份网络
network_backup(){
    v_file_network="$1"
    v_file_network_backup="$1.backup"
    echo "************************** 网络备份($v_file_network -> $v_file_network_backup) **************************"
    cp -f "$v_file_network" "$v_file_network_backup"
    echo "************************** 网络备份($v_file_network_backup)文件内容 **************************"
    cat "$v_file_network_backup"
}

# 配置网络
network_config(){
    local v_file_network="$1"
    # 备份网络
    network_backup "$v_file_network"
    # 配置网络
    echo "************************** 网络配置($v_file_network)前 **************************"
    cat "$v_file_network"

    sed --in-place 's/BOOTPROTO=dhcp/BOOTPROTO=static/g' "$v_file_network"
    sed --in-place 's/ONBOOT=no/ONBOOT=yes/g' "$v_file_network"
    local v_ip="$2"
    local v_ip_items=(${v_ip//./ })
    local v_ip_prefix="${v_ip_items[0]}.${v_ip_items[1]}.${v_ip_items[2]}"
    echo "IPADDR=${v_ip}" >> "$v_file_network"
    echo "GATEWAY=${v_ip_prefix}.1" >> "$v_file_network"
    echo "NETMASK=255.255.255.0" >> "$v_file_network"
    echo "DNS1=${v_ip_prefix}.1" >> "$v_file_network"

    echo "************************** 网络配置($v_file_network)后 **************************"
    cat "$v_file_network"
}

# 更新系统
yum_update(){
    local v_repo_file=/etc/yum.repos.d/CentOS-Base.repo
    echo "************************** yum 仓库($v_repo_file)更新前 **************************"
    cat "$v_repo_file"

    mv "$v_repo_file" "$v_repo_file.backup"
    wget http://mirrors.aliyun.com/repo/Centos-7.repo -O "$v_repo_file"

    echo "************************** yum 仓库($v_repo_file)更新后 **************************"
    cat "$v_repo_file"

    yum clean all && yum -y makecache && yum -y update && yum -y upgrade
}

# 关闭 SELinux
selinux_disable(){
    local v_file_selinux=/etc/selinux/config
    echo "************************** selinux 关闭($v_file_selinux)前 **************************"
    cat "$v_file_selinux"

    setenforce 0
    cp -f /etc/selinux/config /etc/selinux/config.backup
    sed -i "s/SELINUX=enforcing/SELINUX=disabled/g" /etc/selinux/config

    echo "************************** selinux 关闭($v_file_selinux)后 **************************"
    cat "$v_file_selinux"
    echo "************************** selinux(getenforce) -> $(getenforce) **************************"
}

# 卸载docker
docker_remove(){
    echo "************************** docker 卸载 **************************"
    systemctl stop docker
    sudo yum remove docker \
                      docker-client \
                      docker-client-latest \
                      docker-common \
                      docker-latest \
                      docker-latest-logrotate \
                      docker-logrotate \
                      docker-selinux \
                      docker-engine-selinux \
                      docker-engine
    rm -fr /var/lib/docker/
}
# 安装docker
docker_install(){
    # 卸载
    docker_remove
    echo "************************** docker 安装 **************************"
    # 官方安装（比较慢）
#    sudo yum install -y yum-utils device-mapper-persistent-data lvm2
#    sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
#    sudo yum install -y docker-ce

    # 极速安装（快）
    curl -sSL https://get.daocloud.io/docker | sh
    # 添加国内镜像仓库
    curl -sSL https://get.daocloud.io/daotools/set_mirror.sh | sh -s http://f1361db2.m.daocloud.io

    systemctl start docker
    echo "************************** docker version -> $(docker -v) **************************"
}

# 安装docker-compose
docker_compose_install(){
    echo "************************** docker-compose 安装 **************************"
    # 官方安装（比较慢）
#    sudo curl -L "https://github.com/docker/compose/releases/download/1.24.1/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
    # 极速安装安装（快）
    sudo curl -L https://get.daocloud.io/docker/compose/releases/download/1.24.1/docker-compose-`uname -s`-`uname -m` -o /usr/local/bin/docker-compose
    sudo chmod +x /usr/local/bin/docker-compose
    sudo ln -sf /usr/local/bin/docker-compose /usr/bin/docker-compose
    echo "************************** docker-compose version -> $(docker-compose -v) **************************"
}

#docker_install
#docker_compose_install


# yum_update
# selinux_disable

# docker run -it --rm -v /usr/local/share/pdf2htmlEX/pdf:/pdf bwits/pdf2htmlex pdf2htmlEX 13b9f949-36b5-42f6-846a-4e2df35b8f9c.PDF


# network_config "/etc/sysconfig/network-scripts/ifcfg-ens33" "192.168.31.21"

# /Applications/Lantern.app/Contents/MacOS/lantern -addr 192.168.31.163:8787

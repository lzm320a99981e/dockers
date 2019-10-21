# 环境准备
```bash
# 安装 Linux 虚拟机（Centos7）

# 配置网络环境
v_file_network=/etc/sysconfig/network-scripts/ifcfg-ens33
v_file_network_backup=/etc/sysconfig/network-scripts/ifcfg-ens33.bakcup
cp ${v_file_network} ${v_file_network_backup}

sed -i 's/BOOTPROTO=dhcp/BOOTPROTO=static/' ${v_file_network}
sed -i 's/ONBOOT=no/ONBOOT=yes/' ${v_file_network}

echo "IPADDR=192.168.0.31" >> ${v_file_network}
echo "NETMASK=255.255.255.0" >> ${v_file_network}
echo "GATEWAY=192.168.0.1" >> ${v_file_network}
echo "DNS1=192.168.0.1" >> ${v_file_network}

systemctl restart network

# 安装常用软件
yum install -y wget vim
mv /etc/yum.repos.d/CentOS-Base.repo /etc/yum.repos.d/CentOS-Base.repo.backup
wget http://mirrors.aliyun.com/repo/Centos-7.repo -O /etc/yum.repos.d/CentOS-Base.repo
yum clean all && yum -y makecache && yum -y update && yum clean all 



# 安装 Docker

```
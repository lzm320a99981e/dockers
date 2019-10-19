#!/usr/bin/env bash

v_dir_current=$(cd $(dirname $0);pwd)

echo "current dir -> $v_dir_current"

# 备份网络
network_backup(){
    v_file_network="$1"
    v_file_network_backup="$1.backup"
    echo "cp -f $v_file_network $v_file_network_backup"
    cp -f "$v_file_network" "$v_file_network_backup"
    echo "cat $v_file_network_backup"
    cat "$v_file_network_backup"
}
# network_backup "/etc/sysconfig/network-scripts/ifcfg-ens33"

# 配置网络
network_config(){
    local v_file_network="$1"
    sed --in-place 's/BOOTPROTO=dhcp/BOOTPROTO=static/g' "$v_file_network"
    sed --in-place 's/ONBOOT=no/ONBOOT=yes/g' "$v_file_network"
    local v_ip="$2"
    local v_ip_items=(${v_ip//./ })
    local v_ip_prefix="${v_ip_items[0]}.${v_ip_items[1]}.${v_ip_items[2]}"

cat >> "$v_file_network" <<EOF
IPADDR=${v_ip}
GATEWAY=${v_ip_prefix}.1
NETMASK=255.255.255.0
DNS1=${v_ip_prefix}.1
EOF

cat ${v_file_network}
}

network_config "/etc/sysconfig/network-scripts/ifcfg-ens33" "192.168.31.21"



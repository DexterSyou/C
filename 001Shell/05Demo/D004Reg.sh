#!/bin/sh

read -p "请输入用户的前缀" qz
if [[ ！$qz =~ ^[a-Z]+$ ]]; then
   echo "你输入的不是英文"
   exit
fi

read -p "请输入用户的后缀: " hz
if [[ $hz =~ ^[0-9]+$ ]];then
  echo "Create user ${qz}${hz}"
fi	

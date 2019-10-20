#!/bin/sh

####
#----------------------------------------------
# Date   :  2019-10-20
# Writer :
# Content:
#     
#-----------------------------------------------

var="test"
echo "${var}"

#shell的内建特性
#获得字符串的长度
len=${#var}
echo "${len}"

#获知使用那种shell
echo "${SHELL}"
echo "$0"

#检测是否为超级用户
#UID保存的是用户ID
if [ ${UID} -ne 0 ]; then
	echo "Non root"
else
	echo "Root"
fi

##Summary
#------------------------------------------------
# var = value 等量关系
# var=value   赋值操作  shell使用空白符来分隔单词
#
# export当前脚本所有的程序都会获得这个变量
# export PATH=“$PATH:/home/user/bin”
#
# [ 是一个命令 
# root的UID为0
#------------------------------------------------

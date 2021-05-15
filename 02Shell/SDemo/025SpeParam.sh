i#!/bin/bash

export IFS='-'

cnt=1
echo " Value of \"\$*\"; "
echo $*
echo "$*"

for arg in "$*"
do
	echo "Arg #${cnt} = ${arg}"
	let "cnt += 1"
done

cnt=1
echo " Value of \"\$@\" "
for arg in "$@"
do
  echo "Arg #$cnt = $arg"
  let cnt+=1
done

#
#
# 1. let 命令是 BASH 中用于计算的工具，用于执行一个或多个表达式，变量计算中不需要加上 $ 来表示变量
# 2. Shell 脚本中有个变量叫IFS(Internal Field Seprator) ，内部域分隔符，shell环境变量分为set，env两种
#    set显示设置shell变量，仅在本shell有效，env显示设置用户环境变量，仅在当前会话有效
#    IFS一种set变量，当shell处理 命令替换，参数替换 shell根据IFS值来解读读入的变量，把字符串里的某个字符
#    转换成分隔符
#    space 040  tab 011 \n 012
#
#




















#!/bin/bash

printf "%-5s %-10s %-4s\n" No Name Mark
printf "%-5s %-10s %-4s\n" 1 Sarath 79.8888
printf "%-5s %-10s %-4s\n" 2 James 80.3456
printf "%-5s %-10s %-4s\n" 3 Jeff 90.9989
printf "%-5s %-10s %-4s\n" 4 Name Mark

echo "*******************************"
# -n 禁止换行行为 -e 包含转义序列
echo -e "1\t2\t3"
echo -e "\e[1;31m This is red text \e[0m"
echo -e "\e[1;42m This is red text \e[0m"

# 查看其他进程的环境变量 cat /proc/$PID/environ
# 使用pgrep获得 应用程序 的进程ID
#     pgrep gedit
# cat /proc/$PID/environ | tr '\0' '\n'

echo "*******************************"
echo $SHELL
echo $0






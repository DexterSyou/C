#!/bin/sh

# 每月第一天备份并压缩/etc目录的所有内容
# 存放在/root/bak目录里，且文件名为yymmdd11_etc.yy

####################################################################################
#  每月第一天 crond
#             crond是linux下用来周期性的执行某种任务或等待处理某些事件的一个守护进程
# crontab -l 
# 分 小时日  月 星期
# 00 00   1  *  *  sh /root/003FileBack.sh &>/dell/nul
####################################################################################

testPath="/root/bak"
[ ! -d ${testPath} ] && mkdir -p ${testPath}
curDate=$(date +%Y_%m_%d)
tar czf ${testPath}/${curDate}_etc.tar.gz /etc



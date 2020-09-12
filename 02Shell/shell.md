##

```
<1>
   man
   info
   -help

<2>
  根驱动器（虚拟目录核心）
    系统文件
    常见目录名都基于FHS

<3>
   cd
   pwd
   ～  主目录
   . 
   ..
   
<4>
4-1 显示文件
    ls
      -afr
	  --time=atime      访问时间
	  -l
	   文件类型文件权限 文件硬链接总数 用户名 组名 文件大小 上次修改时间 文件名或目录名
       通配符？ *  [ ] 等

4-2 创建文件
    touch
4-3 复制文件
    cp source destination
	  -i
	  -r
4-4 链接文件
    符号链接
	  ln -s
	硬链接 
      ln
4-5 重命名文件
    mv
	  -i
4-6 删除文件
    rm 
	  -i
    
<5> 
   创建目录
   mkdir
   mkdir -p
   rmdir

   rm -ri 

<6> 
   file
   cat
   cat -n
   cat -b
   cat -T
   more
   less（less is more）
   tail
   tail -n（n为从头开始的行数） 
   head -n（n为从尾开始的行数）

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
当程序运行在系统上时，我们称为进程
 
ps
top

Linux进程信号
1   HUP
2   INT
3   QUIT
9   KILL
11  SEGV
15  TERM
17  STOP
18  TSTP
19  CONF

  
kill
kill -s
killall

检测磁盘空间
  挂载 把新的存储媒体放到虚拟目录下
  mount
    mount -t type device directory
  umount

  df -h
  du -chs


处理数据文件
排序
  sort -n file
  sort -M file
  sort -t ‘：’ -k 3 -n file
搜索数据
  grep [options] pattern [file]
       -v
	   -n
	   -c
	   -e f -e t --> [tf]

压缩数据
  gzip
  gzcat
  gunzip

归档数据
  tar function [options] object1 object2 ...
  tar -cvf test.tar .....
  tar -tf  test.tar
  tar -xvf test.tar
  tar -zxvf ....

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
命令列表 pwd；ls；pwd
进程列表 （pwd；ls；pwd）
sleep
&
jobs -l
coproc

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
which
type -a
type
history
外部命令，会创建一个子进程
 ps
内建命令不需要使用子进程执行
 cd
 exit


alias

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
全局环境变量
printenv
env
局部环境变量
set
unset

登陆shell会从5个不同的启动文件里读区命令
/etc/profile
    主启动文件
$HOME/.bash_profile
$HOME/.bashrc
$HOME/.bash_login
$HOME/.profile

交互式shell
非交互式shell



























```

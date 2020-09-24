##

```
1 内核
  系统内存管理
  软件程序管理
  硬件设备管理
     Linux将硬件设备当成特殊的文件，称为设备文件
	 *字符型设备文件
	   处理数据时每次只能处理一个字符的设备
	 *块设备文件
	   处理文件时每次能处理大块数据的设备
	 *网络设备文件
	   采用数据包发送 和 接受数据 的设备
  文件系统管理
2 GNU（GNU‘s Not Unix）
   GNU coreutils
   GNU/Linux shell
      bash shell
3 X Window
    X.org
  KDE
  GNOME
  Unity

@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@
Linux 文件权限 
root        UID -> 0

useradd
userdel
usermod

passwd
chpasswd


groupadd
groupmod

文件权限
r w x
4 2 1

umask
chmod 777 file
chown
chgrp


#------------------------------------------------------------
#  Command Line 
#------------------------------------------------------------

init is the parent of all processs on the system
@/bin/bash 
  命令的优先执行顺序
    alias   function  builtin  program
  shell从PATH列出的路径中依次查找用户输入的命令
    type -a cmd
    type -t cmd
    type -P cmd 强制到PATH下查找
  
  redirect 重定向
    dup/fcntl等函数实现，本质是复制文件描述符，让多个文件描述符共享同一个文件表相
  | 管道
    管道通过C语言里头的pipe函数创建了一个管道（一个包含两个文件描述符的整形数组，
	一个描述符用于写入数据，一个描述符用于读入数据），并且通过dup/fcntl把cat的输出
	复制到了管道的输入，把管道的输出则复制到了grep的输入
  & 后台进程（无法响应用户的操作，fg可以恢复到前台）
    Ctrl+Z bg

  普通程序变成了进程
    #declare -x 声明的环境变量将被导出到子进程中国
   bash 通过 execve 调用了 /user/bin/test，并且给他传参数（环境变量加结束标志NULL）
   shell先调用fork创建了一个子进程，然后调用execve执行新程序
   





















	
    









































```

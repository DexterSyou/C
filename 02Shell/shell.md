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

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
>
<

wc 可以对数据中的文本进行计数
   文本行数
   文本词数
   文本字节数

wc << EOF

command1 | command4

shell算术：
   expr
   $[1 + 5]

bc
bc中的变量只能在bc中运用

@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@
$? 退出状态码
   0 命令成功结束
   1 一般性的未知错误
   2 不合适的shell命令
   126 不可执行
   127 没找到命令
   128 无效退出参数
   128+x x信号相关
   130    Ctrl+C 
   255    正常范围之外的退出状态码

exit

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
<1>
  if command 退出状态码为0时执行
  then
    commands
  else       退出状态码非0
    commands
  fi
<2>
  if command1
  then
    commands
  elif command2
  then
    command数 
  else  语句else属于elif代码块
	commands
  fi
<3> 只有第一个返回退出状态码0的语句中的then部分会被执行
  if command1  
  then
    command set 1 
  elif command2
  then
    command set 2 
  elif command3
  then
    command set 3 
  elif command4 
  then
    command set 4
  fi

if-then语句不能测试命令状态码之外的条件，test命令提供了
在if-then语句中测试不同条件的途径，test命令中列出的条件成立
test命令就会退出并返回退出状态码0
test condition
       数值比较    -eq -ge -gt -le -lt -ne
	   字符串比较  = < > -n -z !=
	   文件比较    -d -e -f -r -s -w -x -O -G 
	               file1 -nt file2
				   file1 -ot file2

if test condition
then
   commands
fi

if [condition]
then
    commands
fi

[cond] && [cond]
[cond] || [cond]


双括号
 (( expression )) 可以使用高级数学表达式
 expression是任意的数学赋值或比较表达式
 > 不需要转义
 var=10
 if(( $var ** 2 > 90 ))
 then
   (( var2=$var ** 2 ))
 fi

双方括号 提供了匹配模式
 [[ expression ]]
 

 case variable in
   pattern1 | pattern2）commands1；；
   pattern3）command2；；
   *） default commands；；   -->模式不匹配的情况*
 esac
 

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
for var in list
do
	commands
done

for((i=1;i<=10;i++))
do
	echo "The next number is $i"
done

更改字段分隔符
  IFS 内部字段分隔符
  默认情况下bash shell会将下列字符当作字段分隔符
  空格 制表符 换行符
  
  IFS.OLD=$IFS
  IFS=$'\n'     可以指定多个IFS字符 IFS=$'\n':;"

  IFS=&IFS.OLD

while test command
do
	other commands
done

until test commands
do
   other commands
done

break
continue





























```

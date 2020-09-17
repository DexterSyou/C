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

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

$0 $1 $2 $3 $4 $5 $6 $7 $8 $9
$(basename $0)
$#
#* 一个整体
#@ 同一个字符串多个个体
shift

getopt命令
getopt optstring parameters
       optstring 中列出用到的每个命令行选项字母，每个需要参数值的选项字母加一个冒号

       getopt ab:cd -a -b test1 -cd test2 test3
	   ==> -a -b test1 -c -d -- test2 test3
 
       set -- $（getopt -q ab：cd “$@”）

getopts optstring variable
       getopts ：ab：c opt

       
read
    -p
	-t 选项来指定一个计时器，当计时器过期后，read命令会返回一个非0退出状态码
    -nl 
	-s
    REPLY环境变量会保存输入的所有数据 
   
    read会从文件中读取一行文本，但文件在没有内容时，read命令会退出并返回非零退出状态码
	cat file | while read line
	do
	   
	done


@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
Linux系统将每个对象当作文件处理，包括输入和输出进程
文件描述符来标示每个文件对象，是非负数可以唯一标示会话中打开的文件

0 STDIN
   shell从STDIN文件描述符对应的键盘获得输入，在用户输入时处理每个字符
   <   Linux会用重定向指定的文件来替换标准输入文件描述符
   
1 STDOUT
   shell的标准输出，shell的所有输出（包括shell中运行的程序和脚本）会被定向到标准输出中


2 STDERR 
   shell的标准错误输出，shell或shell中运行的程序和脚本出错时生成的错误消息都会发送到这个位置
   默认会导向STDOUT
   ls -al 2> file1 1> file2

>&

exec 1>testout
exec 2>testerr
exec 0<testfile

exec 3>testOut
echo “xx” >&3

exec 3>&- 关闭文件描述符

lsof 命令会列出整个Linux系统打开的所有文件描述符
 lsof -a -p $$ -d 0,1,2

null文件的标准位置/dev/null
cat /dev/null > testfile

Linux系统有特殊目录，专供临时文件使用，Linux使用/tmp目录来存放不需要永久保留的文件
大多数Linux发行版在系统启动时自动删除了/tmp目录的所有文件
mktemp
  tf=$(mktemp testing.XXXXXX)
  mktemp -t test.XXXXXX  -t 全路径的临时文件
  mktemp -d dir.XXXXXX   -d 临时目录
 
记录消息
 tee 将从STDIN过来的数据同时发往两处，一处是STDOUT，一处时tee命令所指定的文件名
     tee filename
	 tee -a filename

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
处理信号
  Linux利用信号与运行在系统中的进程进行通信
  1    SIGHUP  挂起进程
  2    SIGINT  终止进程
  3    SIGQUIT
  9    SIGKILL 
  15   SIGTERM
  17   SIGSTOP
  18   SIGTSTP  暂停进程          CTRL+Z
  19   SIGCONT
 
  Ctrl+C 生成SIGINT信号，并将其发送给当前shell中运行的所有进程
  kill 9 PID

  trap commands signals 
  如果脚本收到了trap命令中列出的信号，该信号不再由shell处理，而是由本地处理
  
  trap “echo GoodBye ...”  EXIT
  一个脚本可存在多个trap

  后台运行脚本 &
  nohup 会解除终端与进程的关联，进程也就不再同STDOUT 和 STDERR的消息重定向到一个名为
  nohup.out的文件中

  查看作业
   $$变量来显示LInux系统分配给该脚本的PID，

  jobs

  bg
  fg

  nice命令
   设置命令启动时的调度优先级，
    nice -n 10   NI--> 10 指定新的优先级（降低优先级）
    nice -10     NI--> 10 （降低优先级）  
  renice 指定运行进程的PID来改变它的优先级
    renice -p 10 -p PID

  at命令来计划执行作业
    指定Linux系统何时运行脚本
	atd守护进程会检查系统上的一个特殊目录（/var/spool/at）来获取命令提交的作业
	每60秒检查下这个目录，有作业时，atd守护进程会检查作业设置运行时间，如果时间个
	当前时间匹配，atd守护进程就会运行此作业

	at [-f filename] time
	该作业会被提交到作业队列job queue， 

	atq 查看系统中哪些作业在等待
	atrm No 删除等待作业

	cron时间表
	  min hour dayofmonth month dayofweek command
	  15  10   *          *     *         command
      15  16   *          *     1         command
 	  00  12   1          *     *         command 
      00  12   *          *     * if[`date +%d -d tommorrow`= 01];then;command
  
    crontab -l
     
	/ect/cron.daily   （每天运行一次）   将脚本复制到该目录
	/ect/cron.hourly
	/ect/cron.monthly
	/ect/cron.weekly

    anacron只会处理位于cron目录的程序
	period delay identifier command
	
















```

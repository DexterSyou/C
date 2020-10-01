## Shell

```
#*******************************************************************************
# 1.Shell
# ------------------------------------------------------------------------------
#                        shell
# kernel <----------------------------------> user
# 每当登陆系统，我们就取得一个交互模式的shell （primary shell） 
#*******************************************************************************
1-1.fork
	在process中，shell所下达的命令，均是shell所产生的子进程，这种现象可称为fork
	如果执行shell脚本，脚本中的命令则是由另一个非交互模式的子shell来执行的
	也就是primary shell 产生的sub shell

	/etc/shells
	sh
		burne shell       （sh
		burne again shell （bash
	csh
		c  shell   （csh
		tc shell   （tcsh
		korn shell （ksh

1-2.输入命令，碰到CR（Carriage Retrun ，由Enter键产生）
    command-name options argument
    shell会依据IFS将command line所输入的文字给拆解为字段，然后
    在针对特殊的字符（meta）先做处理，最后在重组整行command line
   
    IFS internal Field Seperator IFS 内部字段分隔符
    默认情况下bash shell会将下列字符当作字段分隔符
	  空白键             White Space
      表格键(制表符)     Tab
      回车键键（换行符） Enter
    
	更改字段分隔符  
    IFS.OLD=$IFS
    IFS=$'\n'     可以指定多个IFS字符 IFS=$'\n':;"
    IFS=&IFS.OLD
	    
	IFS=; 是将IFS设置为null
 
1-3.command line ,  meta line    
	command line的每一个charactor分为两种
      literal  也就是普通的纯文字，对shell来说没有特殊功能
      meta     对shell来说，具有特定功能的特殊保留字符
               =  ¥  >  CR ...
     shell command line 
      主要是将整行line给分解break down 为每个单词（word）
      词与词之间的分隔符就是IFS（Internal Field Seperator）
      shell会对command line 作处理，然后再按词重组
      
	  比如 A=“   abc”
           echo $A    无空格输出 
	       echo "$A"  有空格输出
	
	    echo
		echo    有换行符号
		echo -n 取消换行符号  
		echo -e 启用反斜杠控制字符的转换 
		     -E
     
	 比如echo $i的解析过程
	      首先将$i替换为字符串，然后对echo字符串中字符串分词，然后命令重组，输出结果。（注意IFS的存在）
    
     单引号‘ ，所有的meta均被关闭
	 双引号“ ，大部分meta都会被关闭
	 escape\ ，紧接在escape（跳脱字符）之后的单一meta才被关闭
     比如关闭；meta 命令，可以';'   ,  ";" ,  \;

1-4.帮助命令
    man
    info
    -help

1-5.外部命令，内建命令
	which
	type -a
	type
	history
	
	外部命令，会创建一个子进程  ps
	内建命令不需要使用子进程执行
	  cd
	 alias

#*******************************************************************************
# 2.exec  , source
#*******************************************************************************
2-1.进程
  所执行的任何程序，都是父进程产生的一个子进程，子进程在结束后，将返回到父进程
  此现象在Linux中被称为fork
  当子进程被产生时，将会从父进程那里获得一定的资源分配，及继承父进程的环境
  环境变量只能从父进程传给子进程。

  shell script是用sub-shell去执行的。从process来看，是parent process 产生一个
  child process去执行，当child结束后，返回parent，但parent的环境不会因child改变
  sub-shell的$pwd会因为cd而改变，返回primary shell时，$PWD是不会变更的

  所谓source，就是让script在当前shell内执行，而不是产生一个sub-shell来执行。
  exec 也是让script在同一个进程上执行，但是原有进程则被结束

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

  命令列表 pwd；ls；pwd
  进程列表 （pwd；ls；pwd）
  sleep
  &
  jobs -l
  coproc

#*******************************************************************************
#3.文件  目录 
#*******************************************************************************
3-1.字符串：有限字符的序列，数据元素位字符的线性表，一种数据的逻辑结构
    字符  ：计算机程序设计 及 操作时使用的符号
            字母，数字，空格符，提示符等

3-2.根驱动器（虚拟目录核心）
	从文件I/O 看Linux 的虚拟文件系统
	Linux中允许众多不同的文件系统共存，如ext2，ext3，vfat等。通过使用一套文件I/O系统调用
	即可对Linux中的任意文件进行操作而无需考虑其所在的集体文件格式，对文件的操作可以跨文件
	系统执行，万物皆文件（Linux / Unix）

	虚拟文件系统正是上述两点Linux特性的关键所在
	虚拟文件系统（Virtual File System，VFS），是Linux内核中的一个软件层，用于给用户空间的
	程序提供文件系统接口。同时，它也提供了内核中的一个 抽象功能，允许不同的文件系统共存。
	系统中所有的文件系统不但依赖 VFS 共存，而且也依靠 VFS 协同工作。
 3-2-1.
	文件    ：一组在逻辑上具有完整意义的信息项的系列
	目录    ：目录好比一个文件夹，用来容纳相关文件
	目录项  ：在一个文件路径中，路径中的每一部分
	索引节点：用于存储文件的元数据的一个数据结构。文件的元数据，也就是文件的相关信息，和文件
	  		  本身是两个不同的概念
	超级块  ：用于存储文件系统的控制信息的数据结构。
 3-2-2.
	创建 以某种方式格式化磁盘的过程就是 在其之上建立一个文件系统的过程
	注册 向内核报到，声明自己能被内核支持，struct file_system_type实例化
	安装 mount操作
 3-2-3.
    VFS数据结构
 
3-3.文件
    显示文件ls
      -afr
	  --time=atime      访问时间
	  -l
	  文件类型文件权限 文件硬链接总数 用户名 组名 文件大小 上次修改时间 文件名或目录名
      通配符？ *  [ ] 等
    创建文件touch
    复制文件cp source destination
    链接文件
        符号链接ln -s
	    硬链接 ln
    重命名文件mv
    删除文件rm 

3-4.目录    
    创建目录
      mkdir
      mkdir -p
      rmdir
      rm -ri 

3-4.处理数据文件
    排序 sort -cmu -o output_file [other options] +pos1 +pos2 input_file
		-n 指定分类是域上的数字分类
		-b 使用域进行分类，忽略第一个空格
		-c 测试文件是否已经分类
		-m 合并两个分类文件
		-u 删除所有复制行
		-o 存储sort结果的输出文件名
	    -M 三个字母的月份
	    sort -t ‘：’ -k 3 -n file
  
     删除相邻的重复行 uniq file
		-d 只输出file重复行，且只输出一次
		-u 只输出file中的唯一行
		-c 在每行前显示重复次数
			-cd
		-i 比较时忽略大小写
		-f 前n个域被忽略
	    -n 测试一部分的唯一性
  
     sort file | uniq 删除重复不相邻的行
  
     将两个分类文本的行连接在一起
        join [options] file1 file2
  
     用来从标准输入或文本文件剪切或域
       cut [options] file1 file2
        -f 指定剪切域
           -f 1，5
	       -f 1，5-6
        -d 指定分隔符
        -c 指定剪切字符数
           -c 1，5，7
	       -c 1-7
  
     将数据贴到相关文件
        paste -d -s file1 file2

     将文件切分为小文件
        split -output_file_size input_filename output_filename

     搜索数据
        grep [options] pattern [file]
         -v
	     -n
	     -c
	     -e f -e t --> [tf]
     查看
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

3-5.检测磁盘空间
    挂载 把新的存储媒体放到虚拟目录下
      mount
         mount -t type device directory
      umount

      df -h
      du -chs

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

#*******************************************************************************
#4.Shell变量  
#*******************************************************************************
	
4-1.bash变量是不区分类型的，本质上，Bash变量都是字符串，但是也依赖于具体的上下文
  全局环境变量
  	 printenv
	 env
  局部环境变量
	 set
	 unset

  登陆shell会从5个不同的启动文件里读区命令
	 /etc/profile  主启动文件
	 $HOME/.bash_profile
	 $HOME/.bashrc
	 $HOME/.bash_login
	 $HOME/.profile

  here document
	 wc 可以对数据中的文本进行计数
	  文本行数
	  文本词数
	  文本字节数
	 wc << EOF
	
  shell算术
     expr
     $[1 + 5]
  bc
    bc中的变量只能在bc中运用

4-2.命令替换，变量替换
    () 将command group 置于sub-shell（子shell）中去执行，也称为nested sub-shell
    {} 则是在同一个shell内完成，也称为non-named command group
 4-2-1.   
	命令替换 将里面的结果替换出来  $() ``
 4-2-2.
    变量替换 (引用变量的值) ${} 
 4-2-3.
     引用变量
  在一个双引号中通过直接使用变量名的方法来引用变量，一般情况下都是没有问题的
  这么做将阻止所用在引号中的特殊字符被重新解释，( $ ,`, \ 除外） 
  双引号还能够阻止单词分隔，一个参数被引号括起来，那么这个参数将认为是一个单元

  单引号，任何特殊字符都按照字面的意思进行解释

    file=/dir1/dir2/dir3/my.file.txt
	shell字符串的非贪婪（最小匹配）左删除
		${file#*/}
			拿掉第一个/及其左边的字符串    dir1/dir2/dir3/my.file.txt
		${file#*.}
			file.txt
	shell字符串的贪婪（最大匹配）左删除
		${file##*/}
			拿掉最后一个/及其左边的字符串 my.file.txt
		${file##*.}
			txt
	shell字符串的非贪婪（最小匹配）右删除
		${file%/*}  拿掉最后一个/及其右边的值    /dir1/dir2/dir3
		${file%.*}  拿掉最后一个.及其右边的值    /dir1/dir2/dir3/my.file
		${file%%/*} 拿掉第一个/及其右边的字符串  -->空
		${file%%.*} 拿掉第一个/及其右边的字符串
	shell字符串取子串
		${s:pos:len} 取s，从pos（包括该字符）的长度为len的子串
		${file:0:5}
		${file:5:5}
	shell字符串变量的替换
		${file/dir/path}     将第一个dir替换成path
		${file//dir/path}    将全部dir替换成为path
	shell针对变量的不同状态
		${file-my.file.txt}
		#如果file没有设定，则使用 使用my.file.txt作为返回值, 否则返回${file};(空值及非空值时，不作处理。);
		${file:-my.file.txt}
		#如果file没有设定或者${file}为空值, 均使用my.file.txt作为其返回值，否则，
		返回${file}.(${file} 为非空值时，不作处理);
		${file:+my.file.txt}
		#如果${file}为非空值, 则使用my.file.txt作为其返回值，否则，(未设定或者为空值时)不作处理。
		${file+my.file.txt}
		#如果file已设定(为空值或非空值), 则使用my.file.txt作为其返回值，否则不作处理。(未设定时，不作处理);
		${file=my.file.txt}
		#如果file为设定，则将file赋值为my.file.txt，同时将${file}作为其返回值；
		否则，file已设定(为空值或非空值)，则返回${file}。
		${file:=my.file.txt}
		#如果file未设定或者${file}为空值, 则my.file.txt作为其返回值， 同时，将${file}赋值为my.file.txt，
		否则，(非空值时)不作处理。
		${file?my.file.txt}
		#如果file没有设定，则将my.file.txt输出至STDERR, 否侧， 已设定(空值与非空值时)，不作处理。
		${file:?my.file.txt}
		#若果file未设定或者为空值，则将my.file.txt输出至STDERR，否则， 非空值时，不作任何处理。

  unset与null以及non-null这三种状态的赋值； 一般而言，与null有关，
  若不带:, null不受影响； 若带 :, 则连null值也受影响
 
  shell字符串的变量长度
   ${#file}
  bash数组的处理方法
   ${A[@]}  ${#A[@]}
   ${A[*]}  ${#A[*]}
   ${A[0]}  ${#A[0]}

4-3.变量替换和赋值不能带空格
    为初始化的变量将会是NULL
    hello=“A B C    D”
    echo '$hello'
    echo "$hello"
    echo $hello
    echo ${hello}
    echo hello

    变量赋值
      var=123
      let var=16+15
      for a in 1 2 3
      read a
      a=`命令的结果传给变量a`
      a=$(...)

#*******************************************************************************
#5.参数  
#*******************************************************************************
5-1.位置参数
	$1 $2 $3 $4 $5 $6 $7 $8 $9
	注意$10 是被解释成$1后跟一个0
		${10}

	$(basename $0)
	$# 可以抓出positional parameter 数量
	[ $# = 0] 

	$* 一个整个单一字段
	$@ 同一个字符串多个个体
	“$*”  
	“$@” 

	shift 就是取消positional parameter 中最左边的参数（$0 不受影响），其余设置为1
		shift 或 shift 1 就是取消$1 ，从而原本的$2变成$1，$3变成$2，依次类推

5-2.getopt命令
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

#*******************************************************************************
#6.分支 循环  
#*******************************************************************************
6-1.$? 
   得到刚刚结束那个进程传回的值 return value（0～255）
   用来判断进程的退出状态

   Shell的内置命令true返回0， false 返回1
   0 值 成功执行--> 真（true）
     true
	 ! true 
	 !true 出发历史机制
   非0 命令没有成功执行 ---> 假（false）

   0 命令成功结束
   1 一般性的未知错误
   2 不合适的shell命令
   126 不可执行
   127 没找到命令
   128 无效退出参数
   128+x x信号相关
   130    Ctrl+C 
   255    正常范围之外的退出状态码
  
   exit 用来结束一个脚本，它返回一个值，这个值会传递给脚本的父进程
        父进程会使用这个值做下一步的处理
    
6-2.test expression 支持测试对象只有三种
                             string integer file
   [ expression ] 
    expression测试为test返回0 （true） ，否则返回0
	expression1 -a expression2 两个expression都为真
	expression1 -o expression2 两个expression都为假
    
	command1 && command2    command2 只有在command1 的 RV为0（true）   的条件下执行
	command1 || command2    command2 只有在command1 的 RV为非0（false）的条件下执行
    
   if-then语句不能测试命令状态码之外的条件，test命令提供了
   在if-then语句中测试不同条件的途径，test命令中列出的条件成立
   test命令就会退出并返回退出状态码0
   test condition
       数值比较    -eq -ge -gt -le -lt -ne
	   字符串比较  = < > 
	               -n 检查字符串长度是否非0
				   -z 检查字符串长度是否为0
				   !=
	   文件比较    -d -e -f -r -s -w -x -O -G 
	               file1 -nt file2
				   file1 -ot file2

6-3.双括号
    (( expression )) 可以使用高级数学表达式 ，expression是任意的数学赋值或比较表达式
    ((...)) 和let 结构也能够返回退出状态码
       当它们所测试的算术表达式的结果为非0的时候，将会返回退出状态码0

     var=10
     if (( $var ** 2 > 90 ))
     then
        (( var2=$var ** 2 ))
     fi

6-4.双方括号 提供了匹配模式
    Bash2.02的Bash中，引入了[[...]]扩展测试命令，注意[[ 是一个关键字，并不是一个命令
    [[ expression ]]

6-5.if
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

  case variable in
     pattern1 | pattern2）commands1；；
     pattern3）command2；；
     *） default commands；；   -->模式不匹配的情况*
  esac

@循环
 for var in list
 do
	commands
 done

 for((i=1;i<=10;i++))
 do
	echo "The next number is $i"
 done


 while test command
 do
	other commands
 done

 until test commands
 do
   other commands
 done

 break      结束loop
 continue   强迫进入下一次循环动作
 return     结束function
 exit       结束script/shell

#*******************************************************************************
#7.文件描述符 I/O redirection 
#*******************************************************************************
7-1.Linux系统将每个对象当作文件处理，包括输入和输出进程
	File Descriptor （fd， 文件描述符）来标示每个文件对象，是非负数可以唯一标示会话中打开的文件

	Linux中任何一个进程都默认打开三个文件
	0： STDIN 标准情况下 keyboard关联 
		shell从STDIN文件描述符对应的键盘获得输入，在用户输入时处理每个字符
	
	1： STDOUT monitor关联
		shell的标准输出，shell的所有输出（包括shell中运行的程序和脚本）会被定向到标准输出中

	2 ：STDERR monitor关联
		shell的标准错误输出，shell或shell中运行的程序和脚本出错时生成的错误消息都会发送到这个位置
		默认会导向STDOUT
		ls -al 2> file1 1> file2

7-2.I/O 重定向 
  用< 来改变读进的数据通道（stdin），使之从指定的文件读进
  用> 来改变输出的数据通道（stdout，stderr），使之输出到指定的文件

  输入重定向 n< input redirection
             0 是< 的预设值， < 与 0< 是一样的
     
	         here document
			 它可以让我们输入一段文本，直到读到<< 后指定的字符串
			 cat << EOF
			   one
			   two
			   three
			   EOF
  重定向输出 >n output redirection
             1> 改变stdout 的输出通道 1> 与 >是相同的
             2> 改变stderr 的输出通道

  2>&1  stderr 并入 stdout
  1>&2  stdout 并入 stderr 

  /dev/null
     null文件的标准位置/dev/null
     cat /dev/null > testfile
  
  >> append

  stdout 与 stderr 的管道线准备好，才会从stdin读入数据

  exec 3>&- 关闭文件描述符

  lsof 命令会列出整个Linux系统打开的所有文件描述符
	lsof -a -p $$ -d 0,1,2

  Linux系统有特殊目录，专供临时文件使用，Linux使用/tmp目录来存放不需要永久保留的文件
  大多数Linux发行版在系统启动时自动删除了/tmp目录的所有文件
	mktemp
	tf=$(mktemp testing.XXXXXX)
	mktemp -t test.XXXXXX  -t 全路径的临时文件
	mktemp -d dir.XXXXXX   -d 临时目录
	
7-3.管道 pipe line
    cmd1 | cmd2 ....... 
    记录消息
    tee 将从STDIN过来的数据同时发往两处，一处是STDOUT，一处时tee命令所指定的文件名
        tee filename
	    tee -a filename

7-4.处理信号
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
	

#*******************************************************************************
#8.Debbug
#*******************************************************************************
8-1.Shell
 #在shell脚本中输出调试信息
 trap 命令用于捕获指定的信号并执行预定的命令
      执行的命令可以是任何合法的shell语句，也可以是函数
 trap ‘cmd’ signal
 shell脚本在执行时，会产生三个所谓的伪信号（由shell产生的），其他信号由操作系统产生
    EXIT 从一个函数退出 或 整个脚本执行完毕
	ERR  当一条命令返回非0状态时（代表命令执行不成功）
	DEBUG 脚本中每一条命令执行之前

 
 tee

 if [ “¥DEBUG” = “true” ]；then
   echo “debugging”
 fi

 #使用shell的执行选项
 -n          只读shell脚本，不实际执行 （检查语法是否错误）
 -x          跟踪方式，显示锁执行的每一条命令
    $LINENO
	$FUNCNAME
	$PS4
 -c “string” 从strings中读取命令

#*******************************************************************************
#9.资料 
#*******************************************************************************
# Books
#   Advanced Bash-Scripting Guide
# Net
#   ChinaUnix.nex
#   LinuxSir.org







```

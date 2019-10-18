##

```
1 shell 基本概述
  Shell 命令解释器
  Shell 脚本规范 
  以./ 执行脚本注意脚本的权限

2 shell变量定义variables
  =====2.1 用户自定义变量，当前shell有效=======================
      var=“hello” 
      echo ${var}_log
      echo $var_log
      echo “${var} world”

	  set 显示所有变量
	  set | grep 
	  unset 取消变量 

      双引号 echo “${var} world”
      单引号 echo ‘${var} world’ ➡️。${var} world
	         echo “${var} world \$500” 
  =====2.2 系统变量===============================================
   使用系统定义好的变量
   $HOME
   $HOSTNAME
   $PWD

   使用export 导入环境变量 
  ===2.2 位置参数变量=================================================
    脚本后面写入的内容，空格分隔
    $0 shell脚本名
	$1  $2  $3  $4  $5  $6 $7 $8 $9 ${10}
    $*  所有的位置参数 	        
	$@  所有的位置参数
        未加引号，两者一样，返回传入的参数
		加了引号，$*把传入的参数作为一个字符串整体 $@把传入每个参数作为一个字符串返回 
    $#  总共传递的参数个数
    $$  当前程序运行的PID
    $?  上一个命令执行的返回结果
  ====.4 通过交互的方式传递变量================================================
    read
  补充：
   命令替换
   $(command)。 ， `command`
   echo "This is $((`date +%Y`-7))"
   命令嵌套
   $( $() )
  =====2.5 变量替换===============================================
     ${变量#匹配规则}           从头开始匹配，最短删除
	 ${变量##匹配规则}          从头开始匹配，最长删除
	 ${变量%匹配规则}           从尾部开始匹配，最短删除 
	 ${变量%%匹配规则}          从尾部开始匹配，最长删除    
	 ${变量/匹配规则/新字符串}  替换第一个找到的字符串
	 ${变量//匹配规则/新字符串} 全部替换

3 shell数值运算expr bc
   整数运算，expr，$(()) , $[] 不支持小数

4 shell流程控制if case
  4.1 IF
   if[ condition ]; then
         command
   fi 
   /////
   if [conditon ]; then
		command
   else
		command
   fi
   ///
   if [ ];then
	  command
   elif [ ];then
      command
   elif [ ];then
      command
   else
      command
   fi	  
  ====比对================================================
  文件判断
    -r  -w  -x
    -f  -d 
    -e  -s
  🌟 []&&command||command
  整数比对
     -eq -ne -gt -lt -ge -le
  字符串比对
    =   != 
    -z  字符串的长度为0    则为真
    -n  字符串的长度不为空 则为真
    str1 > str2
    str1 < str2
  正则比对
    [[]]    
  ====case================================================
  case 变量 in
  变量 1）
      命令;;
  变量 2）
      明亮;;
  *)
    默认匹配命令
  esac
6 shell循环语句for while
  6.1  
    for var in 
    do
   
    done
  
  6.2
    while condition
	do
		command;
	done

	while read line
	do
		echo "$line"
	done <test.txt

7 shell 数组array function
  =====7.1function=========================================
  function funName(){
	commands;
  }

  funName(){
   commands;
  }
  函数参数

  函数退出状态
    echo    100 返回函数执行后的数据  var接受
    return  1   返回函数的执行状态    $? 接受
  =====7.2 array===============================================
  ary=(a b c) 注意用空格隔开每个元素

  ${ary[*]}
  ${ary} , ${ary[0]}
  
  ${ary[@]}  取所有值
  ${!ary[@]} 取所有索引
  ${#ary[@]} 取数组的长度

  关联数组
  #info=([name]=bgx,[age]=18)
  declare -a ary='([0]="linux" [1]="hello")'

  数组赋值注意不能有空格
  file[0]=ooo

8 shell正则表达式 sed awk
  ==8.1==grep================================================
  
  
  ====================================================




```

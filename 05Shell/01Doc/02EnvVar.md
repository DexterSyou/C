### environment variable

```
1/ 环境变量
   bash shell 用一个叫做环境变量的特性来存储有关shell会话 和 工作环境信息

   #1.全局环境变量
      全局变量可用于进程的所有子shell

	  查看全局变量
      env
	  printenv  或 printenv HOME   
	  echo $HOME

   #2.局部环境变量
      只能在定义它们的进程中可见

	  set命令会显示为某个特定进程设置的所有环境变量，包括局部变量，全局变量以及用户定义变量

   #3.用户定义变量
      
	  设置全局环境变量，先创建一个局部环境变量，然后再把它export到全局环境中   
      （1） 修改子shell中全局变量不会影响到父shell中该变量的值
	  （2） 删除子shell中全局变量也不会影响到父shell中该变量
	  （3）	无法使用export命令改变父shell中全局变量的值
      删除环境变量 unset
   #4.默认环境变量
   #5.PATH 
	  PATH=$PATH:.
   #6.定位系统环境变量
      登录时默认 登录shell
	  交互式shell
	  运行脚本的非交互shell

2/ 数组变量
   echo ${ary[idx]}
   echo ${ary[*]}
   unset ary[idx]
   unset ary
   























```

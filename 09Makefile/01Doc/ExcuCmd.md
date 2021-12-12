### 命令

```
#1 命令执行
   上一条命令的结果应用在下一条命令时，你应该使用分号分隔这两条命令
   exec:
     cd /home/hchen; pwd

   make一般是使用环境变量SHELL中所定义的系统 Shell 来执行命令，
   默认情况下使用UNIX的标准Shell——/bin/sh 来执行命令


#2 命令出错
   make 就会终止执行当前规则，这将有可能终止所有规则的执行
   
   /忽略命令的出错
   Makefile 的命令行前加一个减号 - (在 Tab 键之 后)，标记为不管命令出不出错都认为是成功的
   给 make 加上 -i 或是 --ignore-errors 参数，那么，Makefile 中所有命 令都会忽略错误
   如果一个规则是以.IGNORE作为目标的，那么这个规则中的所有命令将会忽略错误
   make的参数的是 -k 或是 --keep-going,如果某规则中的命令出错了，那么就终止该规则的执行，但继续执行其它规则

   /变量作用域
   export <variable ...>;     传递变量到下级Makefile中
      export variable = value

	  variable = value 
	  export variable


   unexport <variable ...>;   不想让某些变量传递到下级Makefile中
   有两个变量，一个是SHELL ，一个是MAKEFLAGS ，
   这两个变量不管你是否 export， 其总是要传递到下层 Makefile 中，特别是 MAKEFLAGS 变量，
   其中包含了 make 的参数信息，如果我们执行“总控 Makefile”时有 make 参数
   或是在上层 Makefile 中定义了这个变量，那么 MAKEFLAGS 变量将会是这些参数，
   并会传递到下层 Makefile 中，这是一个系统级的环境变量
 
   cd subdir && $(MAKE) MAKEFLAGS=  #不想往下层传递参数

   /定义命令包
   define cmd
   cmds
   endef



```

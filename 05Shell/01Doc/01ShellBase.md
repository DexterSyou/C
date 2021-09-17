##  SHELL BASE 

```
1/ 基本脚本
   #1.必须在文本第一行指定创建shell脚本的 使用shell
      #！/bin/bash      # 用作注释
                        # 第一行是个例外，#后面的❗️ 会告诉shell 用哪个shell运行脚本
   #2.echo 显示文本字符串，默认情况下，不需要使用引号将要显示的文本字符串划定出来
          可用单引号或双引号来划定文本字符串

		  -n 使文本字符串 和 命令输出显示在同一行中
     
2/ 变量
   #1.环境变量
      shell维护着一组环境变量，用来记录特定的系统信息

	  set 命令用来显示一份完整的当前环境变量列表
   #2.用户变量
      变量和等号之间不能出现空格
	  在脚本整个生命周期里，shell脚本中定义的变量会一直保持着它们的值，shell脚本结束时会被删掉
      引用一个变量值时，需要使用$
   #3.命令替换,从命令输出中提取信息，并将其赋给变量
      命令替换会创建一个子shell来运行对应的命令。      
	  反引号 ``
      $()

3/ 重定向
   #1.输出：
       1）command  >   outfile
       2）command  >>  outfile
   #2.输入：
       1）command < inputfile
      
	   2）command << marker
	      data
	      marker
           
		  wc << EOF        #PS2环境变量中定义的次提示符
		  test string1
		  test string 2
		  EOF
    #3. 管道 一个命令的输出重定向到另一个命令
        command1 | command2
        命令会同时运行，系统内部将它们连接起来

4/ 数学表达式
   expr
   
   $[ operation ]

   bc bash计算器中的创建的变量只在bash计算器有效，不能在shell脚本中使用
      scale 保留的消暑位数，默认值为0
	  variable=$(bc << EOF
	  options
	  startments
	  expressions
	  EOF
	  )

      variable=$(echo "options;expression" | bc)

5/ 退出
   shell中运行的每个命令都使用exit status，退出状态码0～255，在命令结束时传给shell
   
   #1. 变量 $? 来保存上个已执行命令的退出状态码，shell所执行的最后一条命令的退出状态
       0        命令成功结束 
	   1        一般性未知错误（无效参数）
	   2        不适合的shell命令
	   126      命令不可执行（一般用户没有权限）
	   127      没找到命令
	   128      无效的退出参数
       128+x    与Linux信号x相关的严重错误 
	   130      Ctrl+C终止状态
	   255      正常范围之外退出状态
   #2. shell脚本会以脚本中的最后一个命令的退出状态码退出
       exit命令允许你在脚本结束指定一个退出状态码
	       退出状态码被缩减到0～255区间，通过模运算得到结果（指定数值除以256）。
		   一个值的模运算--->被除后的余数
   
6/ if-then语句
   #1. if-then
      bash shell的if语句会执行if后面的命令，如果该命令成功运行（退出状态码是0）
      位于then部分的命令就会被执行。若果命令不成功，then的部分不会被执行。
      (1)
        if command
        then
           commands
        fi
      (2)
        if command; then
	       commands
        fi
   #2. if-then-else
       if command
	   then
	      commands
	   else
		  commands
	   fi
   #3. if command1
       then
	      commands
	   elif command2
	   then
	      more commands
	   else                #这里的else，不属于if-then的代码块，属于elif then的代码块
		  more commands 
	   fi
      bash会依次执行if，只有第一个返回退出状态码0的语句中的then部分 会被执行

7/ 测试条件（判断条件）
   #1.test
     if-then不能测试命令退出状态码以外的 条件
     test命令提供了在if-then语句中测试不同条件的途径
     test condition   -->condition是test命令要测试的一系列参数 和 值
	   if test condition
	   then
	      commands
	   fi
       如果test命令中列出的条件成立，test命令就会退出并返回退出状态码0
       如果test命令中的条件不成立，test命令就会退出并返回非零的退出状态，if-then语句不会再执行
       如果test命令的condiotion部分不写，会以非零的退出状态码退出
   #2.另一种测试条件
      if [ condiotion ]  #注意[] 前后要有space
	  then
	      commands
	  fi
   #3 test 判断三类条件
      （1）数值比较(浮点数会有限制，bash只能处理整数)
	       n1 -eq n2   # =
		   n1 -ge n2   # >=
		   n1 -gt n2   # >
		   n1 -le n2   # <=
		   n1 -lt n2   # <
		   n1 -ne n2   # !=
	  （2）字符串比较
           标准的ASCII顺序，根据每个字符的ASCII数值来决定
		   sort命令使用的是系统的本地化语言设置中定义的排序顺序
		   str1 = str2 #所有的标点和大小写
		   str1 ！= str2
		   str1 < str2 # 需要转义 /<
		   str1 > str2 # 需要转义 />
		   -n str1     # str1的长度是否 非0
		   -z str1     # str1的长度是否 为0
	  （3）文件比较，测试Linux文件系统上文件和目录的状态
	       -d file   file是否存在并是一个目录
		   -e file   file是否存在              # 可用于文件或目录
		   -f file   file是否存在并是一个文件
		   -r file   file是否存在并可读 
		   -s file   file是否存在并非空
		   -w file   file是否存在并可写
		   -x file   file是否存在并可执行
		   -O file   file是否存在并属当前用户所有
		   -G file   file是否存在并且默认组与当前用户相同   
		   file1 -nt file2  file1是否比file2新
		   file1 -ot file2  file1是否比file2旧
     #4.复合条件测试
	    [ condition ] && [ condition ]      # 两个都符合
		[ condition ] || [ condition ] 
		布尔逻辑是 能够将返回值简化为TRUE 或 FALSE
     #5.bash提供了两项可在if-then语句中使用的高级特性
	    用于数学表达式的双括号
             (( experssion ))   
		用于高级字符串处理功能的双方口号
             [[ expression ]]
		     提供了匹配模式 [[ file == test* ]] 
     #6. case 命令会将指定的变量与不同模式进行比较
	    case variable in
		pattern1 | pattern2）commands1;;
		pattern3) command2;;
        *) default commands;;
		esac
       







```

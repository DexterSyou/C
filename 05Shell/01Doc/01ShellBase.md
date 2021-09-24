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

8/ 循环语句
   #1. for命令，创建一个遍历一系列的循环。
       每次迭代都使用其中一个值来执行已定义好的一组命令。
       for var in list
	   do
		  commands
	   done
       或
       for var in list; do
	   done
    （1）读取列表中的值
	     最后一次迭代后，var变量的值会在shell脚本的剩余部分一直保持有效。
    （2）读取列表中的复杂值
	     for命令用空格来划分列表中的每个值
         使用转义字符来将单引号转义
		 使用双引号来定义用到单引号的值（在某个值两边使用双引号时，shell并不会讲双引号当成值的一部分）
	（3）从变量读取列表
	（4）从命令读取值（使用命令替换来执行任何产生输出的命令）    
   #2. for命令
     （1）更改字段分隔符
      内部字段分隔符IFS环境变量， 定义了bash shell用作之短分隔符的一系列字符。
	  默认情况下（列表中一个新数据字段的开始）：
	      空格
		  制表符
		  换行符
     （2）用通配符读取目录
      for file in /home/test/*
	  do
		 if[ -d "$file"]   #Linux中，目录名和文件名中包含空格当然是合法的。
		 then
		    commands  
		 fi
	  done
	 （3）C语言风格的for循环
	  for (( variable assignment ; condition ; iteration process ))
   #3. while命令
       允许定义一个要测试的命令，然后循环执行一组命令，只要定义的测试命令返回的是（退出状态码0）
	   每次迭代一开始测试test命令。test命令返回非零退出状态码时，while命令会停止执行那组命令。
	   
	   while test command  #可以定义多个测试命令，只有最后一个测试命令的退出状态码会被用来决定什么时候结束循环
	   do
		 other commands
	   done
   #4. until命令
       只有测试命令的退出状态码不为0，bash shell才会执行循环中列出的命令。
	   一旦测试命令返回了退出状态码0，循环就结束了。
	   until test commmands # 可以多个test命令，
	                        # 只有最后一个命令的退出状态码决定了bash shell是否可以执行other command
	   do
		  other commands
	   done
   #5.nest loop
   #6.控制循环
     （1）break命令， 退出任意类型的循环
	      break n ，  n 指定了要跳出的循环层级，
		              默认情况下，n为1，表明跳出的是当前循环
					  n为2，break命令就会停止下一级的外部循环  
	 （2）continue命令， 提前终止某次循环中的命令，不会完全终止整个循环
	      continue n ， 其中n定义了要继续的循环层级
     （3）循环的输出可以使用管道 或重定向
	      done命令之后加一个处理命令来实现

		  while read -r something
		  do
			  # loop something
		  done < "$inputfile"

9/ 用户输入
   #1. 命令行参数 
       bash shell 会将一些称为位置参数的特殊变量自动的分配给输入到命令行中的所有参数
	   $0          程序名 
	   $1 ～ $9    第一个参数 ～ 直到第九个参数
       ${10} ～    第十个参数 ～ 
	   命令行参数可以是 
	       数值
           字符串（用引号处理特殊字符串，引号只是表明数据的起止位置，并非数据的一部分）
         
       （1）读取脚本名（基于脚本名执行不同功能的脚本）
	       basename 命令返回不包含路径的脚本名
           name=$(basename $0)
	   （2）-n 检测参数是否存在数据
   #2. 特殊参数变量
       $# 含有脚本运行时携带的命令行参数的个数 
       ${!#} 代表了最后一个命令行参数，当参数为0时，该值为脚本名

	   $* 将命令行上所提供的所有参数当作一个单词保存（一个整体）
	   $@ 将命令行上所提供的所有参数当作同一字符串中的多个独立的单词
   #3. 移动变量
       shift 命令能够用来操作命令行参数，默认情况下它会将每个参数变量向左移动一个位置。
	   $0不会改变
       如果参数被移除，该值就被丢弃，无法再恢复






























```

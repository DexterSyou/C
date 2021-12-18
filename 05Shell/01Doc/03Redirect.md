###

```
1/ 重定向 
   #1)文件描述符
     Linux系统将每个对象当作文件处理。包括输入和输出进程。
     Linux用文件描述符（file descriptor）来标识每个文件对象。文件描述符是一个非负整数，
	 可以唯一标识会话中打开的文件。每个进程最多可以有九个文件描述符。

     三个特殊的文件描述符会处理脚本的输入和输出
       0  STDIN文件描述符代表shell的标准输入。
       <  Linux会用重定向指定文件来替换标准输入文件描述符
	       许多bash 命令能接受STDIN的输入 例如：cat ，使用 < 强制cat接受来自另一个非STDIN文件的输入
      
	   1  STDOUT文件描述符代表shell的标准输出
       > 标准输出流会被shell重定向到指定文件
     
	   2  STDERR文件描述符代表shell的标准错误输出
       shell或shell中运行的程序和脚本出错时生成的错误消息都会发送到这个位置
       默认情况下，STDERR文件描述符会和STDOUT文件描述符指向同样的地方
	 
	 2> 只重定向错误
     &> 将STDERR和STDOUT的输出重定向到同一个输出文件
        ls -al test1 test2 &> test3

   #2)在脚本中重定向输出
     （1）临时重定向 >&2  脚本的STDERR文件描述符所指向的位置显示文本
		  
		  ---CODE---
		  #testfile1的内容
          echo "This is an error" >&2  # 
          #COMMAND 
          testfile1 2> testfile2       
		  cat testfile2                # This is an error
    
	#3) 用exec重定向shell在脚本执行期间重定向某个特定文件描述符
	      exec命令启动一个新shell
   
        exec 0< testfile
        exec 1> testfile
        exec 2> testfile
   
   #4)创建自己的重定向
      （1）创建文件描述符
       exec命令来给输出分配文件描述符，和标准的文件描述符一样，
	   一旦将另一个文件描述符分配给一个文件
	   这个重定向就会一直有效，直到你重新分配。
       ---CODE---
	   exec 3> outfile
	   echo “ xxxxx ”
	   echo " yyyyy " >&3  #yyyyy将输入到outfile中
	  
	  （2）重定向文件描述符
	   ---CODE---
	   exec 3>&1          # 文件描述符3重定向到文件描述符1的当前位置，即STDOUT
	   exec 1>outfile     # 将STDOUT重定向到文件 ， 此时文件描述符3仍然只想STDOUT
	   echo "xxxxx" 
	   echo "yyyyy"
	   exec 1>&3          # 将STDOUT重定向到文件描述符3的当前位置，STDOUT又指向了它原来的位置
	   echo "zzzzz"         
      （3）创建输入文件描述符
       exec 6<&0
       exec 0< testfile
	   #commands
	   exec 0<&6
      （4）创建读写文件描述符
       exec 3<>testfile   # shell会维护一个内部指针，指明在文件中的当前位置
	                      # 注意数据容易被重写
	  （5）关闭文件描述符
	   创建新的输入或输出文件描述符，shell在脚本退出时会自动关闭它们

	   手动关闭 exec 3>&- ，
	     不能向关闭的描述符写入数据
         再打开已经关闭的文件（打开一个新的文件，原有数据被替换）
	  （6）列出打开的文件描述符
	       lsof 命令会列出整个Linux系统打开的所有文件描述符
           -p
		   -d
		   -a 对选项的结果执行布尔AND运算
      （7）阻止命令输出
	       shell输出到null文件的任何数据都不会保存，全部被丢掉
		   Linux系统上null文件的标准位置是/dev/null
		   cat /dev/null > testfile # clear 数据
      （8）临时文件
	       /tmp目录来存放不需要永久保留的文件
		   系统启动时删除/tmp目录的所有文件
		   mktemp命令可以在/tmp目录中创建一个唯一的临时文件

		   mktemp testing.XXXXXX    # mktemp 命令会用6个字符码替换6个X
           mktemp -t testing.XXXXXX # 强制mktemp命令在/tmp目录下来创建该文件，并返回用来创建临时文件的全路径
		   mktemp -d dir.XXXXXX     # 创建临时目录
	  （9）记录消息
	       tee 将从STDIN过来的数据同时发往两处（STDOUT 与 tee命令行所指定的文件名）
		   默认情况下，tee命令会在每次使用时覆盖输出文件内容
		   tee filename
		   date | tee testfile
		   date | tee -a testfile # 数据追加到文件中
                
   




















```


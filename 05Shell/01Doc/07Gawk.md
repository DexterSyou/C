## Gawk

```
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
1/ gawk 程序
   gawk程序是Unix中的原始awk程序的GNU版本。
   gawk程序让流编辑迈上了一个新的台阶，它提供了一种编程语言而不只是编辑器命令。
   在gawk编程语言中 
	   定义变量来保存数据;
       使用算术和字符串操作符来处理数据;
	   使用结构化编程概念(比如if-then语句和循环)来为数据处理增加处理逻辑;
	   通过提取数据文件中的数据元素，将其重新排列或格式化，生成格式化报告。

	  gawk程序的报告生成能力通常用来从大文本文件中提取数据元素，并将它们格式化成可读的报告。

---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
2/ gawk命令格式
   gawk options program file
   -F fs          指定行中划分数据字段的字段分隔符
   -f file        从指定的文件中读取程序
   -v var=value   定义gawk程序中的一个变量及其默认值
   -mf N          指定要处理的数据文件中的最大字段数
   -mr N          指定数据文件中的最大数据行数
   -W keyword     指定gawk的兼容模式或警告等级

   1.从命令行读取程序脚本
      gawk命令行假定脚本是单个文本字符串，你还必须将脚本放到单引号中
	  (1) gawk '{print "Hello World!"}'
	  
	      没有在命令行上指 定文件名，所以gawk程序会从STDIN接收数据
          如果你输入一行文本并按下回车键，gawk会对这行文本运行一遍程序脚本。
		  跟sed编辑器一样，gawk程序会针对数据流中的每行文本执行程序脚本。由于程序脚本被设为显示一行固定的文
          本字符串，因此不管你在数据流中输入什么文本，都会得到同样的文本输出。

          bash shell提供了一个组合键来生成 EOF(End-of-File)字符。Ctrl+D组合键会在bash中产生一个EOF字符。
		  这个组合键能够终止该gawk 程序并返回到命令行界面提示符下。
   2.使用数据字段变量
      gawk -F: '{print $1}' /etc/passwd
      
	  gawk的主要特性之一是其处理文本文件中数据的能力。它会自动给一行中的每个数据元素分配一个变量。
	       $0代表整个文本行;
		   $1代表文本行中的第1个数据字段;
		   $2代表文本行中的第2个数据字段;
		   $n代表文本行中的第n个数据字段。
		     在文本行中，每个数据字段都是通过字段分隔符划分的。
		     gawk在读取一行文本时，会用预定义的字段分隔符划分每个数据字段。
			 gawk中默认的字段分隔符是任意的空白字符
   3.在程序脚本中使用多个命令
      echo "My name is Rich" | gawk '{$4="Christine"; print $0}' 
   4.从文件中读取程序
     跟sed编辑器一样，gawk编辑器允许将程序存储到文件中
	 cat script2.gawk
     {print $1 "'s home directory is " $6}
     
	 cat script3.gawk
     {
       text = "'s home directory is " 
	   print $1 text $6
	 }
	 
	 gawk -F: -f script2.gawk /etc/passwd
   5.在处理数据前运行脚本
     默认情况下，gawk会从输入中读取一行文本，然后针对该行的数据执行程序脚本。

     (1) gawk 'BEGIN {print "Hello World!"}' #强制gawk在读取数据前执行BEGIN关键字后指定的程序脚本。 

     (2) $ gawk 'BEGIN {print "The data3 File Contents:"} 
	     > {print $0}
         > END {print "End of File"}' data3.txt

---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9

```

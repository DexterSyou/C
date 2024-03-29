## Sed编辑器

```
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
1/ sed编辑器
   sed编辑器被称作流编辑器(stream editor)，和普通的交互式文本编辑器恰好相反。
   在交互式 文本编辑器中(比如vim)，你可以用键盘命令来交互式地插入、删除或替换数据中的文本。
   流编辑器则会在编辑器处理数据之前 基于预先提供的一组规则 来编辑数据流。

   sed编辑器会执行下列操作
    (1) 一次从输入中读取一行数据。
	(2) 根据所提供的编辑器命令匹配数据。
	(3) 按照命令修改流中的数据。
    (4) 将新的数据输出到STDOUT。
   sed编辑器可以根据命令来处理数据流中的数据，这些命令要么从命令行中输入，要么在一个命令文本文件中。
   在流编辑器将所有命令与一行数据匹配完毕后，它会读取下一行数据并重复这个过程
   在流编辑器处理完流中的所有数据行后，它就会终止。

---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
2/ sed命令的格式
   sed options script file

   -e script  在处理输入时，将script中指定的命令添加到已有的命令中
   -f file    在处理输入时，将file中指定的命令添加到已有的命令中
   -n         不产生命令输出，使用print命令来完成输出

   1. 在命令行定义编辑器命令
      默认情况下，sed编辑器会将指定的命令应用到STDIN输入流上
	  可以直接将数据通 过管道输入sed编辑器处理
	  (1)  echo "This is a test" | sed 's/test/big test/' 
		这个例子在sed编辑器中使用了s命令。s命令会用斜线间指定的第二个文本字符串来替换第 一个文本字符串模式。
		在运行这个例子时，结果应该立即就会显示出来。
  
      (2) #cat data1.txt
	       sed 's/dog/cat/' data1.txt
	       sed编辑器并不会修改文本文件的数据。它只会将修改后的数据发送到 3 STDOUT。
   2. 在命令行使用多个编辑器命令
      sed -e 's/brown/green/; s/dog/cat/' data1.txt
   3. 从文件中读取编辑器命令
      cat script1.sed
	      s/brown/green/ 
	      s/fox/elephant/ 
	      s/dog/cat/
      sed -f script1.sed data1.txt

---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
3/ 更多的替换选项
   1.替换标记
     默认情况下它只替换每行中出现的第一处。
	 要让替换命令能够替换一行中不同地方出现的文本必须使用替换标记(substitution flag)。
	 替换标记会在替换命令字符串之后设置。

     s/pattern/replacement/flags
	    数字，表明新文本将替换第几处模式匹配的地方;
	    g，表明新文本将会替换所有匹配的文本;
	    p，表明原先行的内容要打印出来;
	    w file，将替换的结果写到文件中。

	(1) sed 's/test/trial/'  data4.txt
	(2) sed 's/test/trial/2' data4.txt
    (3) sed 's/test/trial/g' data4.txt
    (4) -n选项将禁止sed编辑器输出
        p替换标记会输出修改过的行
		二者配合使用的效果就是 只输出被替换命令修改过的行。
		sed -n 's/test/trial/p' data5.txt

		w替换标记会产生同样的输出，不过会将输出保存到指定文件中。
        sed 's/test/trial/w test.txt' data5.txt
    		   sed编辑器的正常输出是在STDOUT中，而只有那些包含匹配模式的行才会保存在指定的输出文件中。
     2.替换字符
       sed编辑器允许选择其他字符来作为替换命令中的字符串分隔符
	   sed 's!/bin/bash!/bin/csh!' /etc/passwd

---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
4/ 使用地址
   默认情况下，在sed编辑器中使用的命令会作用于文本数据的所有行。
   如果只想将命令作用 于特定行或某些行，则必须用行寻址(line addressing)。

   在sed编辑器中有两种形式的行寻址,使用相同的格式来指定地址: [address]command
   也可以将特定地址的多个命令分组:
    address {
        command1
        command2
        command3
	}
   sed编辑器会将指定的每条命令作用到匹配指定地址的行上
      以数字形式表示行区间
	  用文本模式来过滤出行

   1.数字方式的行寻址	
     sed编辑器会将文本流 中的第一行编号为1，然后继续按顺序为接下来的行分配行号。
	 (1) sed '2s/dog/cat/' data1.txt
	 (2) sed '2,3s/dog/cat/' data1.txt
	 (3) sed '2,$s/dog/cat/' data1.txt #从某行开始的所有行
   2.使用文本模式   过滤器
     sed编辑器允许指定文本模式来过 滤出命令要作用的行
     /pattern/command
     sed编辑器在文本模式中采用了一种称为正则表达式(regular expression)的特性来帮助你创建匹配效果更好的模式
  
     (1) sed '/Samantha/s/bash/csh/' /etc/passwd #该命令只作用到匹配文本模式的行上
   3.命令组合
     在单行上执行多条命令，可以用花括号将多条命令组合在一起。
	 sed编辑器会处理地址行处列出的每条命令。 
   4.删除行
     文本替换命令不是sed编辑器唯一的命令。
     删除命令d名副其实，它会删除匹配指定寻址模式的所有行。忘记加入寻址模式的话，流中的所有文本行都会被删除。
     sed编辑器不会修改原始文件。你删除的行只是从sed编辑器的输出中消失了。原始文件仍然包含那些“删掉的”行。
	 (1) sed 'd' data1.txt
	 (2) sed '3d' data6.txt
	 (3) sed '2,3d' data6.txt
	 (4) sed '3,$d' data6.txt
	 (5) sed '/number 1/d' data6.txt  #sed编辑器会删掉包含匹配指定模式的行。
     (6) sed '/1/,/3/d' data6.txt
	     两个文本模式来删除某个区间内的行
		 指定的第一个模式 会“打开”行删除功能，第二个模式会“关闭”行删除功能。
		 sed编辑器会删除两个指定行之间的所有行(包括指定的行)。
  
         ⚠️ 要sed编辑器在数据流中匹配到了开始模式，删除功能就会打开
           删除功能在匹配到第一个模式的时候打开了，但一直没匹配到结束模式，整个数据流有可能都被删掉了。
    5.插入和附加文本
      sed编辑器允许向数据流插入和附加文本行
	   插入(insert)命令(i)会在指定行前增加一个新行
	   附加(append)命令(a)会在指定行后增加一个新行

	  格式: sed '[address]command new line' #new line中的文本将会出现在sed编辑器输出中你指定的位置
	  (1) echo "Test Line 2" | sed 'i\Test Line 1'
	  (2) echo "Test Line 2" | sed 'a\Test Line 1'
	  (3) $ sed '3i\
          > This is an inserted line.' data6.txt

          $ sed '$a\
          > This is a new line of text.' data6.txt #将新行附加到数据流的末尾

          $ sed '1i\
          > This is one line of new text.\                #数据流起始位置增加一个新行
          > This is another line of new text.' data6.txt  #指定的两行都会被添加到数据流中
     6.修改行
       修改(change)命令允许修改数据流中整行文本的内容。
	   它跟插入和附加命令的工作机制一样，你必须在sed命令中单独指定新行。
       (1) $ sed '3c\
           > This is a changed line of text.' data6.txt
       (2) $ sed '/number 3/c\
           > This is a changed line of text.' data6.txt
           #文本模式修改命令会修改它匹配的数据流中的任意文本行。
	   (3) $ sed '2,3c\
           > This is a new line of text.' data6.txt
           #sed编辑器会用这一行文本来替换数据流中的两行文本，而不是逐一修改这两行文本。
     7.转换命令
	   转换(transform)命令(y)是唯一可以处理单个字符的sed编辑器命令。
	   转换命令格式: [address]y/inchars/outchars/
	                 转换命令会对inchars和outchars值进行一对一的映射。
	                 inchars中的第一个字符会被转换为outchars中的第一个字符，
	                 第二个字符会被转换成outchars中的第二个字符。
	                 这个映射过程会一直持续到处理完指定字符。
	                 如果inchars和outchars的长度不同，则sed编辑器会产生一条错误消息。
  
       转换命令是一个全局命令,会文本行中找到的所有指定字符自动进行转换，而不会考虑它们出现的位置。
       echo "This 1 is a test of 1 try." | sed 'y/123/456/'
       sed 'y/123/789/' data8.txt
 	 8.回顾打印
       p标记和替换命令显示sed编辑器修改过的行。另外有3个命令也能用来打印数据流中的信息:	  
       (1) p命令用来打印文本行,p命令可以打印sed编辑器输出中的一行
	     $ echo "this is a test" | sed 'p'
		 this is a test
         this is a test
         $ 

		 sed -n '/number 3/p' data6.txt #-n选项，你可以禁止输出其他行
		 sed -n '2,3p' data6.txt

         $ sed -n '/3/{
         >p                      #脚本用p命令来打印出原 始行
         > s/line/test/p         #用s命令替换文本，并用p标记打印出替换结果
         > }' data6.txt
         This is line number 3.
		 This is test number 3. 
		 $

	   (2) 等号(=)命令用来打印行号
	       等号命令会打印行在数据流中的当前行号。
	       行号由数据流中的换行符决定。每次数据流中出现一个换行符，sed编辑器会认为一行文本结束了。   
	       
		   sed编辑器在实际的文本行出现前打印了行号

		   $ sed -n '/number 4/{ 
		   >=
           >p
           > }' data6.txt
	   
	   (2) l(小写的L)命令用来列出行
           列出(list)命令(l)可以打印数据流中的文本和不可打印的ASCII字符。
  		   任何不可打印字符要么在其八进制值前加一个反斜线，要么使用标准C风格的命名法
           $ cat data9.txt
           This line contains tabs. 
		   $
           $ sed -n 'l' data9.txt 
		   This\tline\tcontains\ttabs.$
           $

     9.使用sed处理文件
       (1) 写入文件       [address]w filename
		   filename可以使用相对路径或绝对路径,运行sed编辑器的用户都必须有文件的写权限。 
           
           sed '1,2w test.txt' data6.txt
       (2) 从文件读取数据 [address]r filename
           读取(read)命令(r)允许你将一个独立文件中的数据插入到数据流中。
           
		   filename参数指定了数据文件的绝对路径或相对路径,
		   你在读取命令中使用地址区间，只能指定单独一个行号或文本模式地址
           sed编辑器会将文件中的文本插入到指定地址后。

           sed '$r data12.txt' data6.txt #在数据流的末尾添加文本

		   利用另一个文件中的数据来替换文件中的占位文本。
		   $ sed '/LIST/{
           > r data11.txt
           >d
           > }' notice.std

---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
/5 sed进阶
   1.多行命令
     N:将数据流中的下一行加进来创建一个多行组(multiline group)来处理。
	 D:删除多行组中的一行。
	 P:打印多行组中的一行。
 
     (1) next命令
         n命令会告诉sed编辑器移动到数据流中的下一文本行，而不用重新回到命令的最开始再执行一遍。
         sed编辑器执 行完命令脚本后，会从数据流中读取下一行文本开始执行命令脚本。
         
		 合并文本行
		     单行next命令会将数据流中的下一文本行移动到sed编辑器的工作空间(称为模式空间)。
             多行版本的next命令(用大写N)会将下一文本行添加到模式空间中已有的文本后。
              这样的作用是将数据流中的两个文本行合并到同一个模式空间中。文本行仍然用换行符分隔，
			  但sed编辑器现在会将两行文本当成一行来处理。
















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

## 正则表达式

```
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
1/ 正则表达式
   正则表达式是你所定义的模式模板(pattern template)，Linux工具可以用它来过滤文本
   Linux 工具(比如sed编辑器或gawk程序)能够在处理数据时使用正则表达式对数据进行模式匹配
   
   数据流--->正则表达式---->匹配的数据
               |
			   |----------> 过滤掉的数据

---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
2/ 正则表达式的类型
   Linux中的不同应用程序可 能会用不同类型的正则表达式。
      编程语言(Java、Perl和Python)
	  Linux实用工具(比如sed编辑器、gawk程序和grep工具)
	  主流应用(比如MySQL和PostgreSQL数据库服务器)

   正则表达式是通过正则表达式引擎(regular expression engine)实现的。
   正则表达式引擎是一套底层软件，负责解释正则表达式模式并使用这些模式进行文本匹配。
   在Linux中，有两种流行的正则表达式引擎:
          a.POSIX基础正则表达式(basic regular expression，BRE)引擎
                POSIX BRE引擎通常出现在依赖正则表达式进行文本过滤的编程语言中。
                有些工具(比如sed编辑器)只符合了BRE引擎规范的子集。
		  b.POSIX扩展正则表达式(extended regular expression，ERE)引擎
                gawk程序用ERE引擎来处理它的正则表达式模式。

    1.定义BRE模式
       最基本的BRE模式是匹配数据流中的文本字符
	   正则表达式并不关心模式在数据流中的位置。它也不关心模式出现了多少次。
	   一旦正则表达式匹配了文本字符串中任意位置上的模式，它就会将该字符串传回Linux工具。 
      
	  （1）纯文本
       正则表达式模式都区分大小写。
	   在正则表达式中，你不用写出整个单词。只要定义的文本出现在数据流中，正则表达式就能够匹配。
       在正则表达式中，空格和其他的字符并没有什么区别。
      （2）特殊字符
	   正则表达式识别的特殊字符包括: .*[]^${}\+?|()
          不能在文本模式中单独使用这些字符就行了
          如果要用某个特殊字符作为文本字符，就必须转义。在转义特殊字符时，
		  在它前面加一个特殊字符来告诉正则表达式引擎应该将接下来的字符当作普通的文本字符。
		  这个特殊字符就是反斜线 \ 。
          $ sed -n '/\$/p' data2

        要使用正斜线，也需要进行转义
	    $ echo "3 / 2" | sed -n '/\//p'
      （3）锚字符
	      锁定在行首， 脱字符(^)定义从数据流中文本行的行首开始的模式。
          $ sed -n '/ this/p' data3 

          脱字符放到模式开头之外的其他位置，那么它就跟普通字符一样

		  锁定在行尾，特殊字符美元符($)定义了行尾锚点。
		  $ echo "This is a good book" | sed -n '/book$/p'

		  组合锚点，同一行中将行首锚点和行尾锚点组合在一起使用
		  $ sed '/ $/d' data5
		      定义的正则表达式模式会查找行首和行尾之间什么都没有的那些行。
			  空白行
      （4）点号字符
	       特殊字符点号用来匹配除换行符之外的任意单个字符。
		   它必须匹配一个字符，如果在点号字符的位置没有字符，那么模式就不成立。 
           $ sed -n '/.at/p' data6  
	  （5）字符组，定义用来匹配文本模式中某个位置的一组字符。    
           字符组必须匹配一个字符

		   $ sed -n '/[ch]at/p' data6
		   字符组中必须有个字符来匹配相应的位置。
		   $ echo "yeS" | sed -n '/[Yy][Ee][Ss]/p'
           $ sed -n '/[0123]/p' data7

		   在正则表达式模式中，也可以反转字符组的作用。
		   $ sed -n '/[^ch]at/p' data6
       
	       特殊的字符组:
	         [[:alpha:]]   匹配任意字母字符，不管是大写还是小写
			 [[:alnum:]]   匹配任意字母数字字符0~9、A~Z或a~z
			 [[:blank:]]   匹配空格或制表符
			 [[:digit:]]   匹配0~9之间的数字
			 [[:lower:]]   匹配小写字母字符a~z
			 [[:print:]]   匹配任意可打印字符
			 [[:punct:]]   匹配标点符号
			 [[:space:]]   匹配任意空白字符:空格、制表符、NL、FF、VT和CR
			 [[:upper:]]   匹配任意大写字母字符A~Z
	   (6) 区间
	       $ sed -n '/^[0-9][0-9][0-9][0-9][0-9]$/p' data8
		   $ sed -n '/[a-ch-m]at/p' data6

       (7) 星号
	      字符后面放置星号表明该字符必须在匹配模式的文本中出现0次或多次。
		  $ echo "ieeeek" | sed -n '/ie*k/p'
		  $ echo "bt" | sed -n '/b[ae]*t/p'
		  $ echo "bt" | sed -n '/b.*t/p'

     2.扩展正则表达式
	   (1) 问号
	       问号表明前面的字符可以出现0次或1次，但只限于此
		    $ echo "bt" | gawk '/be?t/{print $0}'
	   (2) 加号
	       加号表明前面的字符可以出现1次或多次
		   $ echo "beeet" | gawk '/be+t/{print $0}'
	   (3) 使用花括号
	       ERE中的花括号允许你为可重复的正则表达式指定一个上限。
		   m:正则表达式准确出现m次。
		   m, n:正则表达式至少出现m次，至多n次。

           $ echo "bet" | gawk --re-interval '/be{1}t/{print $0}'
                          指定gawk程序的--re-interval 命令行选项才能识别正则表达式间隔。
	   (4) 管道符号
	       expr1|expr2|...
		   管道符号允许你在检查数据流时，用逻辑OR方式指定正则表达式引擎要用的两个或多个模式。
		   如果任何一个模式匹配了数据流文本，文本就通过测试。
           $ echo "The cat is asleep" | gawk '/cat|dog/{print $0}'

	   (5) 表达式分组
	       正则表达式模式也可以用圆括号进行分组。当你将正则表达式模式分组时，该组会被视为一个标准字符。
           $ echo "Sat" | gawk '/Sat(urday)?/{print $0}'
           $ echo "bat" | gawk '/(c|b)a(b|t)/{print $0}'

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

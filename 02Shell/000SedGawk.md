##两个命令行编辑器

```
sed编辑器
  流编辑器stream editor
  流编辑器则会在编辑器处理数据之前基于预先提供的一组规则来编辑数据流
  sed编辑器可以根据命令来处理数据流中的数据，这些命令要么从命令行中输入，那么存储在一个命令文件中
     1.一次从输入中读取一行数据
	 2.根据所提供的编辑器命令匹配数据
	 3.按照命令修改流中的数据
	 4.将新的数据输出到STDOUT

	 sed options script file
	     -e script
		 -f file
		 -n

命令行定义编辑器命令
  默认情况下，sed编辑器会将指定的命令应用到STDIN输入流上，可以直接将数据通过管道输入sed编辑器处理
  sed 's/xxx/yyy/' testfile.dat
  sed -e 's/aaa/ddd/;s/bbb/ccc/' testfile.dat
  sed 编辑器并不会修改文本文件的数据，只会将修改后的数据发送到STDOUT
  
从文件中sed
 sed -f script.sed file.dat

--------------------------
sed编辑器基础
  替换标记
    s/pattern/replacement/flags
	数字 表明新文本将替换第几处模式匹配的地方
	g 表明新文本将会替换所有匹配的文本
	p 表明原先行的内容要打印出来
	  sed -n ‘s/test/trial/p’ file 
	  -n 选项禁止sed编辑器输出，p输出修改过的行
	w file 将替换的结果写到文件中
	  sed ‘s/test/trial/w file’ fileTest
  
  替换字符
    sed ‘s！/bin/bash！/bin/csh！’ file

  使用地址
    默认情况下，sed编辑器中使用命令会作用于文本数据所有行
	
	以数字形式表示行区间

	用文本模式来过滤出行
    [address] command
	address {
	   command1
	   command2
	   command3
    }

    sed '2s/xxx/yyy/' file
	sed '2,3s/xxx/yyy/' file
	sed '2,$s/xxx/yyy/' file
	
	/pattern/command
    sed '/number 1/d' file
	
	sed '3d'   file
	sed '2,3d' file
    sed '2,$d' file

    sed '[address]command\new line'
	sed 'i\Test Line 1'
	sed 'a\Test Line 1'
    sed 'c\Test Line 1'
    sed '/number 3/c\new Line' 

	sed '$a\new line'
	sed 'li\new line'

转换命令
  transform
  [address]y/inchars/outchars/
  转换命令会对inchars和outchars值进行一对一的映射
  inchars中的第一个字符会被转换outchars中的第一个字符，依次类推直到处理完指定字符
  inchars与outchars的长度不同，则sed编辑器会产生一条错误

  sed ‘y/123/456/’


使用sed处理文件
  写入文件
  [address]w filename
  sed '1,2w test.txt' data6.txt

  sed '3r test.txt' data6.txt


------
Sed 进阶
单行
 sed '/header/{n;d}' file
多行
 sed 'N;s/xxxx.yyyy/zzzz wwww' file

















@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
gawk程序
  gawk程序是Unix中的原始awk程序的GNU版本。提供了一种编程语言
    定义变量来保存数据
	使用算术和字符串操作符来处理数据
	使用结构化编程概念
	通过提取数据文件中的数据元素，将其重新排列或格式化，生成格式化报告
  
  gawk options program file
  
从命令行读取程序脚本
  gwak ‘{print “Hello World！”}’

  gawk程序会从STDIN接受数据，在运行这个程序时，它会一直等待从STDIN输入的文本
  gawk程序会针对数据流中的每行文本执行程序脚本
  Ctrl+D组合生成EOF（End-of-File）

使用数据字段变量
  gwak会自动给一行中的每个数据元素分配一个变量
  $0   代表整个文本行
  $1   代表文本行中的第一个数据字段
  $2   代表文本行中的第二个数据字段 
  $n   代表文本行中的第n个数据字段

  gwak中默认的字段分隔是任意的空白字符（空格 ，制表符）
  gawk ‘{print $1}’ file.dat
  gawk -F: '{print $1}' file.dat
       -F: 指定分隔符：

从文件中读取程序
  gawk -F: -f script.gawk testfile
  
  cat script.gawk
  {
   text = " 's home directory is "	
   print $1 text $6	
  }

  gawk 允许指定程序脚本何时运行
  BEGIN 强制gawk在读取数据前执行BEGIN关键字后指定的程序脚本
  END 

  FS ---> 定义字段分隔符的另一种办法

-------------------------
gawk 进阶
变量
  内建变量
  数据字段是由字段分隔符来划定的。默认情况下，字段分隔符是一个空白符（空格，制表符）
	
	gawk数据字段和记录变量
	FIELDWIDTHS    根据提供的字段宽度来计算字段
	FS             数据字段分隔符
	RS             默认换行符
	OFS            数据流中的数据字段， 默认一个空格，print命令的输出
	ORS            默认换行符

	awk 'BEGIN{FS='\n';RS=""}{print $1,$4}' dataFile

  数据变量
    ARGC
	ARGV
	  数组从索引0开始，代表是命令
	ARGIND
    CONVFMT
	ENVIRON
	  使用关联数组来提取shell环境变量
	  awk 'BEGIN{ print ENVIRON["PATH"] }' 
	ERRNO
	FILENAME
    IGNORECASE
	  FNR
	  含有当前数据文件中已处理过的记录数
	  NF
	  含有数据文件最后一个数据字段的数字值 --> $NF 字段变量
	  NR
	  含有已经处理过的记录总数
	  多文件输入时，FNR的值会在处理每个数据文件时被重置
	                NR的值会继续计数到处理完所有的数据文件
	OFMT

	RLENGTH
	
	RSTART


  自定义变量
    awk -f script n=2 data
	awk -v n=3 -f script data

 处理数组
   关联数组
   定义数组变量
      var[index] = element

   遍历数组变量
    var 存储的是索引值 
	for (var in array)
	  {
	    statements	
	  }

	delete array[index] 删除数组索引

  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
使用模式
    正则表达式
       awk ‘BEGIN{FS=“,”} /11/{print $1}’ data
       匹配操作符
        ～   可以指定匹配操作符，数据字段变量 以及 要匹配的正则表达式
		$1 ~ /^data/  过滤出第一个字段以文本data开头的所有记录
    
	   awk 'BEGIN{FS=","} $2 ~ /^data2/{print $0}' data

       awk -F: '$1 ~ /rich/{print $1,$NF}'  /etc/passwd

	   排除匹配操作符
	   !~ /expreession/
       $1 ~ /expression/
      
    数学表达式
	   x==y
	   x<=y
	   x<y
	   x>=y
	   x>y
      awk -F: 'S1 == 0 { print $1 }' /etc/passwd
结构化命令
  if-then-else 格式的if语句
  if(condition){
	statement1
  }else{
    statement2
  }

  while(condition){
    statements	
  }
  do{
	statements
  }while(condition)

  break
  continue
  
  for( variable assignment; condition; iteration process)

格式化打印
  printf “format string”，var1，var2 ...

  format string 是格式化输出的关键，用文本元素 和 格式化指定符来集体显示指定如何呈现格式化输出
  格式化指定符是一种特殊的代码，会指明显示什么类型的变量 以及 如何显示
  awk程序会将每个格式化指定作为占位符，共命令中的变量使用

     格式指定符 %[modifier]control-letter
	     control-letter
		    c   ASCII
			d 
            i
			e
			f
			g
			o
			s
			x
			x
         width prec -

内建函数
   数学函数
      atan2(x,y)
	  cos(x)
	  exp(x)
	  int(x)
	  log(x)
	  rand()
	  sin(x)
	  sqrt(x)
	  srand(x)

	  rand()
	  x=int(10*rand())

      and(v1,v2) 
	  compl(val)
	  lshift(val,count)
      or(v1,v2)
	  rshift(val,count)
	  xor(v1,v2)

  字符串函数
     asort(s [,d])
	 ...
	 index([s])
	 match(s,r[,a])
     split(s,a,[,r])
	 sprintf(format,variables)
	 sub(r,s[,t])
	 substr(s,i [,n])
	 tolower(s)
	 toupper(s)

   时间函数
     mktime(datespec)
	 strftime(format [,timestamp])
	 systime()

   自定义函数
     function name([variables]){
	    statements	
	    return value  
	 }
   函数放在BEGIN之前
   Demo:
	 awk -f funclib -f script data















    


















```






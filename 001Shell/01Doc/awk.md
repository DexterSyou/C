##

```
  grep : 文本过滤
  sed  : 流编辑器，实现编辑的 
  awk  : 文本报告生成器，实现格式文本输出

***********
  pattern 模式
        正则表达式 ： /root/ 
    	关系表达式 ： <  >  &&  ||  +  *
	    匹配表达式 ： ~  !~
  process 动作
        
  awk 1.从文件，管道或标准输入中读入一行然后把它存放到内存中
      2.执行，对每一行数据，根据awk命令按顺序执行

***********

  awk内置变量：
    $n 当前记录的第n个字段
	$0 这个变量包含执行过程中当前行的文本内容
	FILENAME
	FS  字段分隔符，默认是空格
	NF  表示字段数，执行过程中对应于当前的行号
	NR  表示记录数，在执行过程中对应于当前行号
  -F fs指定分隔符
  echo AAnnBBnnCCnnDD | awk -F "nn" '{print $2}'
  echo AAnn,BBnn,CCnn,DDnn | awk -F , '{print $2}'
  echo AAnnBBnnCCnnDD | awk ‘BEGIN {FS=‘nn’}’ {print $2}


  打印出passwd文件用户UID小于10的用户和它登陆使用的shell
  


```

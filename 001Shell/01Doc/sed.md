## sed

```
sed编辑器称作流编辑器，基于一组规则来编辑数据流
sed编辑器可以根据命令来处理数据流中的数据，这些命令从 [命令行] 或者 [一个命令文本文件中]

sed编辑器执行下列操作：
  一次从输入中读取一行数据
  根据所提供的编辑器命令匹配数据
  按照命令修改流中的数据
  将新的数据输出到STDOUT

sed 命令格式
  sed options script file
  默认情况下，sed编辑器会将指定的命令应用到STDIN输入流上。可以通过管道将数据直接输入到sed编辑器
  echo "This is a test" | sed 's/test/big test/‘
  sed不会修改原来的文本文件
  
 1） 在命令行使用多个编辑器命令
     sed -e 's/brown/green/; s/god/cat/' data1.txt
     命令之间必须用分号隔开
     shell发现封尾‘号就回执行命令
 2） 从文件中读取命令
     sed -f script1.sed file

 3) 数字    表明新文本将替换第几处模式匹配的地方
    g       新文本将会替换所有匹配的文本
    p       表明原先行的内容要打印出来 
    w file  将替换的结果写到文件中

 4）-n 禁止sed编辑器输出
    sed -n ‘s/test/test1/p’ file 只输出被替换命令修改过的行
    sed ‘s/test/test1/w’ file 将被命令修改过的行输出到file中
	sed编辑器的正常输出为STDOUT中
    sed允许其他字符作为分隔符
	 s!/bin/usr/!/bin/usr/bin!  file

sed基础
  sed行寻址
  以数字形式表示行区间
  用文本模式来过滤出行

  sed编辑器会将文本流中的第一行编号为1，接下来一次编号
  sed ‘2s/test/test1/’ file 匹配第2行
  sed ‘2,3s/test/test1/’ file 匹配2到3行
  sed ‘2,$s/test/test1/‘ file 匹配第2到最后一行

  sed编辑器允许指定文本模式来过滤出命令要作用的行
  /pattern/command 匹配符合模式的行

  sed删除行
  sed ‘d’ file  #sed编辑器不会修改源文件
  sed ‘3d’ file

  sed ‘/pattern/d’ file [匹配模式]删除包含指定匹配模式的行
  两个匹配模式要注意，第一个匹配模式开始删除，第二个模式会关闭行删除功能

















   

```

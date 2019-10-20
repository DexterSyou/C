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
  
```

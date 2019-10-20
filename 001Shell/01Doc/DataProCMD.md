##

```
排出数据
sort 命令是对数据进行排序  
sort -n 把数字识别为数值而不是字符串
sort -M 按月排序
sort -o 将排序结果写出到指定的文件中

压缩数据
gzip

归档数据
tar -cvf test.tar test/ test2/
-c 创建一个新的tar归档文件
-v 在处理文件时显示文件
-f 输出结果到文件或设备file

tar -tf test.tar
-t 列出已有tar归档文件的内容

tar -xvf test.tar
-x 从已有的tar归档文件中提取文件
-z 将输出重定向给gzip命令压缩内容
从test.tar中提取内容




```

#!/bin/bash

until [ -z "$1" ]
do
	echo -n "$1 "
    shift
#shift命令会重新分配位置参数, 其实就是把所有的位置参数都向左移动一个位置
done

echo
exit 0
#$0参数是由调用这个脚本的进程所设置的. 按照约定, 这个参数一般就是脚本的名字.

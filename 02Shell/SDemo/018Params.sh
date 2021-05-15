#! /bin/sh

MINPARAMS=10

echo 
echo "The name of this script is \"$0\"."
echo "The name of this script is \"`basename $0`\"."
echo

if [ -n "$1" ]
then
	echo "Parameter #1 is $1"
fi

echo "-------------------------"
echo "All the command-line parameters are: "$*" "
if [ $# -lt "$MINPARAMS" ]
then
	echo
	echo "This script params has $MINPARAMS arguments by defalut"
	echo "The arguments num is $# "
fi


#{} 标记法提供了一种提取从命令行传递到脚本的最后一个位置参数的简单办法
#但是这种方法同时还需要使用 间接引用
# args=$#
# lastarg=${!args}
# lastarg=${!$#}


exit 0


#!/bin/bash
# Processing options & parameters with getopts
#
echo
while getopts :ab:cd opt
do
	echo "Parameter: $opt ,Position: $OPTIND"
	case "$opt" in
	a) echo "Found the -a option , " ;;
	b) echo "Found the -b option , whith value $OPTARG " ;; 
	                                          #OPTARG环境变量会保存选项需要的参数
											  #OPTIND环境变量保存了参数列表中getops正在处理参数的位置
	c) echo "Found the -c option , "  ;;
	d) echo "Found the -d option , "  ;;
	*) echo "Unknown option : $opt" ;;
    esac
done
#
shift $[ $OPTIND - 1 ]
#
echo
count=1
for param in "$@"
do
	echo "Parameter $count: $param"
	count=$[ $count + 1 ]
done


#! /bin/sh

# rfe old_ext new_ext
# 

E_BADARGS=65

case $# in
	0|1)
		echo "Usage: `basename $0` old file suffix new file_suffix"
		exit $E_BADARGS
		;;
esac

for filename in ./../03TesTEN/*.$1
do
    mv $filename ${filename%$1}$2
done

exit 0

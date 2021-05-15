#!/bin/sh

exec 0< ./../03TesTEN/test02

count=1

while read line 
do
	echo "Line #$count: $line"
	count=$[ $count + 1 ]
done



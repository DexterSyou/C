#!/bin/bash

c=0
while read line
do 
	files[$c]=$line
	((c++))
done < ./testfile


for temp in ${files[@]}
do
	echo "outPut:  $temp"
done

arry=()
arry[0]=1
arry[1]=2

for i in ${arry[@]}
do
	echo "$i"
done




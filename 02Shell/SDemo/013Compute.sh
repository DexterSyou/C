#!/bin/sh

#########Demo1
#i=0
#((i++))
#echo $i
#let i++
#echo $i
#expr $i + 1
#echo $i
#echo "awk ..."
#echo $i 1 | awk '{print $1+$2}'

####Type
#echo "Type Is ..."
#type type
#type let
#type expr
#type bc
#type awk

#########Demo2
#let i++
#i=$(expr $i + 1)
#i=$(echo $i+1|bc)
#i=$(echo "$i 1" | awk '{printf $1+$2;}')
#i=0
#while [ $i -lt 10000 ]
#do
#	((i++))
#done
#echo $i

##########
#expr 5 % 2
#let i=5%2 
#echo 5%2 | bc
#echo "5^2" | bc
#((i=5%2))

#进制转换
#echo "obase=10;ibase=8;11" | bc -l
#echo $((8#11))

#ascii
#i=0
#echo '$i=' $i
#echo "$i=" $i
#echo -n '$IFS'
#echo -n "$IFS"
#echo -n "$IFS" | od -c
#echo -n "$IFS" | od -b

#####
# let    无法进行浮点运算
# expr   无法进行浮点运算

echo "scale=3;1/13" | bc
echo "1/131" | bc -l
echo "1 13" | awk '{ printf("%0.3f\n",$1/$2) }'

#############
# 环境变量RANDOM能产生从0 到 32767 的随机数
# awk的rand() 可以产生0 到 1 之间的随机数
# 0 ~ 255
#$RANDOM / 128
#echo "" | awk '{ srand(); printf("%f",rand()*255); }'

#grep -v ^$  去掉空行
#uniq -c 统计相同行的个数
























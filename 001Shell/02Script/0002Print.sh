#!/bin/sh

####
#----------------------------------------------
# Date   :
# Writer :
# Content:
#    "" 
#    ''
#    ;
#-----------------------------------------------

#
test=10
echo 'Hello  ${test}  world'
echo "Hello ${test}   World"

#
printf "%-5s %-10s %-4s\n" No   Name  Mark
printf "%-5s %-10s %-4.2f\n" 1   Sarath  80.3456 
printf "%-5s %-10s %-4.2f\n" 2   James   90.3456 
printf "%-5s %-10s %-4.2f\n" 3   Jeff    100.36 
printf "%5s   %10s    %4.3f\n" right   hello  80.3456 

#echo -e "\e[1;31mThis is red text\e[0m"
#echo -e "\e[1;31mred Background\e[0m"
echo -e "1\t2\t3"

##Summary
#------------------------------------------------
#  %s %c %d %f  格式替换符。
#  %-5s 指明了一个格式为左对齐且宽度为5的字符串
#
#------------------------------------------------

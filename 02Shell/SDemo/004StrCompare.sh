#!/bin/sh

str1=baseball
str2=hockey

if [ $str1 /> $str2 ]
then
	echo "$str1 is greater than $str2"
else
	echo "$str1 is less than $str2"
fi



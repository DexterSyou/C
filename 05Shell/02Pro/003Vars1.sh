#!/bin/bash

echo

# 赋值
a=879
echo "The value of \"a\" is $a."

# 使用'let' 赋值
let a=16+5
echo "The value of \"a\" is now $a."

echo

echo -n "Values of \"a\" in the loop are: "
for a in 7 8 9 11
do
	echo -n "$a "
done

echo
echo

echo -n "Enter \"a\" "
read a
echo "The value of \"a\" is now $a."

echo
exit 0


#!/bin/bash
# assigning a variable value to another variable

a=375
hello=$a

echo hello
echo $hello
echo ${hello}

echo "$hello"
echo "${hello}"
echo

hello="A B  C    D"
echo $hello
echo "$hello" # 引用一个变量将保留其中的空白, 当然, 如果是变量替换就不会保留了.
echo '$hello' #全引用的作用将会导致"$" 被解释为单独的字符

hello=
echo "\$hello (null value) = $hello"

echo; echo
numbers="one two three"
other_numbers="1 2 3"
echo "numbers = $numbers"
echo "other_numbers = $other_numbers"
mixed_bag=2\ ---\ Whatever

echo "$mixed_bag"
echo; echo

echo "uninitialized_variable = $uninitialized_variable" # Uninitialized 变量为null( 就是没有值).
uninitialized_variable= 
echo "uninitialized_variable = $uninitialized_variable" # 还是一个空值.
uninitialized_variable=23 # 赋值.
unset uninitialized_variable # Unset 这个变量.
echo "uninitialized_variable = $uninitialized_variable"

echo

exit 0









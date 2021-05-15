#!/bin/sh
#var=$(echo "options;expression" | bc)

var1=$(echo "scale=4; 3.44 / 5" | bc)
echo The answer is $var1

var2=10.46
var3=43.67
var4=71

var5=$(bc<< EOF
scale=4
a1=($var1 * $var2)
b1=($var3 * $var4)
a1 + b1
EOF
)

echo The final answer for this mess is $var5

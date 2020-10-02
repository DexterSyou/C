#! /bin/sh

echo "###### \${parameter+alt_value} ########"
echo

a=${param1+xyz}
echo "a = $a"

param2=
a=${param2+xyz}
echo "a = $a"

param3=123
a=${param3+xyz}
echo "a = $a"

echo
echo "###### \${parameter:+alt_value} ########"
echo
a=${param4:+xyz}

param5=
a=${param5:+xyz}
echo "a = $a"

param6=123
a=${param6:+xyz}
echo "a = $a"

var01=abcdEFGH28ij
echo "Length of $var01 = ${#var01}"
var02="abcdEFGH 28ij"
echo "Length of $var02 = ${#var02}"

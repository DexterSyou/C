#!/bin/bash

echo
echo "Testing \"0\""
if [ 0 ]
then
  echo "0 is true."
else
  echo "0 id false."
fi

echo
echo "Testing \"1\""
if [ 1 ]
then
  echo "1 is true."
else
  echo "1 is false."
fi

echo
echo "Testing \"-l\""
if [ -1 ]
then
  echo "-1 is true."
else
  echo "-1 is false."
fi

echo 
echo "Testing \"NULL\""
if [ ] # NULL (空状态)
then
  echo "NULL is true."
else
  echo "NULL is false."
fi

echo
echo "Testing \"xyz\""
if [ xyz ]
then
  echo "Random string is true."
else
  echo "Random string is false."
fi

echo
echo "Testing \"\$xyz\""
if [ $xyz ]
then
  echo "Uninitialized variable is true."
else
  echo "Uninitialized variable is false."
fi

echo
xyz=
echo "Testing \"-n \$xyz\""
if [ -n "$xyz" ]
then
  echo "Null variable is true."
else
  echo "Null variable is false."
fi

echo
echo "Testing \"false\""
if [ "false" ]
then
	echo "\"false\" is true."
else
	echo "\"false\" is false."
fi

echo
echo "Testing \"\$false\""
if [ "$false" ]
then
	echo "\"\$false\" is true."
else
	echo "\"\$false\" is false."
fi

echo
exit 0

#----
#if [ condition-true ]
#then
#    command 1
#	command 2
#	...
#else
#	command 3
#	command 4
#	...
#fi
#

#!/bin/bash
# trying to access script parameters inside a function

function addItems {
  echo $[ $1 * $2 ]
}

if [ $# -eq 2 ]
then
	value=$(addItems $1 $2)
	echo "The result is $value"
else
	echo "Usage: FuncParam  a b"
fi


#!/bin/bash

MINPARAMS=2

args=$#
lastarg=${!args}
echo $lastarg
#
echo
echo "The name of this script is \"$0\"."
echo "The name of this script is \"`basename $0`\""

echo
if [ -n "$1" ]
then
	echo "Parameter #1 is $1"
fi
#......
# ${10}

echo "-----------------------------------"
echo "All the command-line parameters are: "$*" "
echo "All the command-line parameters are: "$@" "
echo "All the command-line parameters number: "$#" "

echo
exit 0;


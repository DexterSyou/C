#!/bin/sh

A=B
echo "PID for 1.sh before exec/source/fork: $$"

export A
echo "1.sh: \$A is $A"

case $1 in 
	exec)
		echo "using exec..."
		exec ./016Source2.sh ;;
	source)
		echo "using source..."
		. ./016Source2.sh ;;
	*)
		echo "using fork by default..."
		./016Source2.sh ;;
esac

echo "PID for 1.sh after exec /source/fork:$$"
echo "1.sh: \$A is $A"


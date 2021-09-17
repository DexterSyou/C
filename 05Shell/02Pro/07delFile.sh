#!/bin/bash
# Testing if a file is empty
#
file_name=./log
#
if [ -f $file_name ]
then
	if [ -f $file_name ]
	then
		echo "The $file_name file exists and has data in it."
		echo "Will not remove this file"
    else
		echo "The $file_name file exists, but is empty."
		echo "Deleting empty file..."
		rm $file_name
	fi
else
	echo "File , $file_name, does not exits."
fi

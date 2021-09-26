#!/bin/bash
# using a variable to hold the list

list="Alabama Alaska  : Arizona Arkansas Colorado"
list=$list" Connecticut"
IFS_OLD=$IFS
IFS=:
for state in $list
do
	echo "Have you ever visited $state?"
done
IFS=$IFS_OLD


#! /bin/sh

#-----------------------------------------
#file1=./../03TesTEN/data01
#file2=./../03TesTEN/data02
#
#if cmp ${file1} ${file2} &> /dev/null
#then
# echo "Files a and b are identical."
#else
# echo "Files a and b differ." 
#fi
#-----------------------------------------

word=Linux
letter=inu

if echo "$word" | grep -q "$letter"
then
  echo "Found"
else
  echo "Not Found"
fi

if [ "$true" ]
then
	echo "\$true=$true"
fi

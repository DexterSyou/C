#! /bin/bash

YM = 0
isOK(){
  echo "Hello is OK"
}

isOK

if [ "$?" -ne 0 ]
then
	echo "Must OK"
	exit 1
else
	echo "OK "
	echo "YM=${YMD}"
	exit 0
fi


#!/bin/sh

names=$( ls )
tempname=;

for cname in $names
do
  if [ ${cname:3:1} = '_' ] 
  then
    tempname=${cname/_/} 
	#echo $tempname
    mv ./$cname ./$tempname
  fi

done

#!/bin/bash
# read file and create INSERT statements for SQL

outfile='members.sql'
IFS=','
while read lname fname address city state zip
do
  #echo $lname
  cat >> $outfile << EOF
  INSERT INTO members(lname,fname,address,city,state,zip) VALUES
  ('$lname','$fname','$address','$city','$state','$zip');
EOF
done < $1

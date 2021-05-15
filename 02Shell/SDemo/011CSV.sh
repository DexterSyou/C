#!/bin/sh

outfile='members.sql'
IFS=','

while read x y z
do
cat >> $outfile << EOF
INSERT INTO members (x,y,z) VALUES ('$x','$y','$z');
EOF
done < ${1}


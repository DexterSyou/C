#! /bin/bash

trap 'echo "before execute line: $LINENO"' DEBUG

. ./$1

echo "end"

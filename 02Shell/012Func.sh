#!/bin/sh

#value=1

function func {
  read -p "Enter your value: " value
  echo "The test func"
  echo $[ $value * 2 ]
}

result=$(func)

echo "The result is $result"


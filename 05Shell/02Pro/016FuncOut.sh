#!/bin/bash
# using the echo to return a value

function db1 {
  read -p "Enter a value : " value
  echo $[ $value * 2 ]
}

function db2 {
  read -p "Enter a another value : " value
  return $[ $value * 2 ]
}

result1=$(db1)
result2=$(db2)

echo "The new value is $result1"
echo "The new value is $result2"

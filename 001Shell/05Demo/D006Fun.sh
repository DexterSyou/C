#!/bin/sh

fun(){
 echo "$num"
}

fun_1(){
  echo "$0 , $1,  $2"
  echo "$*"
  echo "$#"
}

fun_2(){
  echo "$1"
}

num=$1
fun
fun_1 23 56
fun_2 $2

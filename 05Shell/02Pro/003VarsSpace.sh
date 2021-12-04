#!/bin/bash

var1="a variable containing five words"
#CMD This is $var1
#"This" "is" "a" "variable" "containing" "five" "words" 用7个参数执行COMMAND命令

var1="a variable containing five words"
#CMD "This is $var1"	
# 用1个参数执行COMMAND命令 "This is a variable containing five words"

variable2="" # Empty

COMMAND $variable2 $variable2 $variable2 # COMMAND将不带参数执行.
COMMAND "$variable2" "$variable2" "$variable2" # COMMAND将以3个空参数来执行.
COMMAND "$variable2 $variable2 $variable2" # COMMAND将以1个参数来执行(2空格)

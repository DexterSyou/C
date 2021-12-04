#!/bin/sh

E_WRONG_ARGS=65
script_parameters="-a -h -m -z" #-a=all,-h=hlep

if [ $# -ne $Number_of_expected_args ]
then
    echo "Usage: `basename $0` $script_parameters"
fi



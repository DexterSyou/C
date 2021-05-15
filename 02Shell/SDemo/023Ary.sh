#! /bin/sh

array=( zero one two three four five )

echo ${array[0]}
echo ${array:0}
echo ${array:1}

echo "-----------------------"
echo ${#array[0]} # 第一个数组元素的长度
echo ${#array}    # 第一个数组元素的长度
echo ${#array[1]}

echo ${#array[*]}
echo ${#array[@]}

echo "-----------------------"
echo ${array[@]:0}
echo ${array[@]:1}
echo ${array[@]:1:2}

echo "--子串删除---------------------"
arrayZ=( zero one two three four five )
echo ${arrayZ[@]#f*r}
echo ${arrayZ[@]##t*e}
echo ${arrayZ[@]%h*e}
echo ${arrayZ[@]%%t*e}

echo "--子串替换---------------------"
echo ${arrayZ[@]/fiv/XYZ}
echo ${arrayZ[@]//iv/YY}
echo ${arrayZ[@]//fi/}
echo ${arrayZ[@]/#fi/XY}
echo ${arrayZ[@]/%ve/ZZ}
echo ${arrayZ[@]/%o/XX}















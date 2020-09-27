#! /bin/sh

echo "Begin: The vars ------------> "

testChar="A B C      D"
echo "The char is:A B C      D" 
echo 'echo $testChar ='$testChar
echo 'echo ${testChar} ='${testChar}
echo 'echo "$testChar" ='"$testChar" 
echo 'echo testChar='testChar
echo "echo '\$testChar' ="'$testChar'




echo "<-------------  End: The vars"

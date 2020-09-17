#! /bin/sh
#-----------------------
#  該当shellはno queto copy句作成する
#             
#  Writer：　SHAO
#  Please Enter :
#     Demo:  sh ./CreateCopy.sh  copyFile  
#
#     copyFileは以下のようなスタイルで保存してください。
#     コメント　項目名 　型　 桁数
#     XXYYZZ    UPDATE   X    8
#
#-------------------------------
#
j=1
i=1
#-------------------------------
# comment エリア
rowhead="000000"

#quetoS="ダブルクォテーションSTART"
#quetoE="ダブルクォテーションEND"
   cmn="かマン"
#------------------------------
#
result=$1.cob
lcopy=$1
#------------------------------

# クリア
#echo /dev/null > ./$result

while read cmnt komokunm gata ketasu   
do
 # 	
 ketasu=`printf "%03d" $ketasu`
 
 #queto Start
 #if [[ $gata == 'X' ]]
 #then
 #   echo "$rowhead*    $quetoS$j"
 #	echo "$rowhead     $lcopy-QUETOSTART$j                PIC   X(001)"
 #fi

	echo "$rowhead*    $cmnt"
	echo "$rowhead     $lcopy-$komokunm                   PIC   $gata($ketasu)"    
 
 # queto End 
 #if [[ $gata == 'X' ]]
 #then
 #	echo "$rowhead*    $quetoE$j"
 #	echo "$rowhead     $lcopy-QUETOEND$j                  PIC   X(001)"
 #	((j++))
 #fi

    #coman 
    echo "$rowhead*    $cmn$i"
    echo "$rowhead     $lcopy-KANMAN$i                    PIC   X(001)"
    ((i++))
 
done <$1  > $result

#sed  '$'d $result > $result
################################################
#

echo "$result -->  作成しました"


################################################

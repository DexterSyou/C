BEGIN{
	  print "UserId\t\t\tShell"
	  print "--------------------------"
	  FS=":"
	}
'$3>10 && $1=="hello"{
	   printf '%-20s%-20s\n' ,$1,$NF 
     }'
END{
	  print "------------------------" 	 
   }

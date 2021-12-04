#include <stdio.h>

int main(void){
  
   
  char s1[] = "abc";
  char s2[] = "acdeb";

  int i=0,j;
  while(s1[i] != '\0'){
    for(j=0;s2[j] != '\0';j++){
	  if(s2[j] == s1[i]){
	    printf( "%c -- %s-- %d \n",s1[i], s2,j);
		continue;
	  }
	}

	i++;
  }

  return 0;
}


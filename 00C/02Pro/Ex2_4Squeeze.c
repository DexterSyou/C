#include <stdio.h>
#include <string.h>

int isIncludeCh(char s2[], int targetC){
    printf("%c \n", targetC);
	int i;
	for(i=0; s2[i] !='\0';i++){
	 
	  if(s2[i] == targetC){ 
		  return 1;
	  }
	}

	return -1;
}

void squeeze(char s1[], char s2[]){
    
  printf("delete %s from %s \n", s2 ,s1 );
  int i,j;
  char temp[50];
  for(i=j=0; s1[i] !='\0'; i++){
	if(isIncludeCh(s2,s1[i]) < 0 ){
 	   temp[j++] = s1[i];
	}else{ 
       printf("delete the char %c \n", s1[i]);
	}  
  }	

  temp[j] = '\0';
  printf("The result %s \n", temp);

}

int main(){
    
  squeeze("abcde1235", "15ab");
  return 0;
}

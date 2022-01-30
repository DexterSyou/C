#include <stdio.h>

int main(void){
  char sch = 'F';
  char ch;
  for(int i=0;i<6;i++){
     for( ch = sch; ch >= (sch-i); ch-- )
        printf("%c",ch);    
	 printf("\n");
  }
  return 0;
}



#include <stdio.h>
#define TRUE 0
#define FALSE 1

int main(){
  printf("%d\n",'\n');
  int cntSpace = FALSE;
  int c;
  while((c=getchar()) != EOF){
	if(c == ' '){
	  cntSpace = TRUE;
	  continue;
	}
    
	if( TRUE == cntSpace){
	  putchar(' ');
      cntSpace = FALSE;
	}
    putchar(c);	
  }
  return 0;
}

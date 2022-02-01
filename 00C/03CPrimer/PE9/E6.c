#include <stdio.h>

int main(void){
  char ch;
  while((ch=getchar())!=EOF){ 
    if(ch >='A' && ch <='Z'){
	   printf("The char : %c, the position is %d.\n",ch,ch-64);
	}else if(ch >='a' && ch <='z'){
	   printf("The char : %c, the position is %d.\n",ch,ch-96);
	}else{
	   printf("It is not a char!!!! -1\n");	
	}
	getchar();
  }
  return 0;
}


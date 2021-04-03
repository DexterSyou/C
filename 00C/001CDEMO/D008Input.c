#include <stdio.h>

int main(void){
  
  char ch;
                      //EOF
  while((ch=getchar())!='#')
	  putchar(ch);

  return 0;
}

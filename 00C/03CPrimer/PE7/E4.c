#include <stdio.h>
#define END_CHAR '#'
int main(void){
  
  char ch;
  while((ch=getchar())!=END_CHAR){
    if(ch=='.'){
	  putchar('!');
	}else if(ch=='!'){
	  putchar('!');
	  putchar('!');
	}else{
	  putchar(ch);
	}
  }

  putchar('\n');
  return 0;
}

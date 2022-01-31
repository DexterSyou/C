#include <stdio.h>
#include <stdbool.h>

int main(void){
  char ch;
  int eicnt = 0;
  bool flag = false;
  while((ch=getchar())!='#'){
    if(ch == 'e'){
       flag = true;
	}
	if(flag && ch=='i'){
	  eicnt++;
	  flag = false;
	}
  }
  printf("The characters has %d ei.\n",eicnt);
  return 0;
}

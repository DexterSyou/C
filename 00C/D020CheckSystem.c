#include <stdio.h>

int main(void){
  
    union check{
	  int i;
	  char ch;
	}c;

	c.i = 1;
	printf("The systerm is %d ",(c.ch == 1));
}

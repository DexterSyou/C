#include <stdio.h>
//
//
void testfun(void);
//
static unsigned int count;
//
int main(void){

 for(int i=0;i<5;i++)
	 testfun();

 printf("Called fun %d \n",count);
}

void testfun(void){
  count++;
}

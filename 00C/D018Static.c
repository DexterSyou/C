#include <stdio.h>
int add(int i,int j);
static int s_i;	
int main(void){
 // static int s_i;
 printf("Sum : %d\n",add(1,1));
 return 0;
}

int add(int i, int j){
 printf("Test static is %d \n",s_i);
 return i+j;
}

#include <stdio.h>

int main (void){

  int a[5] = {1,2,3,4,5};
  int *ptr1 = (int *)(&a+1);
  printf("%p\n",&a);
  printf("%p\n",(a+1));
  printf("%p\n", ptr1);
  printf("%x\n", ptr1[-1]);
  return 0;
}

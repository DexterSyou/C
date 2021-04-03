#include <stdio.h>

int main(void){
  
  int a=10;
  int *ptr=&a;
  printf("a=%d", *ptr);
  return 0;
}

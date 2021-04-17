#include <stdio.h>

int main(void){
  
  int i = 10;
  int *p = &i;

  *p = NULL;

  printf("%d \n", i);
  
}

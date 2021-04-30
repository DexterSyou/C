#include <stdio.h>

int main(void){

  int *p = NULL;

  free(p);
  printf("----1 \n");
  free(p);
  printf("----2 \n");

  return 0;
}

#include <stdio.h>

extern double j;

int main(void){

  j=10;
  printf("%f", j);
  return 0;
}

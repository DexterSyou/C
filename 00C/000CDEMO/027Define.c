#include <stdio.h>
#define X 3
#define Y X*2
#undef X
#define X 2

int main(void){

  int z = Y;
  printf("%d \n" , z);
  return 0;
}

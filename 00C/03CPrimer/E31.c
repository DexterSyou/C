#include <stdio.h>
#include <limits.h>

int main(void){
  
  int num = INT_MAX;
  printf("%d \n",num+1);
  float toobig=3.4E38F * 10000000.0F;
  printf("%e \n",toobig);
  float toosmall=0.0001 / 3.4E50F;
  printf("%e \n",toosmall);

  return 0;
}

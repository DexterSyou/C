#include <stdio.h>

int main(){
  long nc = 0L;
  while(getchar() != EOF){
    nc++;
  }

  printf("%ld\n", nc);
  return 0;
}

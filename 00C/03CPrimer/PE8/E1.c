#include <stdio.h>

int main(void){
  char ch;
  int  count=0;
  while((ch=getchar())!=EOF){
    count++;
  }

  printf("The file has %d characters \n", count);
  return 0;
}

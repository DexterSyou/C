#include <stdio.h>

int main(void){
  
  char *p = "hello world!";
  char c = ++*p;
  printf("%c \n", c);
  printf("String: %s \n", p);

  int i = 0;
  int j = ++i;
  printf("%d \n", j);
  
  //char c3 = 'h';
  //c3++;
  //char c0 = ++*p; 
  return 0;
}

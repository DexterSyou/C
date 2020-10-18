#include <stdio.h>

int main(void){
  char line[20];
  while(fgets(line,20,stdin) != NULL && line[0] != '\n'){
    puts(line);
  }
  return 0;
}

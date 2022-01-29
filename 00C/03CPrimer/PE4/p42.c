#include <stdio.h>
#define PRAISE "What a super marvelous name!"//编译器负责插入空字符串

int main(void){
  char name[40];
  printf("What 's your name?\n");
  scanf("%s",name);// scanf读取输入时会把空字符串插入name数组中
  printf("Hello %s. %s\n",name,PRAISE);
  return 0;
}

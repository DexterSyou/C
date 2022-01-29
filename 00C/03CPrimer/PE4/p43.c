#include <stdio.h>
#include <string.h>

#define PRAISE "What a super marvelous name!"//编译器负责插入空字符串

int main(void){
  char name[40];
  printf("What 's your name?\n");
  scanf("%s",name);// scanf读取输入时会把空字符串插入name数组中
  printf("Hello %s. %s\n",name,PRAISE);
 
  printf("Your name of %lu letters occupies %lu memory cells.\n",strlen(name),sizeof name); 
  printf("The phrase of praise has  %lu  letters ", strlen(PRAISE));
  printf("and occupies  %lu  memory cells.\n",sizeof PRAISE);
  /*  strlen 字符为单位，sizeof 字节为单位 
   *
   */
  return 0;
}

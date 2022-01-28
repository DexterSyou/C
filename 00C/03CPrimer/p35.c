#include <stdio.h>

int main(void){
 /* 
  * char 是整形类型（存储的是整数）
  * ASCII 0～127 7bit
  * C把一个字节byte定义为char类型使用的位bit数
  *
  * 编译器把遇到的字符转换为相应的编码
  * C将字符常量视为int类型而非char类型
  * char g=‘B’。‘B’作为66存储在一个int类型（32bit）单元中，赋值后grade则把66存储在一个char类型（8bit）中
  *
  * 转义字符 
  *
  */

  char ch;
  printf("Please enter a character.\n");
  scanf("%c",&ch);
  printf("The code for %c is %d.\n",ch,ch);
  return 0;
}

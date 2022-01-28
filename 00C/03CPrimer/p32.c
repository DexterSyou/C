#include <stdio.h>

int main(void){
  int ten = 10;
  int two = 2;
  printf("Doing it right: ");
  printf("%d minus %d is %d\n",ten,2,ten-two);
  printf("Doing it wrong: ");
  printf("%d minus %d is %d\n",ten);
  return 0;
}

/* 存储单位
 *   bit  位       0 or 1
 *   byte 字节     8bit  2^8   0~255
 *   word 字       自然的存储单位（计算机设计的位）
 *   
 * 整数     integer  以二进制存储 
 * 浮点数            小数部分 与 指数部分
 *
 * int ： 计算机存储在计算机的一个字中
 *
 */

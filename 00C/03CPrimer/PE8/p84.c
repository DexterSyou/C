#include <stdio.h>
int main(void){
  
  int guess = 1;
  printf("Pick an integer from 1 to 100. I will try to guess ");
  printf("it. \nRepond with a y if my guess is right and with");
  printf("\nan n if it is wrong.\n");
  printf("Uh...is your number %d?\n",guess);
  while((getchar()!='y'))
	  printf("Well,then,is it %d?\n",++guess);

  printf("I knew I could do it!\n");
  return 0;
}

/*
 * c 的输入为一个字节流。
 * scanf根据说明符，将 输入的字符 进行转换
 * 如：42
 *   %c  读取4并将其存在char类型变量
 *   %s  读取42两个字符，并将它们存储在一个字符串
 *   %d  读取42两个字符，会计算与其相应的整数值4*10+2，将该整数的二进制表示保存在int变量中
 *   %f  读取42两个字符，以内部浮点表示法表示该值，并将结果保存在一个float变量
 *
 * /

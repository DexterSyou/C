#include <stdio.h>
#include <ctype.h>

#define SPACE ' '

int main(void){
  
  char ch;
  //p72.c
  //ch = getchar();
  //while(ch != '\n'){
  //}
  //
  while((ch=getchar())!='\n'){
	 //  
	 if(isalpha(ch)) {
	   putchar(ch+1);
	 }else{
	   putchar(ch);
	 }
	 //ch = getchar();
  }
  putchar(ch);
  return 0;
}

/* 处理字符的函数：
 * getchar() 函数没有参数，它返回来自输入设备的下一个字符
 * 
 *
 *
 */

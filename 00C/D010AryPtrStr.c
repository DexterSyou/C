#include <stdio.h>

int main(void){

  char heart[] = "I love Tillie";
  char *head = "I love Tillie";

  for(int i=0;i<6;i++)
	  putchar(heart[i]);
  putchar('\n');

  for(int i=0;i<6;i++)
	  putchar(head[i]);
  putchar('\n');

// 字符串存储在静态分配去，
// 两者都可以使用指针加法 heart+i，head+i
// 但是只有指针可以进行增量运算 head++
// 数组名是常量，指针是变量
// 指针是存储字符串首个字符的地址，
// 数组是存储的静态区中字符串的一份copy 
 
//  char * p1 = "Klingon";
//  const char * p1 = "Klingon";
//  p1[0] = 'F';
//  printf("Klingon");
//  printf(":Beware the %ss!\n","Klingon");
  return 0;
}

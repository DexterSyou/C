#include <stdio.h>
#define DEF "I am a #defined string."

int main(void){
 
  char str1[80] = "An array was initialized to me.";
  const char * str2 = "A pointer was initialized to me.";

  puts("I'm an argument to puts().");
  puts(DEF);
  puts(str1);
  puts(str2);
  puts(&str1[5]);
  puts(str2+4);

  //******puts
  /*     puts 显示字符串的时候自动在其后添加一个换行符
   *     遇到空字符串就会停下来
   */
  char s_a[]="SIDE A";
  char dont[] = {'W','O','W','!'};
  char s_b[]="SIDE B";
  puts(dont);
  
  //******fputs
  /* 第二参数来说明要写的文件，stdout作为标准输出流 
   * fputs并不为输出自动添加换行符 
   */

  //******printf
  /* 格式化的输出。
   *
   *
   *
   *
   */
  return 0;
}





















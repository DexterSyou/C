#include <stdio.h>
#define PAGES 336
#define WORDS 65618

int main(void){
  
  short num  = PAGES;
  short mnum = -PAGES;

  printf("num as short and unsigned short : %hd %hu\n",num,num);
  printf("-num as short and unsigned short : %hd %hu\n",mnum,mnum);
  printf("num as int and char : %d %c \n",num,num);
  printf("WORDS as int ,short, and char: %d %hd %c\n",WORDS,WORDS,WORDS);
  return 0;

  /*
   *  short 2byte 16bit 
   *  0~65535
   *  0~32767  32768~65535
   *
   *  char 0~255 %c打印short中的一个字节（%256） 
   *
   *
   */

}

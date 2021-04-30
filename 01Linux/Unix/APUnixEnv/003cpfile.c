#include "./ApueHeader/dsapue.h"

int main(void){

  int c;
  while((c = getc(stdin)) != EOF){
    if(putc(c,stdout) == EOF){
	  err_sys("output error");
	}
  }

  if(ferror(stdin))
	  err_sys("input error");

  exit(0);
}
/* 
 * getc 一次读一个字符
 * putc 将此字符写到标准输出 
 * getc 返回产量EOF
 *
 */

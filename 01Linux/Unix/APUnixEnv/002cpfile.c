#include "./ApueHeader/dsapue.h"

#define BUFFSIZE 4096

int main(void){
  int n;
  char buf[BUFFSIZE];
 
  while((n=read(STDIN_FILENO,buf,BUFFSIZE)) > 0){
    if(write(STDOUT_FILENO,buf,n)!=n){
	  err_sys("write erro");
	}
  }

  if(n<0){
    err_sys("read error");
  }

  exit(0);
}

/*
 * read 函数返回读的字节数，此值用作要写的字节数
 *      当到达文件尾段时，read返回0，程序停止执行，如果发生一个错误，read返回-1
 *
 */

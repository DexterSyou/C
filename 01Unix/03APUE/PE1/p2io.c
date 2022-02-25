#include "./../apue.h"
#define BUFFSIZE 4096
int main(void){

   int n;
   char buf[BUFFSIZE];
   while((n=read(STDIN_FILENO,buf,BUFFSIZE))>0){
      if(write(STDOUT_FILENO,buf,n)!=n)
		  err_sys("write error");
   }

   if(n<0)
	   err_sys("read error");
   exit(0);
}

/*
 * 内核用它标识一个特定进程正在访问的文件
 * 当内核打开一个已有文件或创建一个新文件时，它返回一个文件描述符
 * 在读写文件时，就可以使用它
 *
 * 标准文件都链接向终端
 * stdin stdout stderr
 *  
 */

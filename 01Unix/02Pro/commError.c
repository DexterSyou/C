#include "commApue.h"
#include <errno.h>
#include <stdarg.h>

static void err_doit(int,int,const char *,va_list);

void err_dump(const char *fmt, ...){
  va_list ap;               //  类型用于声明一个变量，该变量将依次引用各参数。
  va_start(ap,fmt);         //  宏va_start将 ap初始化为指向第一个无名参数的指针。
  // va_arg(ap, vartype)     变量ap和变量类型type
  err_doit(1,errno,fmt,ap); //  
  va_end(ap);               //  va_end，以完成一些必要的清理工作
  abort();                  //  异常终止
  exit(1);     
}

/* 
 *  Print a message and return to caller.
 *  Caller specifies "errnoflag".
 */
static void err_doit(int errnoflag, int error, const char *fmt, va_list ap){

  char buf[MAXLINE];
  vsnprintf(buf,MAXLINE,fmt,ap);
  if(errnoflag){
    snprintf(buf+strlen(buf),MAXLINE-strlen(buf),":%s",strerror(error));
  }
  
  strcat(buf,"\n");
  fflush(stdout);     // 清除一个流
  fputs(buf,stderr);  // int fputs(char *string, FILE *stream)
  fflush(NULL);       // flushes all stdio output stream 

}

#include "./ApueHeader/dsapue.h"
#include <errno.h>
#include <stdarg.h>

static void err_doit(int,int,const char *, va_list);

void err_ret(const char *fmt, ...){
   va_list ap;
   va_start(ap,fmt);
   err_doit(1,errno,fmt,ap);
   va_end(ap);
}

void err_quit(const char * fmt, ... ){
  va_list ap; 
  va_start(ap,fmt); 
  err_doit(0,0,fmt,ap);
  va_end(ap);
  exit(1);
}

void err_sys(const char *fmt, ...){
  
	va_list ap;
	va_start(ap,fmt);
	err_doit(1,errno,fmt,ap);
	va_end(ap);
	exit(1);

}

//20210501
void err_dump(const char *fmt, ...){
  va_list ap;
  va_start(ap, fmt);
  err_doit(1,errno,fmt,ap);
  va_end(ap);
  abort();
  exit(1);
}


static void err_doit(int errnoflag, int error, const char *fmt, va_list ap){

  char buf[MAXLINE];
  vsnprintf(buf,MAXLINE,fmt,ap);
  if(errnoflag){
    snprintf(buf+strlen(buf),MAXLINE-strlen(buf),":%s",strerror(error));
  }

  strcat(buf,"\n");
  fflush(stdout); 
  fputs(buf,stderr);
  fflush(NULL);

}

/**
*********1*********2**********3*********4*********5*********6*********7**********8*********9*********0
    va_list 
       用于声明一个变量，该变量将依次引用各参数
       ap -->参数指针  
    va_start 
       将ap初始化为指向第一个无名参数的指针
        参数表必须包含一个有名参数，将最后一个有名参数作为起点
     va_arg
        每次调用va_arg，该函数都将返回一个参数，并将ap指向下一个参数
        va_arg 使用 一个类型名来决定返回的对象类型、指针移动的步长
    va_end
       清理工作


    vsnprintf(char *str, size_t size, const char * format, va_list ap)
	将可变参数格式化输出到一个数组
    snprintf(char *str, size_t size, const char *format, ...)
	将可变参数，按照format格式化成字符串，并将字符串复制到str中，size要写入的字符串
	的最大数目，超过size会被截断
	char *strerror(int errnum) 
	函数返回一个指针错误字符串描述错误编号
    int fflush(FILE *stream)
	刷新流stream的输出缓冲区

*********1*********2**********3*********4*********5*********6*********7**********8*********9*********0
**/


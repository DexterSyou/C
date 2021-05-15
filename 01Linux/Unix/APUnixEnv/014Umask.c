#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <fcntl.h>

#define RWRWRW (S_IRUSR |S_IWUSR|S_IRGRP|S_IWGRP|S_IROTH|S_IWOTH)
int main(void){
  
  umask(0);
  if(creat("file014foo",RWRWRW) < 0){
    printf("creat error for file .... \n");
  }
  umask(S_IRGRP | S_IWGRP | S_IROTH | S_IWOTH);
  if(creat("file014bar",RWRWRW) < 0){
    printf("create error for file ... \n");
  }
  exit(0);
}
/*
 * mode_t umask(mode_t cmask)
 * 为进程设置文件模式创建屏蔽字，并返回以前的文件模式创建屏蔽字值
 * 对于任何在文件模式创建屏蔽字中为1的位，在文件mode中相应的位一定被关闭
 * 更改进程的文件模式创建屏蔽字并不影响父进程的（shell）的屏蔽字 
 *
 *  0400 r
 *  0200 w
 *  0100 x
 *  0040
 *  0020
 *  0010
 *  0004
 *  0002
 *  0001
 *
 *  umask(0) 即 ~0 & mode
 *              0777 & mode 
 *              
 *
 *      
 *       
 *
 *
 *
 * create 成功返回只写打开文件描述符，出错返回-1
 * close  成功返回0，出错返回-1
 * lseek  成功返回新的文件偏移量，出错返回-1
 * open   成功返回文件描述符，出错返回-1
 *
 * /

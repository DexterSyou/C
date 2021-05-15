#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main(void){
  
  if(open("tempfile", O_RDWR) < 0){
    printf("Open error ... \n");
  }	
  if(unlink("tempfile") < 0){
    printf("Unlink error \n"); 
  }
  printf("file unlinked \n");
  sleep(15);
  printf("done \n");
  exit(0);
}

/*
 *  int link(const char *existingpath, const char *newpath)
 *  int unlink(const char *pathname)
 *   只有当链接计数到达0时，该文件的内容才可以被删除
 *   只要有进程打开了该文件，其内容也不能删除
 *
 *   进程数 0， 链接数 0 -- 删除该文件
 *
 *   int remove（const char *pathname）
 *   
 */

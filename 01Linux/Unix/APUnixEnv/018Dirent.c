#include "./ApueHeader/dsapue.h"
#include <dirent.h>
#include <limits.h>

/* 
 *  typedef 基本类型      定义名
 *  typedef 指针对象      定义名
 *  typedef 用户对象类型  定义名
 *  typedef 返回值类型    新类型名（参数列表）
 *
 *
 */
typedef int Myfunc(const char *, const struct stat *, int);
static Myfunc myfunc;
static int myftw(char * , Myfunc *);  // Myfunc 函数指针
static int dopath(Myfunc *);

static long nreg, ndir, nblk,nchr,nfifo,nslink,nsock,ntot;

int main(int argc, char *argv[]){
  int ret;

  if(argc != 2){
    printf("Usage : ftw <starting-pathname>");
  }
  ret = myftw(argv[1],myfunc);

}

static int myftw(char *pathname, Myfunc *func){
   

}
















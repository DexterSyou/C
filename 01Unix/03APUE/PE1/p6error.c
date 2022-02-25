#include "./../apue.h"
#include <errno.h> //定义了errno

int main(int argc, char *argv[]){
  fprintf(stderr,"EACCES: %s\n",strerror(EACCES));
  // char *strerror(int errnum) 映射为一个出错信息字符串
  errno = ENOENT;
  perror(argv[0]); 
  //void perror(const char *msg) msg指向字符串，然后：一个空格，
  //接着是对应于errno值的出错，一个换行
  exit(0);
}

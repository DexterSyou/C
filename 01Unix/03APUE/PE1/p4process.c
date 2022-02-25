#include "./../apue.h"

int main(void){
  //程序的执行实例 ： 进程process，task
  //每个进程都有一个唯一的数字标示符，process ID 
  printf("hello world from process ID %d\n",getpid());
  exit(0);
}

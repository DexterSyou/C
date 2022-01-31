#include <stdio.h>
void up_and_down(int);

int main(void){
  up_and_down(1);  
  return 0;
}

void up_and_down(int n){
  printf("Level %d: n location %p\n",n ,&n);
  if(n<4)
	  up_and_down(n+1);
  printf("LEVEL %d: n location %p\n",n ,&n);
}
/*
 * 递归调用会使程序从头 执行相应函数的指令集。
 *
 *
 *
 */

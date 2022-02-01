#include <stdio.h>
void interchange(int *u,int *v);
int main(void){
 
  int x=5, y=10; 	
  printf("Originally x=%d and y=%d.\n",x,y);
  interchange(&x,&y);
  ptintf("Now x=%d and y=%d.\n",x,y);
  return 0;
}

void interchange(int *u,int *v){
	/*  char a='a'; 
	 *  char *pc=&a;
	 *  pc的值                 ： 指向的char类型的地址
	 *  pc所指向的值，即（*pc）： char类型的值
	 *  pc的类型               ： 指向char的指针(指针为一种数据类型)
	 *
	 *  &barn 表示变量barn的地址
	 *  barn  表示存储的值
	 *  pb=&barn1
	 *  pb    表示存储在地址&barn中的数值
	 */
   int temp;
   temp = *u;
   *u   = *v;
   *v   = temp;
}

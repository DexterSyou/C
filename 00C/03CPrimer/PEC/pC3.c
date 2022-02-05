#include <stdio.h>
void trystat(void);

int main(void){
  //静态变量 static
  //变量的位置固定不动，这些变量具有代码块作用域，空链接，静态存储时期
  //只在编译的时候被初始化，如果不显示的初始化，将被初始化为0
  for(int count=1;count<=3;count++){
     printf("Here comes iteration %d:\n",count);
     trystat();
  }
  return 0;
}
void trystat(void){
   int fade = 1;
   static int stay = 1;
   /* 静态变量和外部变量在程序调入内存时就已经就位
	* 放在函数中，是为了高速编译器只有该函数trystat才可以看到变量
	* 不是在运行时执行的语句
	* 函数形式参数不可static
	*/
   printf("fade = %d and stay = %d\n", fade++, stay++);
}
/*
 *  自动变量  ：不会自动初始化
 *              未初始化是 会被之前占用分配给它的空间的任意值
 *
 *  寄存器变量： 存储在CPU寄存器中，无法获得寄存器变量的地址
 *               都有代码块作用域，空链接，自动存储时期
 *
 *               register int quick；为一个请求
 *
 */

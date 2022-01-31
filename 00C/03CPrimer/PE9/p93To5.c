#include <stdio.h>

int imin(int, int);
int main(void){
  
  int evil1, evil2;
  printf("Enter a pair of integers(q to quit): \n");
  while(scanf("%d %d",&evil1,&evil2)==2){
     printf("The lesser of %d and %d is %d.\n",evil1,evil2,imin(evil1,evil2));
	 printf("Enter a pair of integers(q to quit):\n");
  }
  printf("Bye.\n");
  return 0;
  // 返回值
  // 终止函数执行
}

int imin(int n, int m){
  int min;
  if(n<m)
    min=n;
  else
	min=m;   
  return min;
}

/*
 *  函数类型
 *  C函数默认的返回类型为int，C99不支持 函数返回的int类型默认设置  
 *  无返回值的函数，应该声明void类型
 *
 *  函数声明：
 *      只是将函数的形式高速 编译器。
 *  函数定义
 *      函数的实际实现代码。
 *  
 *  ANSI C的函数原型
 *  PC 或 VAX时
 *  调用函数首先把参数放在一个称为 堆栈stack的临时存储区域里
 *  然后被调用函数从堆栈中读取这些参数
 *
 *  p94.c 旧时的声明，定义
 *  int imax();
 *
 *  int imax(n,m)
 *  int n,m;
 *  {
 *     ...
 *  }
 *
 *  imax(3.0,5.0) 参数传递float类型数据会被换成double，double默认的浮点型类型
 *                存double，取int
 **********
 *  ANSI的解决方案
 *  int imax(int, int);
 *  int imax(int a, int b);
 *  
 *  p95.c
 *  int imax(int, int);
 *  imax(3.0,5.0);
 *
 **********
 *  无参数和不确定参数
 *  为了表示一个函数确实不使用参数，使用void
 *  void print_name(void); 
 *  不确定的参数的函数原型
 *  int printf(char *, ...);
 *
 *
 *
 *
 *
 *
 */





















#include <stdio.h>
int main(void){

	int x=30;
	printf("x in outer block: %d\n",x);
	{
	  int x=77;
	  printf("x in inner block: %d\n",x);
	}
	printf("x in outer block: %d\n",x);
	while(x++ < 33){//使用的是外部的x
	   int x = 100;
	   x++;
	   printf("x in while loop: %d\n",x);
	}
	printf("x in outer block: %d\n",x);
	return 0;
}

/*
 * 存储类：不同存储类，有不同的作用域，链接以及存储时期的组合
 *    存储时期    ：变量在内存中保留的时间
 *    作用域与链接：变量在哪里可以使用 
 *  1.作用域
 *    代码块  ： { }之间的范围 
 *               局部变量，形式参数，函数体，复合语句等
 *               C99 把代码块扩大到 for，while，do while，if 语句所控制的代码
 *    函数原型： 适用于函数原型中使用的变量
 *               从变量定义处一直到原型声明的末尾
 *    文件    ： 在所有函数之外定义的变量
 *               从定义处到文件结尾处都是可见的
 *    goto
 *    
 *  2.链接
 *    外部链接（external linkage）：
 *       文件作用域
 *    内部链接（internal linkage）： static
 *       文件作用域
 *    空链接  （no       linkage）：
 *       具有代码库作用域 或 函数原型作用域
 *
 *    int var;          
 *       #文件作用域，外部链接
 *       #可以被其他文件使用
 *    static int var1;  
 *       #文件作用域，内部链接
 *       #该文件私有，不可被其他文件使用
 *    int main(){}
 *
 *  3.存储时期
 *     静态存储时期：
 *         程序执行期间将一直存在。
 *         具有文件作用域的变量 具有 静态存储时期
 *         #static 表示链接，不表示存储时期，即无论是内部链接，外部链接
 *         #所有的文件作用域的变量，都具有静态存储时期
 *     自动存储时期：
 *         代码块作用域，一般具有自动存储时期，代码块结束时
 *         分配的内存将被释放
 *            
 *  
 *   ##pE2.c
 *   int n=10;
 *   for(int n=1;n<3;n++){
 *        #C99
 *   }
 *   # gcc -std=c99 src.c
 *
 *
 *
 */

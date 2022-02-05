#include <stdio.h>
int units = 0; //变量定义，分配内存空间
/* 外部链接静态变量：
 *   文件作用域，外部链接，静态存储时期
 *   外部变量不被显示的初始化，将自动被赋值0
 *    
 * 外部变量名字：
 *   
 *   C90 外部标识符：前6个字符
 *       局部标识符：前31个字符
 *   C99 外部标识符：前31个字符
 *       局部标识符：前63个字符
 */
/*## static int svil = 1;
 *   内部链接静态变量：
 *       静态存储时期，文件作用域，内部链接
 *       只能在同一个文件中使用
 *       #extern int svil 声明使用内部链接静态变量
 */
void critic(void);

int main(void){

	extern int units;//使用extern关键字来声明外部变量，不分配内存空间
	                 //作用只是说明main函数要使用units
					 //告诉编译器指向同一个外部变量
	printf("How many pounds to a firkin of butter?\n");
    scanf("%d",&units);
	while(units != 56)
		critic();

	printf("You must have looked it up!\n");
	return 0;
}

void critic(void){
  printf("No luck, chummy. Try again.\n");
  scanf("%d",&units);
}

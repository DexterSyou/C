#include <stdio.h>
#define  SIZE 4
int main(void){
  
   short    dates[SIZE];
   short   *pti;
   short    index;
   double   bills[SIZE];
   double  *ptf;
   pti   = dates;
   ptf   = bills;
   printf("%23s %10s\n","short","double");
   for(index=0;index < SIZE;index++)
	   printf("pointers + %d: %10p %10p\n",index,pti+index,ptf+index);
   return 0;
}

/*
 * 1. 数组名 同时也是该数组首元素的地址
 *    int ary[SIZE];
 *    ary == &ary[0];
 * 2. 对指针加1的结果，是对该指针增加一个存储单元
 *    对数组，地址会增加到下一个元素的地址
 *
 *    指针的数值    ：所指向的对象的地址。
 *                    地址的内部表示方式 由硬件来决定，对每个内存字节顺序进行编号，地址通常指的是首字节的地址
 *    在指针前运用* ：得到该指针所指向的 对象的数值
 *    指针运算      ：用指针的值来对指向对象的字节进行运算
 *
 *    dates + 2  == &dates[2]
 *    *(dates+2) == dates[2] 
 *
 */

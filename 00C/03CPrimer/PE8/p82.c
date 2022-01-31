#include <stdio.h>

int main(void){

  int ch;
  while((ch=getchar())!=EOF)
	  putchar(ch);
  return 0;
}

/*
 *  非缓冲输入
 *  缓冲输入
 *     完全缓冲 ，缓冲区满时被清空
 *     行缓冲   ，遇到换行字符时被清空 
 *  
 *  ANSI 指定应该对输入进行缓冲
 *  K&R 则选择权留给了编译器
 *
 *  文件
 *  标准I/O包，同两个流stdin，stdout打交道，
 *  c输入函数装备一个内置的文件尾检测器。
 *  文件结尾：
 *        在文件放置一个特殊字符来标志结尾
 *        让操作系统存储文件大小的信息（UNIX，MS-DOS）
 *        c的处理方法（不理会操作系是如何检测文件尾的）：
 *            getchar 函数在到达文件结尾时返回一个特殊值EOF
 *            scanf 函数在到达文件结尾时返回一个特殊值EOF
 *             
 *
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <dirent.h>

int main(int argc, char *argv[]){
  DIR  *dp;
  struct dirent *dirp;

  if(argc != 2)
	  printf("Usage: D11Ls directory_name");
  if((dp = opendir(argv[1])) == NULL)
	  printf("Can't open %s", argv[1]);

  while((dirp=readdir(dp)) != NULL ){
     printf("%s\n", dirp->d_name);
  }

  closedir(dp);
  exit(0); 
}

/*=========================
 *  1.
 *  指针是能够存放一个地址的一组存储单元(通常是两个或 4 个字节)。
 *  地址运算符&只能应用于内存中的对象，即变量与数组元素。
 *  一元运算符*是间接寻址或间接引用运算符。当它作用于指针时，将访问指针所指向的对象。
 *  由于指针也是变量
 * 
 *  2.C语言是以传值的方式将参数值传递给被调用函数。
 *    指针与函数参数，指针参数使得被调用函数能够访问和修改主调函数中对象的值。
 *
 *  3.指针与数组
 *    int a[10];
 *    int *pa;
 *    “指针加 1”就意味着， pa+1 指向 pa 所指向的对象的下一个对象。
 *    pa+i 指向 pa 所指向的对象之后的第 i 个对象
 *
 *    根据定义，数组类型的变量或表达式的值是 该数组第0个元素的地址
 *    pa = &a[0];
 *    pa 和 a 具有相同的值。因为数组名所代表的就是该数组最开始的一个元素的地址
 *    pa = a;
 *
 *   当把数组名传递给一个函数时，实际上传递的是该数组第一个元索的地址。
 *   在函数定义中，形式参数
 *    char s[]; 和 char *s; 是等价的。
 *    f(&a[2]) f(a+2)
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

#include <stdio.h>
#include <stdlib.h>

int main(void){
  double *ptd;
  int max;
  int number;
  int i = 0;

  puts("What is the maxinum number of type double entries?");
  scanf("%d",&max);
  ptd = (double *) malloc(max * sizeof(double));
  /* atuo extern static register 存储类
   * 自动了决定了作用域，存储时期，预先制定内存管理规则
   * 程序运行时，用malloc分配内存空间
   *        接受所需的内存字节数，返回内存第一个字节的地址。
   *        如果找不到所需的空间，它将返回空指针。  
   *        char代表一个字节： char * malloc
   *        ANSI C          ： void * malloc
   *       
   * ##ptd 作为指向一个double类型值的指针声明，不是指向30个double类型值的数据块的指针
   * ##数组名是它第一个元素的地址，ptd指向一个内存块的第一个元素，可以像数组名一样使用它
   * ##ptd[0] 来访问内存块的第一个元素，ptd[1]第二个元素
   *
   * ## 指针符号中使用数组名，数组符号中使用指针
   * ####创建数组3种方法
   *     声明数组，常量维数，数组名访问数组元素
   *     声明一个变长数组，变量维数，数组名访问访问元素（C99）
   *     声明指针，调用malloc，指针访问数组元素
   */
  if(ptd == NULL){
    puts("Memory allocation failed.Goodbye.");
	exit(EXIT_FAILURE);
  }

  puts("Enter the values(q to quit):");
  while(i<max && scanf("%lf",&ptd[i])==1)//数组名方式调用
	  ++i
  printf("Here are your %d entries:\n",number=i);
  for(i=0;i<number;i++){
    printf("%7.3f",ptd[i]);
    if(i % 7 == 6)
		putchar('\n');
  }

  if(i % 7 !=0)
	  putchar('\n');
  puts("Done.");
  free(ptd);
  return 0; 
}

/*
 *******calloc
 * long *n；
 * n = (long *)calloc(100,sizeof(long));
 *
 * 第一个参数：内存单元的数量
 * 第二个参数：每个单元的字节大小
 * calloc将块中的全部为都置为0（某些系统浮点值0不是用全部位为0来表示的）
 *
 *******
 * int (*p2)[6];
 * p2 = (int(*)[6])malloc(n * 6 * sizeof(int));
 * p2 指向一个包含6个int整数的数组
 * p2[i]指向一个由6个整数构成的元素 
 * 
 *
 ******* ANSI 的类型限定词
 * 变量
 *    类型       ：
 *    存储类     ：
 *    类型限定符 ： 不变const，易变volatile（C90）
 *    restrict   ：（C99）
 *（C99）一个声明中可以不止一次使用同一限定词，多余被忽略掉
 * 
 *******const 
 *  只读变量
 *  const float * pf;   指向的值不可改变
 *  float * const pt;   指针本身不可改变，指向同一个地址
 *  float const * pfc;
 *
 *  函数原型参量声明const int array[] 与const int *array相同
 *
 *  全剧数据const
 *
 *******volatile
 * 告诉编译器该变量除了可被程序改变以外还可被其他代理改变
 * 用于硬件地址与其他并行运行的程序共享的数据
 * 
 *******restrict
 *  用于指针，并表明指针是访问一个数据对象的唯一且初始的方式
 *  形式参量使用restrict，表明没有其他标识符修改指针指向的数据
 *  
 *  ##void *memcpy(void *restrict s1,const void * restrict s2, size_t n);
 *  ##s1与s2指向两个内存空间，不能重叠
 *
 *
 *
 *******
 *  存储时期： 静态，自动，分配
 *  作用域  ： 
 *  链接    ： 内部，外部，空
 *
 *  自动                自动存储，代码块作用域，空链接
 *  寄存器register      自动存储，代码块作用域，空链接，无法获得其地址
 *  静态空链接          静态存储，代码块作用域，空链接，编译时初始化一次
 *  静态外部            静态存储，文件作用域，外部链接，编译时初始化一次
 *  静态内部            静态存储，文件作用域，内部链接，编译时初始化一次  
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









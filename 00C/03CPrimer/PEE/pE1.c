#include <stdio.h>
#define MAXTITL 41
#define MAXAUTL 31
struct book {
   char  title[MAXTITL];
   char  author[MAXAUTL];
   float value;
};
/*
 *  结构声明：struct
 *    并没有创建一个实际的数据对象，而是描述了组成这类对象的元素
 *    成员可以为任意类型
 *    
 *  结构声明（设计模板）：告诉编译器如何表示数据,但是计算机没有分配内存空间
 *                         
 *  struct book { }library;
 *  struct {} library;
 *
 *                         
 *  结构声明 ： 创建一种新类型   
 */
int main(void){
 
	struct book library;
    /*
	 * 创建结构变量：
	 *     编译器创建一个library变量，使用book模板为该变量分配空间
	 *     library 具有 
	 *        一个MAXTITL个元素char数组
	 *        一个MAXAUTL个元素char数组
	 *        一个float变量
	 *
	 *
	 * 初始化结构：
	 *    正常初始化
	 *    初始化静态时期时，只能使用常量值
	 *    C99 指定初始化
	 */
	printf("Please enter the book title.\n");
	gets(library.title);
	// 访问结构变量
	printf("Now enter the author.\n");
	gets(library.author);
	printf("Now enter the value.\n");
	scanf("%f",&library.value); // .的运算级 比 & 优先
	printf("%s by %s : $%.2f\n",library.title, library.author,library.value);
	printf("%s: \"%s\"($%.2f)\n",library.author,library.title,library.value);
    printf("Done.\n");
	return 0;
}

#include <stdio.h>
#define  MAX  81

int main(void){
  
  char name[MAX];	
  printf("Hi, what 's your name?\n");
  gets(name);
  /*********gets
   * gets 从系统的标准输入设备获得一个字符串
   * 直到遇到一个换行符\n，回车键
   * 读取换行符之前的所有字符，在这些字符后添加一个空字符\0
   * 然后把这个字符串交给程序，并且将读取换行符丢弃。
   */
  // char *ptr;
  // ptr = gets(name);
  /* gets 返回一个指向char的指针值，
   * char * gets(char *s){ 
   *
   *   return (s);
   * } 
   * gets返回的指针与传递给它的是同一个指针。输入字符串只有一个，放在作为函数
   * 参数传递过来的地址中，如果出错或到文件尾，返回空指针NULL
   */
  printf("Nice name, %s.\n",nmae); 
  
  //*********fgets
  // char * ptr;
  // ptr = fgets(name,MAX,stdin);
  /* gets 多出字符简单地溢出到相邻的内存区。fgets解决了这个问题
   * fgets为文件I/O设计，可以指定最大读入字符数。
   * 第二参数n为最大读入字符数。如果读取n-1个字符或读完一个换行符，则结束输入
   * fgets读取到换行符，会存到字符串里
   * 第三参数说明读入源来自哪个文件。stdin为标准输入流
   */
  

   //*********scanf
   // count=scanf("%5s %10s",name1,name2);
   /*
	* scanf 基于获取单词，而不是字符串，
	* gets  读取所有的字符，直到遇到第一个换行符为止
	* scanf 字符串遇到第一个非空白字符串开始，读到下一个（不包括）空白字符串<空格，指标符，换行符>
	*       %10s，会读入是个字符或直到遇到第一个空白字符 
	* scanf返回成功读取的项目数，或者当遇到文件结束时返回EOF
	*/
  return 0;
}

// 空字符 ’\0‘ char类型字符  可用0表示
// 空指针 为一个空的地址     可用0表示

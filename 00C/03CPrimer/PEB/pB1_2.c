#include <stdio.h>
//字符串：指位于一对双引号的任何字符+编译器自动提供的结束标志\0字符
#define  MSG      "You must have many talents.Tell me some."
/* 字符串常量属于 静态存储
 * 静态存储：
 *    如果在一个函数中使用字符串常量，即使是多少次调用这个函数，
 *    该字符串在程序的整个运行过程中只存储一份
 * 该字符串在程序整个运行过程中只存储一份
 * 整个引号中的内容作为指向该 字符串存储位置的指针
 * 与数组名类似
 */
#define  LIM      5
#define  LINELEN  81

int main(void){

   char  name[LINELEN];
   char  talents[LINELEN];
   int   i;
   const char m1[40] = "Limit yourself to one line's worth.";
   //const char m1[40] = {'L','i','\0'};
   /* 未被使用的元素均被自动初始化为char形式的空字符0--> \0
	* 结束的空字符\0
	*
	* 数组的大小由 编译器决定
	*
	*
	*/
   const char m2[]   = "If you can't think of anything, fake it.";
   const char *m3    = "\nEnough about me - what's your name?";
   /*  数组：在计算机内存中被分配，所有字符 + 结束的空字符'\0'
	*        程序开始运行才为数组分配存储空间，这时候，把被引用的字符串复制到数组中。
	*        编译器把 数组名m3 看作是 数组首元素的地址 &m3[0] ，即m3为一个常量，不可更改 
	*  静态存储区（被引用的字符串）：
	*        被引用的字符串存储在 可执行文件的数据段部分      
	*        当程序被加载到内存中，字符串也被加载到内存中
	*        同时指针变量m3也分配一个内存空间，该指针变量初始时指向字符串的第一个字符
	*        它的值是可以改变的。
	*
	*  数组初始化是从静态存储区把一个字符串复制给数组，指针初始化只是复制字符串的地址。      
    *  
	*  数组，指针都可以指针加法标示数组里的元素
	*  只有指针可以使用增量运算
	*  
	*/
   const char *mytal[LIM] = { "Adding numbers swiftly",
                              "Multiplying accurately","Stashing data",
							  "Following instructions to the letter",
							  "Understanding the C language"};
   /* 字符串数组
	*   mytal[0] 看作表示第一个字符串
	*   *mytal[0]表示第一个字符串的第一个字符，mytal[0][0]
	*    
	*
	*/
   printf("Hi! I'm Clyde the Computer." "I have many talents.\n");
   printf("Let me tell you some of them.\n");
   puts("What were they? Ah, yes, here's a partial list.");
   for(i=0;i<LIM;i++)
	   puts(mytal[i]);

   puts(m3);
   gets(name);
   printf("Well, %s, %s\n",name,MSG);
   gets(talents);
   puts("Let's see if I've got that list:");
   puts(talents);
   printf("Thanks for the information, %s.\n",name);
   return 0;
}

/**********
 * pB2.c
 #include <stdio.h>
 int main(void){ 
     printf("%s, %p, %c \n", "We", "are", *"space farers");	
  // %s 输出字符串
  // %p 产生一个地址，"are"字符串中第一个字符的地址
  // *"space farers" 应该产生所指向的地址中的值，即字符串"space farers"中的第一个字符
     return 0;
 }
**********/

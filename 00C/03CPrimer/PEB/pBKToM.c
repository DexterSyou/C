#include <stdio.h>
#include <string.h>
#define SIZE 40
#define LIM 5

int main(void){

	char qwords[LIM][SIZE];
	char temp[SIZE];
	int  i=0;

	printf("Enter %d words beginning with q: \n", LIM);
	while(i<LIM && gets(temp)){
	   if(temp[0] != 'q'){
	   //strncmp(temp,"q",1) != 0	   
	     printf("%s doesn't begin with q! \n", temp);
	   }else{
	     strcpy(qwords[i],temp);
		 //strncpy(qwords[i],temp,TARGSIZE-1);
		 //qwords[i][TARGSIZE-1] = '\0';
		 //从temp 把n个字符（或空字符之前）复制到target
		 /*
		  * char str1[20];
		  * strcpy(str1, "The C of ..."); 字符串赋给数组
		  * str1 = "So long" 语法错误
		  *
		  * char *str;
		  * strcpy(str, "The C of ...");
		  *    把字符串赋给str地址指定的内存空间，str没有初始化，这个字符串可能
		  *    被复制到任何地方
		  *
		  * 声明一个数组将为数据分配存储空间，声明一个指针只为地址分配存储空间
		  */ 
		 i++;
	   }
	}
    puts("Here are the words accepted: ");
    for(i=0;i<LIM;i++)
		puts(qwords[i]);
    return 0;
}

/*   #define WORDS  "beast" 
 *
 *   char *ps;
 *   char copy[SIZE]="......";
 *   char * orig = WORDS;
 *
 *   ps = strcpy(copy+7,orig);
 *   strcpy 返回的是第一个参数的值，即一个字符的地址
 *   第一个参数不需要指向数组的开始
 *   ps指向copy的第8个元素（copy+7）
 *
 */




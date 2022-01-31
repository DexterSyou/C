#include <stdio.h>
#define NAME    "GIGATHINK, INC."
#define ADDRESS "101 Megabuck Plaza"
#define PLACE   "Megapolis, CA 94904"
#define WIDTH   40

void starbar(void);
int main(void){
    starbar();
	printf("%s\n",NAME); 
	printf("%s\n",ADDRESS);
	printf("%s\n",PLACE);
    starbar();
	// show_n_char(param1,param2);
	//
	//
	return 0;
}
void starbar(void){
   int count;
   for(count=1;count<=WIDTH;count++)
	   putchar('*');
   putchar('\n');
}

/*
 *  ** 旧时
 *  void show_n_char(ch, num)
 *  char ch;
 *  int  num;
 *  
 *  ###
 *  定义带有参数的函数： 形式参量
 *  void show_n_char(char ch, int num)  
 *  
 *  带参数函数原型声明：
 *  void show_n_char(char, int)
 *
 *  调用带有参数的函数：实际参数
 *
 */

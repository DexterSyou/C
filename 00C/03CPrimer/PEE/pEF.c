#include <stdio.h>
#include <string.h>
#include <stdbool.h>

enum spectrum {red,orange,yellow,green,blue,violet};
const char *colors[] = {"red","orange","yellow","green","blue","violet"};

#define LEN 30

int main(void){
  char choice[LEN];
  enum spectrum color;
  bool color_is_found = false;
  while(gets(choice)!=NULL && choice[0]!='\0'){
  
	  for(color=red;color <= violet;color++){
	     if(strcmp(choice,colors[color])==0){
		    color_is_found = true;
			break;
		 }
	  }
      if(color_is_found){
	    switch(color){
		   case red: puts("Roses are red.");break; 
		   case orange: puts("Poppies are orange.");break;
		   case yellow: puts("Sunflowers are yellow.");break;
		   case green: puts("Grass is green.");break;
		   case blue: puts("Bluebells are blue.");break;
		   case violet: puts("Violets are violet.");break;
		}
	  }else{
	    printf("I don't know about the color %s.\n",choice);
	  }
	  color_is_found = false;
      puts("Next color, please (empty line to quit): ");
  }
  puts("Goodbye!");
  return 0;
}

/*
 *****  union 同一个存储空间里存储不同类型数据的数据类型
 *  union hold{
 *    int a;
 *    double b;
 *    char c;
 *  }; 声明模版
 *
 *  union hold fit; 定义联合变量
 *  fit可以含有一个int 或一个double 或一个char
 *
 ***** 枚举类型enum
 *     声明代表整数int常量的符号
 *     
 *     声明模版
 *     定义变量
 *
 *
 ****** typedef
 *  由编译器解释，定义类型
 *  typedef unsinged char BYTE
 *
 *
 *
 *
 *
 *
 *
 *
 */

// ptrItem->code, item.code, (*ptrItem).code

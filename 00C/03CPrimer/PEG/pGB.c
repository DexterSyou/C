#include <stdio.h>
#include "pGA.h"
#include "pGA.h"

#define JUST_CHECKING
#define LIMIT 4

int main(void){
   
   int i;
   int total=0;
   for(i=0;i<LIMIT;i++){
       total+=2*i*i + 1;
#ifdef JUST_CHECKING
       printf("i=%d, running total=%d\n",i,total);
#endif
   }
   printf("Grand total=%d\n",total);

   //pGB.c
   names winner = {"Less","Ismoor"};
   printf("The winner is %s %s.\n",winner.first,winner.last);
   return 0;
}


/*
C预处理的观点
   #undef 取消 一个定义的#define

   条件编译
      根据指令设置条件编译，根据指令，编译时，接受或忽略信息块
     （1）
        #ifdef 
        #else 
        #endif 
     （2）
        #ifndef
        #else
        #endif

        #ifndef _STDIO_H
        #define _STDIO_H
        #endif
     （3）
        #if 后跟常量整数表达式，如果表达式非0，则为真（表达式可以使用C的关系运算符，逻辑运算符）
        #elif
        ...
        #else
        #endif

        #if SYS == 1
           #inlcude "..."
        #elif SYS == 2
           #inlcude "..."
        #else
           #inlcude "..."
        #endif
        
        #ifdef defined(VAX)
    ***defined 是一个预处理器运算符，如果defined的参数已用#define定义过，那么defined返回1，否则返回0    
    ***需要在前面某处#define VAX
    ***预处理器不能识别{} 
*/

#include <stdio.h>
// 预定义标识符
void why_me();

int main(){

   printf("The  file is %s.\n",__FILE__);
   printf("The  date is %s.\n",__DATE__);
   printf("The  time is %s.\n",__TIME__);
   printf("The  version is %ld.\n",__STDC_VERSION__);
   printf("The  is line %d.\n",__LINE__);
   printf("This function is %s.\n",__func__);
   why_me();
}

void why_me(){
   printf("The function is %s.\n",__func__);
   printf("The  is line %d.\n",__LINE__);
}
/*
   #line重置 __FILE__ 和 __LINE__ 宏报告的行号和文件名
   #line 1000               *****当前号重置为1000
   #line 10 "cool.c"        *****行号重置为10，文件名重置为cool.c 
   
   #error指令使预处理器发出一条错误消息，该消息包含指令中的文本（编译过程可能中断）
   #if __STDC_VERSION__ != 199901L
       #error Not C99
   #endif

   #pragma 将编译器指令置于源代码中
   #program c9x on  ***开启对c9x支持
   _Pragma("nonstandardtreatmenttypeB on") 等价#program  nonstandardtreatmenttypeB on


   #define LIMRC(X) _Pragma(STDC CX_LIMITED_RANGE #X)
   ***** 直到预处理完成后编译器才链接字符串
   ***** _Pragma("use_bool",\"true \"false") 字符串析构
   ***** #pragma use_bool "true "false

   #deifne PRAGMA(X)  _Pragma(#X
   #define LIMRG(X)   PRAGMA(STDC CX_LIMITED_RANGE X)

*/

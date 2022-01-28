#include <stdio.h>

int main(void){
  
   unsigned int un = 3000000000;
   short end = 200;
   long big = 65537;
   long long verybig = 12345678908642;
   printf("un=%u and not %d. \n", un,un);
   // 传递参数时short类型自动转换为int类型
   printf("end=%hd and %d.\n",end,end);

   printf("big=%ld and not %hd.\n",big,big);
   printf("verybig=%lld and not %ld.\n",verybig,verybig);
   return 0;
}

/*
 * short 存储空间不大于int     有符号 
 * long  存储空间不小于int     有符号
 * long long 存储空间大于long  有符号
 * unsigned 无符号
 * signed 有符号
 */

#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

void sign_off(void);
int main(void){
  
    atexit(sign_off);
    /*  
       参数：函数指?
            atexit把作?其参数的函数，在?用exit??行的函数列表注册
            最后，?用exit?，按?的?序?行
            atexit注册的函数???不接受任何参数的函数，通常?行内部?理，如???境?量
       
         main?止?会?式的?用exit
    */ 
    int x=1,y=9;
    z=x*x-y*y;
    assert(z>=0); 
    exit(0);
    /*
       exit?行了atexit指定的函数后，将做自身清理工作
       刷新所有?出流，??所有打?的流，??tmpfile?建的??文件
       UNIX 0    成功
            非0  失?
       
    */
}

void sign_off(void){
    puts("SeeSaw Hello World");
}
/*
   UNIX 的C??
   ANSI C基于 UNIX的C?? 

   自???
   文件包含
   ???或?接
   math.h
      sqrt()
      atan2()

   stdlib.h
     exit()
     atexit()
     qsort 
          void qsort(void *base, size_t nmemb, size_t size, int(*compar)(const void *,const void *));
   
   assert.h
     assert
        ?宏接受整数表?式，如果表?式??假，宏assert向?准??流stderr写一条??消息
        并?用abort函数以?止程序

        ??出程序中某个条件??真的??位置，并在?条件?假?用assert?句?止程序             

    
     #define NDEBUG
     #ifndef NDEBUG   
        #include <assert.h>            
     #endif

   string.h
     strcpy
     strncpy

      void *memcpy(void *restrict s1, const void *restrict s2,size_t n); 
           ?制?程?似s2?制到一个?冲区，从?冲区内容在?制到s1
      void *memmove(void *s1, const void *s2,size_t n);
           从s2指向的位置?制n字?数据到s1指向的位置，且均返回s1的?
           memcpy假定?个内存区域之?没用重?（restrict）

          memcpy函数的功能是从源src所指的内存地址的起始位置?始拷?N个字?到目?dst所指的内存地址的起始位置中。
          memmove函数的功能同memcpy基本一致，但是当src区域和dst内存区域重??，memcpy可能会出???，而memmove能正??行拷?
*/

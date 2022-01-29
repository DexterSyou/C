#include <stdio.h>

int main(void){

 float    aboat = 32000.0;
 double   abet  = 2.14e9;
 long double dip = 5.32e-5;

 printf("%f can be written %e \n", aboat,aboat);
 printf("%f can be written %e \n", abet,abet);
 printf("%Lf can be written %Le \n", dip,dip); 

 return 0;
}

/*
 *  默认情况下，浮点常量为double型 64bit
 *  函数参数float自动转换成double（没有原型声明）
 *  float 只精确6，7位有效数字，double是10位
 *  
 *
 * /

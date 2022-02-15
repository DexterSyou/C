#include <stdio.h>
#include <math.h>

#define SQUARE(X) X*X
#define PR(X) printf("The result is %d.\n",x);
#define PSQR(x) printf("The square of "#x" is %d.\n",((x)*(x)))
#define XNAME(n) x##n
#define PRINT_XN(n) printf("x "#n" =%d\n" , x##n)
#define PR5(X,...) printf("Message "#X" :" __VA_ARGS__)
int main(void){
  
    int x = 4;
    int  z;
    printf("x+%d\n",x);
    z = SQUARE(x);
    printf("Evaluating SQUARE(X):");
    PR(z);
    z = SQUARE(2);
    printf("Evaluating SQUARE(2):");
    PR(z);
    printf("Evaluating SQUARE(x+2):");
    PR(SQUARE(x+2));
    printf("Evaluating 100/SQUARE(2):");
    PR(100/SQUARE(2));
    printf("x is %d.\n",x);
    printf("Evaluating SQUARE(++x):");
    PR(SQUARE(++x));
    printf("Aftre incrementing, x is %x.\n",x);
 
    //pG3.c
    int y3=5;
    PSQR(y3);
    //"The square of    "#x"   is %d.\n"
    //"The square of"   "y"   "is %d.\n"
    PSQR(2 + 4);

    //pG.4
    int XNAME(1)=14;
    int XNAME(2)=20;
    PRINT_XN(1);
    PRINT_XN(2);
    
    //pG.5
    double x5=48;
    double y;
    y= sqrt(48);
    PR5(1,"x=%f\n",x5);
    PR5(2,"x=%.2f,y=%.4f\n",x5,y);

    return 0;
}


/*
 预处理  ：宏展开
 编译   ： 实际运算
 系统把宏的主体 当作语言符号token字符串，而不是字符型字符串
 C预处理器中的语言符号是宏定义主体中的（单独的词word），用空白字符把这些词分开
 
 处理空格时：
   char 字符串：空格也是主体的一部分
   token字符串：风格主体语言的符号
*/

/*
# 预处理符号，可以把语言符号转化为字符串
## 预处理符号，可以把两个语言符号组合成单个语言符号
... 与 __VA_ARGS__
*/

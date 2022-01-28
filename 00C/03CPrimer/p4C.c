#include <stdio.h>

int main(void){
  float n1 = 3.0;
  double n2 = 3.0;
  long n3 = 2000000000;
  long n4 = 1234567890;

  printf("%.le %.le %.le %.le\n",n1,n2,n3,n4);
  printf("%ld %ld\n",n3,n4);
  //
  printf("%ld %ld %ld %ld\n",n1,n2,n3,n4);
  /*
   *  参数传递的机制随着实现不同而不同
   *  计算机根据n1，n2，n3，n4类型把他们放到stack
   *  n1 8byte （float->double）
   *  n2 8byte
   *  n3 4byte
   *  n4 4byte
   *
   *  然后printf函数把值从stack中读取出来，根据转换说明符取读取
   *  即%ld 4byte
   *    4个%ld读取了 n1 ，n2的内容
   *  
   */
  
  
  return 0;
}

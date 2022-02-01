#include <stdio.h>
#define MONTHS 12

int main(void){
  // 数组array由一系列类型相同的元素构成
  int days[MONTHS] = {31,28,31,30,31,30,31,31,30,31,30,31};
  //const int days[MONTHS] 只读数组
  int index;

  for(index=0;index<MONTHS;index++){
     printf("Month %d has %2d days.\n",index+1,days[index]);
  }
  return 0;
}

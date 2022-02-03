#include <stdio.h>
#define  MONTHS  12

int main(void){

  int days[MONTHS] = {31,28,31,30,31,30,31,31,30,31,30,31};
  int index;
  //
  // days[n] -->  *(days+n) 寻址到内存中的days，然后移动到n个单元，再取出数值 
  //
  //
  for(index=0;index < MONTHS;index++){
     printf("Month %2d has %d days.\n",index+1,*(days+index));
  }
  return 0;
}



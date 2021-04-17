#include <stdio.h>

static int j = 0;

void testStatic1(){
   static int i = 0;
  i++;
  printf("The i : %d \n" , i);
}

void testStatic2(){
  j++;
  printf("The j : %d \n", j);
}

int main(void){
  // static int i = 0;
   testStatic1();
   testStatic1();
   testStatic1();
   testStatic2();
   testStatic2();
}

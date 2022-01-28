#include <stdio.h>

int main(void){

  int age;
  float assets;
  char pet[30];

  printf("Enter your age ,assets, and favorite pet.\n");
  // scanf 中f指示float ，lf指示double
  scanf("%d %f",&age,&assets);
  //
  // %c
  //%c 
  scanf("%s",pet);
  printf("%d $%.2f %s\n",age,assets,pet);
  return 0;
}

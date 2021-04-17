#include <stdio.h>

int main(void){
  char a[5] = {'A','B','C','D'};
  char (*p3)[3] = &a;
  char (*p4)[3] = a;
  char (*p10)[10] = &a;
  printf("a  = %p \n" ,  a);
  printf("&a = %p \n" , &a);

  for(int i =0;i<5;i++){
    printf("&a[%d]=%p \n",i,&a[i]);
  }
  printf("%c %d   \n" , a[1], a[1]);
  printf("p3 = %p \n" , p3 );
  printf("p3-1=%p \n" , p3-1);
  printf("p3+1=%p \n" , p3+1);
  printf("p4  =%p \n" , p4);
  printf("p4+1=%p \n" , p4+1);
  printf("p4-1=%p \n" , p4-1);
  printf("p10=%p , p10+1=%p\n" , p10, p10+1);
  //printf("%c \n", (p3+1)[0]);
  printf("%s \n", (p3+1)[0]);
  return 0;
}

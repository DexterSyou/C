#include <stdio.h>

void fun(int b[100]){
  printf("The fun sizeof(b)=%lu\n",sizeof(b));
}

int main(void){
  
  int *p = NULL;
  int a[100];
  printf("sizeof(NULL)=%lu\n",sizeof(NULL));
  printf("sizeof(int)=%lu\n",sizeof(int));
  printf("sizeof(p)=%lu\n",sizeof(p));
  printf("sizeof(*p)=%lu\n",sizeof(*p));
  
  printf("sizeof(a[100])=%lu",sizeof(a[100]));
  printf("sizeof(a)=%lu,sizeof(&a)=%lu,sizeof(&a[0])=%lu\n",sizeof(a),sizeof(&a),sizeof(&a[0]));
  
  int b[100];
  fun(b);
  return 0;

}

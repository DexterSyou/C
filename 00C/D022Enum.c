#include <stdio.h>

int main(void){
  enum Kubun{
     ok = 1,
	 b,
	 c,
	 d
  } kb;
  printf("%lu\n",sizeof(kb));
  return 0;
}

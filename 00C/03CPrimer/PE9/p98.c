#include <stdio.h>
void to_binary(unsigned long n);

int main(void){
  unsigned long number;
  printf("Enter an integer(q to quit): \n");
  while(scanf("%lu",&number)==1){
	  printf("Binary equivalent: ");
	  to_binary(number);
	  putchar('\n');
	  printf("Enter an integer(q to quit): \n");
  }
  printf("Done.\n");
  return 0;
}

void to_binary(unsigned long n){
   int r;
   r = n % 2; 
   if(n >=2)
	   to_binary(n/2);
   putchar('0'+r);
   return;
}
/*
 * (1) 9    1   to_binary(4) |putchar (4)
 * (2) 4    0   to_binary(2) |putchar (3)
 * (3) 2    0   to_binary(1) |putchar (2)                    
 * (4) 1    1                |putchar (1)       
 *   
 */











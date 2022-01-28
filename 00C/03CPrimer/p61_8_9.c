#include <stdio.h>

int main(void){

  long num;
  long sum = 0L;
  int  status;

  printf("Please enter an integer to be summed.");
  printf("(q to quit):");
  status = scanf("%ld",&num);
  //
  // p68.c status = 1	
  //	
  // p69.c 
  /*   _Bool   input_is_good 
      input_is_good = scanf("%ld",&num);	
      while(input_is_good){
  */ 	
  while(status == 1){
     sum = sum + num;
	 printf("Please enter next integer (q to quit):");
     status = scanf("%ld",&num);
  }
  printf("Those integers sum to %ld.\n",sum);
  return 0;
}

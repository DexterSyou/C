#include <stdio.h>
#include <limits.h>
#include <float.h>

int main(void){
  printf("Some number limits for this system: \n");
  printf("Biggest int : %d\n",INT_MAX);
  printf("Smallest unsigned long : %ld\n",LONG_MIN);
  printf("One byte=%d bits on this system.\n",CHAR_BIT);
  printf("Largest double: %e\n",DBL_MAX);
  printf("Smallest normal float : %e\n",FLT_MAX);
  printf("float precision =  %d digits \n",FLT_DIG); 
  printf("float epsilon : %e\n", FLT_EPSILON);

  return 0;
}

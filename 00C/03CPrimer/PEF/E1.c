#include <stdio.h>
#include <string.h>
#define BITS_1  '1'
int binaryToint(char *);

int main(void){
    char *pbin = "01001001";
    /* 1*2^0+1*2^3+1*2^6*/
	printf("%s value %d \n", pbin, binaryToint(pbin));
	return 0;
}

int binaryToint(char *pbin){
  int result=0;
  int n=strlen(pbin);
  for(;*pbin!='\0';pbin++,n--){
     if(*pbin == BITS_1){
	 //    printf("%d\n",1<<(n-1));
	    result += 1<<(n-1);
	 }
  } 
  return result;
}

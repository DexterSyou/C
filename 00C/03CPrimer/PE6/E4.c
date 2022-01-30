#include <stdio.h>

int main(void){
  char lch;
  char rch;
  char ech='A';
  for(int row=0;row<5;row++){
      for(int s=0; s< 5-(row+1);s++)
		  printf("*");
      for(lch='A';lch<(ech+row+1);lch++)
           printf("%c",lch);
	  for(rch=lch-2;rch>='A';rch--)
	      printf("%c",rch);
   printf("\n");
 }
  return 0;
}

#include <stdio.h>
#include <string.h>
#define SIZE 100

int main(void){
  
   char str[SIZE];
   printf("Please Enter your String! \n");
   scanf("%s",str);
   int len = strlen(str);
   for(int i=len-1;i>=0;i--){
	     printf("%c",str[i]);
   }
   printf("\n");

   return 0;
}

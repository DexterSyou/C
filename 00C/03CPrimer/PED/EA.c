#include <stdio.h>
#include <stdlib.h>
//
#define FILE_NAME_SIZE 20

int main(void){

   char filename[FILE_NAME_SIZE];	
   long pos = 0;
   int  ch;
   printf("Please enter a filename: ");
   scanf("%s",filename);

   FILE *fp;

   if((fp=fopen(filename,"r"))==NULL){
       printf("Can't open file.\n");
	   exit(2);
   }
   
   printf("Please enter the position number : ");
   while(scanf("%ld",&pos)==1){
     fseek(fp, pos, SEEK_SET);  
     while((ch=fgetc(fp))!='\n'){ 
       putchar(ch);
     }
     putchar('\n'); 
     printf("Please enter the position number : ");
   } 
   fclose(fp);
   return 0;
}

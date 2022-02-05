#include <stdio.h>
#include <string.h>
#include <ctype.h>
int main(int argc, char *argv[]){

   if(argc < 2){
      printf("Usage: ./a.out paramters");
      return -1;
   }
   
   char ch;
   if(strcmp((const char *)argv[1] ,"-p")==0){
     while((ch=getchar())!=EOF)
		 putchar(ch);
   }

   if(strcmp((const char *)argv[1],"-u")==0){
     while((ch=getchar())!=EOF)
		 putchar(toupper(ch));
   }
}

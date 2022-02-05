#include <stdio.h>
#include <string.h>
//
#define SRC_SIZE 81
#define TAR_SIZE 10
//
void delLF(char *str);
char *mystrchr(const char *str, const char c);
int main(void){
  char src[SRC_SIZE];
  char target;
  char *pstr;
  puts("Please enter your SRC strings :");
  fgets(src,SRC_SIZE,stdin);
  delLF(src);
  printf("Please enter target char:\n");
  scanf("%c",&target);
  pstr=mystrchr(src,target);
  printf("Finding %c in %s \n",target,src);
  if(pstr){	  
    puts(pstr);
  }else{
    puts("Find nothing");
  }
  return 0;
}

void delLF(char *str){
	char *find=strchr(str,'\n');
	if(find){
	   *find = '\0';
	}
}

char * mystrchr(const char *str, const char c){
    char *pch;	
   while(*str++){
	   if( *str == c)
          pch = ((char *)str) ;
   }
   return pch;
}

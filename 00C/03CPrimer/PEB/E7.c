#include <stdio.h>
char * string_in(const char * str1, const char *str2);
int main(void){

//  char *p = string_in("hats","at");
//  puts(p);
  puts("The ......");
  char *q=string_in("at","af");
  puts(q);
  return 0;
}

char * string_in(const char * str1, const char *str2){
  unsigned int i =0; 
  char *pstr1=NULL;
  while((*str2!='\0') && (*str1!='\0')){
  //while(*str2!='\0'){ 
     if(*str2 == *str1){
         str2++;
		 str1++;
		 i++;
	  }else{
	     str1++;
	  }
  }

  if(i > 1) //
    pstr1=(char *)(str1-i);
  return pstr1;	  
}

/*
 * string_in
 * find a ch2 of str2 in str1, find nothing str1++  
 * if find str2++
 */

















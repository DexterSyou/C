#include <stdio.h>
#define STRING char *

char *  mystrcat(char *s,const char *t){
  
    char * temp = s;	
	while(*s++) ;
	while((*s++ = *t++));
	return temp;;
}

int main(void){

 char t1[] = "hello";
 char t2[] = "world";
 STRING t = mystrcat(t1,t2);
 printf("%s\n" , t);
 return 0;
}

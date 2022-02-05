#include <stdio.h>
//
char * mystrncpy(const char *s2, char *s1,unsigned int n);

int main(void){
  	char s2[10] = "abcde12345";
	char s1[10];

	mystrncpy(s2,s1,5);
    puts(s1);
    return 0;
}

char * mystrncpy(const char * s2, char * s1, unsigned int n){
    unsigned int i =0; 
	while((i<n) && (s2[i] != '\0')){
	   s1[i] = s2[i];
	   i++;
	}
	s1[i] = '\0';
    
	return s1;
}

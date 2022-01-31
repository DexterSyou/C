#include <stdio.h>

int main(void){

    char ch;
	while((ch=getchar())!='#'){
	
		while(getchar()!='\n')
			continue;
	    printf("%c",ch);
	}
	return 0;
}

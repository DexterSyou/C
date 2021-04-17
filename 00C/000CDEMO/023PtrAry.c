#include <stdio.h>

int main(void){
   
	// int i = 100;
	// printf("%p -- %d \n", &i, i);
    int i = 100; 
	int *ptr = &i;
    printf("%d \n", i);
    printf("%d \n", *(int *)(&i));


    char a[3] = "abc";
	char *p = "abc";
    a[1] = 'w';
//	p[1] = 'y';
	printf("%c \n", a[1]);
	printf("%c \n", p[1]);
//  int *p = (int *)0x12ff7c;
//	*p = 90;
//	printf("%d \n", *p );
//	printf("%p \n", )
		
    return 0;
}

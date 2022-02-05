#include <stdio.h>
void put1(const char *);
int  put2(const char *);

int main(void){
   
   put1("If I'd as much money");	
   put1("as I could spend,\n");
   printf("I could %d characters.\n",put2("I never would cry old chars to mend."));
   return 0;
}

void put1(const char *string){   
   while(*string != '\0')
	   putchar(*string++);
       // *string++ 等价于 *(string++)
	   //                    取出string的地址在把地址加1，取出地址与间接运算符*结合
	   // while(*string)                   
}

int put2(const char *string){  
	int count = 0;
	while(*string){
	   putchar(*string++);
       count++;
	}
	putchar('\n');
    return count;
}

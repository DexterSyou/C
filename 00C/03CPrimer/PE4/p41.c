#include <stdio.h>
#include <string.h>

#define DENSITY 62.4

int main(){
   float weight, volume;
   int size, letters;
   char name[40];
   printf("Hi! What's your first name?\n");
   scanf("%s",name);
   printf("%s, What's your weight in pounds?\n",name);
   scanf("%f",&weight);
   size = sizeof(name);
   letters = strlen(name);
   volume = weight / DENSITY;
   printf("Well,%s, your volume is %2.2f cubic feet.\n",name,volume);
   printf("Also, your first name has %d letters, \n",letters);
   printf("and we have %d bytes to store it in.\n",size);
   return 0;
}

/*
 *  字符串：一个或多个字符的序列，双引号不是字符串的一部分
 *  \0 ASCII值为0
 *
 *
 */

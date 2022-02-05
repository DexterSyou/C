#include <stdio.h>
#include <string.h>
#define  MAX  20

int main(void){

   char   first[MAX];
   char   last[MAX];
   char   formal[2*MAX +10];
   double prize;
   
   puts("Enter your first name: ");
   gets(first);
   puts("Enter your last name: ");
   gets(last);
   puts("Enter your prize money: ");
   scanf("%lf", &prize);
   sprintf(formal,"%s,%-19s:$%6.2f\n",last,first,prize);
   puts(formal);
   return 0;
}

/*
 *  char *strchr (const char *s, int c)
 *      返回一个指向s中存放c的第一个位置的指针，没找到返回NULL
 *  char *strrchr(const char *s, int c)
 *  char *strpbrk(const char *s1, const char *s2)
 *  char *strstr(const char *s1,const char *s2)
 *  
 *  fgets(line,80,stdin);
 *  find=strchr(line,'\n');
 *  if(find)
 *    *find='\0';
 *
 *
 *
 *
 */

#include <stdio.h>
#include <string.h>
#define STR "string"
int main(void){
/*   
  char name[40];
  printf("Please enter an str:");
  scanf("%s",name);
  printf("The result is : \n");
  printf("The %s has %lu letters and occupies %lu memmory cells.\n",name,strlen(name),sizeof(name));
*/
  printf("The STR : %s ",STR);
  printf("strlen(STR) : %lu , sizeof(STR) : %lu \n", strlen(STR),sizeof(STR));
}


#include <stdio.h>

int main(){
 printf("%d",EOF);

 int c = getchar();
 printf("%d\n", (c != EOF));
 return 0;
}

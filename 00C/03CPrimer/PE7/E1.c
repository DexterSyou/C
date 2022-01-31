#include <stdio.h>
#define END_CHAR '#'
int main(void){
  char ch;
  int ccnt = 0;
  int scnt = 0;
  int lcnt = 0;
  printf("Enter your characters: \n");
  while((ch=getchar())!=END_CHAR){
     if(ch == ' '){
	   scnt++;
	 }else if(ch == '\n'){
	   lcnt++;
	 }else{
	   ccnt++;
	 } 
  }

  printf("The chars: %d, the lines: %d, the spaces: %d \n",ccnt,lcnt,scnt);
  return 0;
}

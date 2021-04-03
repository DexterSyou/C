#include <stdio.h>
#define MAXLINE 1000
/**
 * 外部变量 在程序执行期间一直存在 
 * 函数中的 每个局部变量只在函数调用时存在，在函数执行完毕退出时消失。
 * 
 */
int mygetline(void);
void copy(void);

int max;
char longest[MAXLINE];
char line[MAXLINE];

int main(){
 int len;
 //extern int max;
 //extern char longest[];
 

 max = 0;
 while((len=mygetline())>0)
	 if(len > max){
	   max = len;
	   copy();
	 }

 if(max > 0){
   printf("%s",longest);
 }
 return 0;
}


int mygetline(void){
  int c, i;
  // extern char line[];
  for(i=0;i<MAXLINE-1 && (c = getchar())!=EOF && c != '\n';i++){
    line[i] = c;
  }

  if(c == '\n'){
    line[i] = c;
	i++;
  }
  line[i] = '\0';
  return i;
}

void copy(void){
  int i;
  // extern char line[], longest[];
  i = 0;
  while((longest[i] = line[i]) != '\0'){
    i++;
  }
}

















#include <stdio.h>
#define MAXLINE 1000

int mygetline(char line[], int maxline);
void copy(char to[], char from[]);

int main(){
  int len;
  int max;
  char line[MAXLINE];
  char longest[MAXLINE];

  max = 0;
  while((len = mygetline(line,MAXLINE))>0){
   // 1-16
   // 
    if(len > max){
	  max = len;
	  copy(longest,line);
	}    
  }
  if(max > 0){
    printf("The longest char is : %s\n",longest);
  }

  return 0; 
}

int mygetline(char s[], int lim){
  int c, i;
  for(i=0; i<lim-1 && (c=getchar())!=EOF && c!='\n';++i){
     s[i] = c;
  }

  if(c == '\n'){
    s[i] = c;
	++i;
  }

  s[i] = '\0';
  return i;
}

// copy fromChars into toChars
void copy(char to[] , char from[]){
  int i;
  i=0;

  while((to[i] = from[i]) != '\0'){
     i++;
  }

}



#include <stdio.h>
#define MAXLINE 1000
int myGetLines(char line[]);
int compareLine(int ,int );

int main(){
 int len;
 char line[MAXLINE];
 while((len = myGetLines(line)) > 0){
    printf("The line Is : %s \n", line);
   
	if(compareLine(len,20) != 0 ){
	  printf("[ %s ] is your need Line, The len[%d] is oevr 20 ....\n", line, len);
	}
 
 }


 return 0;
}

// get the chars greater than 80
int myGetLines(char line[]){
  int i;
  int c;
  for(i=0;(c=getchar()) != EOF && c != '\n'; i++){
    line[i] = c;
  }

  if (c == '\n'){
    line[i] = '\0';
  }

  return i;
}

// compare line with 80 chars
//              array ???
int compareLine(int lineLen , int lineSize){

  return (lineLen > lineSize); 

}







///

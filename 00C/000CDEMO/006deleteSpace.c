#include <stdio.h>

#define OPEN_S 0
#define CLOSE_S 1
/**
 * aaa ssss  \n
 *           \n
 *   aaaa    \n
 * aaaaaaaa\n
 */

int getMyLine(char line[]){

	int i = 0;
	int c;
	while((c = getchar()) != EOF && c != '\n'){
	   line[i] = c;
	   i++;
	}
  return i;
}


int main(){
   
  char line[1000];	
  char out[1000];
  int len = 0;
  int i, j;
  int printSpace = CLOSE_S;
// 1-19  
  while((len = getMyLine(line)) >0){
     for(j=len-1; j>=0;j--){
       if (line[j] == ' '){
         line[j] = '\0';
		 continue;
	   }else{
	      break;
	   }
	 }
     printf("The line is [%s] ", line);
  }
  return 0;
}

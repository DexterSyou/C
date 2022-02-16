#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>
//
#define SIZE 20
//
static int ary[SIZE];
//
void showary(int []);
void showChoiceAry(int [],int);
//
int main(void){

   srand((unsigned int)time(NULL));   
   for(int i=0;i<SIZE;i++){
      ary[i] = rand() % 100 + 1;
   }
   showary(ary);
   int n=0;
   printf("Please enter your number(1~10)");
   scanf("%d",&n);
   showChoiceAry(ary,n);
   return 0;
}

void showChoiceAry(int ary[], int n){
     int showAry[n];
	 int flag=true;
	 srand((unsigned int)time(NULL)); 
     int cn=0;
	 for(int i=0;i<n;i++){
	    cn = rand() % 20 + 1;
		for(int j=0;j<i;j++){
		   if(ary[cn] == showAry[j]){       
			   flag=false; 
			   break;
		   }
		}
		if(flag){
          showAry[i] = ary[cn];
		  printf("Choice number %d\n",ary[cn]);
		}else{
		  printf("Have number %d\n",ary[cn]);	
		  flag = true; 
		  i--;
		}
	 }
/*****
 *   0 1 2 3 4 5
 *         i
 *     j=1   
 * ******/
     printf("Choice the nums\n");
  	 for(int i=0;i<n;i++){
	    printf("%d ",showAry[i]);
	 }
	 putchar('\n');
}

void showary(int ary[]){

  for(int i=1;i<=SIZE;i++){
     printf("%d ",ary[i-1]);
	 if(i % 10 == 0){
	   putchar('\n');
	 }
  }
}

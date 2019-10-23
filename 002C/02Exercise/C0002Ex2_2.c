//---------------------------------------------- 
//  Date    :  2019-10-22 
//  By      :  Dexter.S
//  Content :
//     for(i=0; i<lim-1 && (c=getchar())!='\n' && c!=EOF;i++)
//       a[i] = c;
//     不使用&&重写  
//----------------------------------------------
#include <stdio.h>
void test(int n);

int main(void){

   test(5);

   return 0;
}

void test(int n){
  int i;
  char c;
  int ary[n];
  for(i=0;i<n-1;i++){
     if((c=getchar()) != '\n'){
		 if(c!=EOF){
		   ary[i]=c;
		 }
	 } 
  }

  int j=0;
  for(j=0;j<n;j++){
    printf("The number : %d \n",ary[j]);
  }

}


// ---------------------------------------------
/** 
 *
 *
 */



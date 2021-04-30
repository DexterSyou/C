#include <stdio.h>
#define N 10
void insertSort(int ary[]);

int main(void){

  int testAry[N] = {2,3,4,1,6,7,0,21,32,9};

  insertSort(testAry);

  for(int i=0;i<10;i++){
    printf("No%d =( %d )\n",i+1,testAry[i] );  
  }

}

void insertSort(int ary[]){
  int i , j;
  int key;
  
  for(j = 1; j< 10 ; j++){
    key = ary[j];
	i = j - 1;
	while ( i >= 0 && ary[i] > key ){
	   ary[i+1] = ary[i];
	   i--;
	} 
	ary[i+1] = key;
  }
}

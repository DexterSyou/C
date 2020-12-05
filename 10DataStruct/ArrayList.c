#include <stdio.h>
#define Num 10
/* ArrayList ADT 
   假设对于N个整数元素的ArrayList */

int IsEmpty(const int ary[]);
int FindElement(int ele);
int Delete(int ele);
void Insert(int x, int position, int *ary);
void Clear();


int main(void){
  printf("<-------------------------------->\n");   
  //int *ary=(int *)malloc(sizeof(int)*Num);
  int ary[Num] = {1,2,3,4,5,6,7,8,9,0};
  Insert(5,2,ary);
  Insert(6,2,ary);
  for(int i=0;i<10;i++){
    printf("%d ",ary[i]);
  }
  printf("\n<----------------------------------->\n");
  
  return 0;
}

//int IsEmpty(const int ary[]){
// return (int)sizeof(ary)/sizeof(int); 
//}
void Insert(int x, int position,int *ary){
	for(int i= 8; i>=position-1; i--){
	     ary[i+1] =ary[i];      
	}
    ary[position-1] = x;
}

	

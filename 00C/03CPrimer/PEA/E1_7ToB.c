#include <stdio.h>
//
#define  ROWS  3
#define  COLS  5
//
void show_vla(int rows,int cols, const int ar[rows][cols]);
void show_ary(const int ary[ROWS][COLS]);
void copy_ptr(const int (*ar)[COLS], int target[ROWS][COLS]);
int main(void){

  const int src[ROWS][COLS] = {
     {1,12,13,14,15},
	 {2,22,23,24,25},
     {3,32,33,34,35}
  };
  int target1[ROWS][COLS];
  printf("The src Ary : \n");
  show_ary(src);
  //
  printf("The src Ary of Val printing: \n");
  show_vla(ROWS-1,COLS-2,src);
  //
  copy_ptr(src,target1);
  printf("The target1 Ary: \n");
  show_ary(target1);
  
  return 0;
}
void show_ary(const int ary[ROWS][COLS]){
   for(int i=0;i<ROWS;i++){
	   for(int j=0;j<COLS;j++)
		   printf("%d ",ary[i][j]);
       printf("\n");
   }
   printf("-------------------------\n");
}
void show_vla(int rows, int cols,const int ar[rows][cols]){
     for(int i=0;i<rows;i++){
		 for(int j=0;j<cols;j++)
	       printf("%d ",ar[i][j]);
		 printf("\n");
	 }
	 printf("------------------------\n");
}

void copy_ptr(const int ar[][COLS], int target[][COLS]){
    int i,j;
	for(i=0;i<ROWS;i++)
		for(j=0;j<COLS;j++)
          *(*(target+i)+j) = *(*(ar+i)+j);
          // *优先级高于+，（）与 []优先级高于*
}



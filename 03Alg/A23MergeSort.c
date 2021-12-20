#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#define SIZE 8

int merge(int ary[], int b, int m, int e){
  int leftArylen =m-b+1;
  int rightArylen=e-m;  
  int left[leftArylen+1];
  int rigth[rightArylen+1];
  int i,j=0;
  // create arrays L[0..n1] and R[0..n2]
  for (i=0;i<leftArylen;i++){
	  left[i] = ary[b+i];
  }	
  for (j=0;j<rightArylen;j++){
	  rigth[j] = ary[m+j+1];
  }
  left[leftArylen]=INT_MAX;
  rigth[rightArylen]=INT_MAX;
  //merge
  i=0;
  j=0;
  for(int k=b;b<=e;b++){
     if(left[i] <= rigth[j]){
        ary[k]=left[i];
        i++;
     }else{
        ary[k]=rigth[j];
        j++; 
     }
    k++;
  } 
  return 0; 
}

int merge_sort(int ary[],int b,int e){
   if(b<e){ 
     int m=(b+e)/2;
     merge_sort(ary,b,m);
     merge_sort(ary,m+1,e);
     merge(ary,b,m,e);
   }  
}

int main(int argc ,char *argv[]){
   int testAry[SIZE] = {0};	
   for(int i=0;i<SIZE;i++){
       testAry[i]=atoi(argv[i+1]);
       printf("argv[%d]=%d\n",i+1,testAry[i]);
   }
   printf("------After Merging Sort:------ \n");
   merge_sort(testAry,0,7);
   for(int i=0;i<SIZE;i++){
       printf("argv[%d]=%d\n",i+1,testAry[i]);
   }
   return 0;
}

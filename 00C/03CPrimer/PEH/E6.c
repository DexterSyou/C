#include <stdio.h>
int bisearch(int ary[],int size,int num);

int main(void){

    int ary[20] ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    
    printf("%d \n",bisearch(ary,20,16));

}

int bisearch(int ary[],int size,int value){

    int low=0;
    int high = size-1;
    int mid;
    int found=0; 
    while(low < high){
      mid = (high + low) / 2;
      if(value < ary[mid] ){
         high = mid - 1; 
      }else if(value > ary[mid]){
         low = mid + 1;
      }else{
          found = 1;
          break;
      }
    }

    return found;

}




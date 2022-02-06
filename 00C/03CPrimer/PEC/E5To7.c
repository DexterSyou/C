#include <stdio.h>
#include <stdlib.h>
#include <time.h>
//
#define SIZE 100
//
void sortAry(int ary[]);
//
static int count[10]={0};
//
int main(void){
    int ary[SIZE];
	int rv=0;
    srand((unsigned)time(0));
    for(int i=0;i<SIZE;i++){ 
	    rv=rand()%10;
		count[rv]++;
		ary[i] = rv + 1;

	}
	//rand() % 10 产生0~9的随机数
	sortAry(ary);
	//
	//for(int i=0;i<SIZE;i++){
	//   count[ary[i]-1]=count[ary[i]-1]+1; 
	//}

	for(int i=1;i<=SIZE;i++){
	   printf("%2d ",ary[i-1]);
	   if( i % 10 == 0 ){
	     putchar('\n');
	   }
	}

	for(int i=0;i<10;i++){
	  //E6.c
	  printf("%d counts %d \n",i+1,count[i]);
	}
	putchar('\n');
	return 0;
}

void sortAry(int ary[]){
   
   int temp=0;
   for(int i=0;i<SIZE;i++){
      for(int j=i+1;j<SIZE;j++)
		  if(ary[i] > ary[j]){
            temp   = ary[j];
			ary[j] = ary[i];
			ary[i] = temp;
		  }
   }
}

//E7.c
/* 外部全局指针ptd
 * 使用malloc分配数组
 * ptd指向malloc分配的数组，并存储total的值
 *
 * 操作ptd进行输出
 * free（ptd）
 */

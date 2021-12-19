#include <stdio.h>
#define SIZE 10
//
int sum(int ary[],int n);

int main(void){
  
  int marbles[SIZE] = {20,10,5,39,4,16,19,26,31,20};	
  long ansewer = sum(marbles,SIZE);

  printf("The total number of marbles is %ld.\n",ansewer);
  printf("The size of marbles is 10*%lu=%lu bytes.\n" ,sizeof(int), sizeof(marbles));

  return 0;
}

int sum(int ar[],int n){
  printf("The size of parameter ar[] is %lu bytes. \n",sizeof(ar));
  int i;
  int total = 0;
  for(i=0;i<n;i++){
    total += ar[i]; //ar[i] 与*(ar+i) 相同
  }
  return total;
}
/**************************************/
/*
 *  1.  数组由一系列类型相同的元素构成
 *      数组声明： 数组元素的 数目和类型
 *  2.  const int array[10]； 只读数组
 *      初始化数组，未初始化的元素则被设置为0
 *
 *  3.  数组名同时也是该数组首元素的地址 ary=&ary[0]
 *      声明数组参量，实际参数为数组名，形式参数为指针
 *      C对于int ar[]和int *ar作出同样解释，即ar为指针
 *        int sum(int *aryp, int n)
 *        int sum(int *, int n)
 *        int sum(int aryp[], int n)
 *        int sum(int [], int n)
 *
 *
 */

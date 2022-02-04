#include <stdio.h>
//
#define SIZE 10
//
double aryMax(const double ary[]);
double aryMin(const double ary[]);

//
int main(void){
  
	double ary[SIZE] = {1,21,32,4,5,6,7,8,9,0};
    printf("The ary Max : %f \n",aryMax(ary));
	printf("The ary Min : %f \n",aryMin(ary));
	printf("Max - Min : %f \n", aryMax(ary) - aryMin(ary));
    // printf传递参数时，C自动将float类型的参数转换为double类型
	// %f 打印float 和 double类型数据
	return 0;
}
double aryMin(const double ary[]){
   double r=ary[0];
   for(int i=1;i<SIZE;i++)
	   if(r>ary[i])
		   r=ary[i];
   return r;
}

double aryMax(const double ary[]){
   double r=ary[0];
   for(int i=1;i<SIZE;i++)
	   if(r < ary[i])
		   r=ary[i];
  return r; 
}

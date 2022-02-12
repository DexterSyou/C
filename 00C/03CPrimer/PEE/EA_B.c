#include <stdio.h>
#include <math.h>
#define SIZE 10
//
void transform(double source[],double target[],int size,double (*ptr)(double));
double add1(double);
//
int main(void){

  double source[SIZE]={1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,9.0};
  double target[SIZE];
  //transform(source,target,SIZE,sin);
  transform(source,target,SIZE,add1);
  for(int i=0;i<SIZE;i++){
    printf("%.2f ",target[i]);
  }
  putchar('\n');
  return 0;
}

//
void transform(double source[],double target[],int size,double(*ptr)(double)){
	for(int i=0;i<size;i++){
       target[i]=(*ptr)(source[i]);
	}
}
//
double add1(double num){
  return num+1.0;
}


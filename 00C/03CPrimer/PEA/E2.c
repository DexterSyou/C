#include <stdio.h>
void show_ary(const double ary[]);
void copy_arr(const double src[], double tag[], int n);
void copy_ptr(const double *src,  double *tag,int n);
int main(void){
  double source[5] = {1.1,2.2,3.3,4.4,5.5};
  double target1[5];
  double target2[5];

  printf("The source ary : \n");
  show_ary(source);   
  //
  copy_arr(source,target1,5);
  printf("\nThe arr target1 ary: \n");
  show_ary(target1);
  //
  copy_ptr(source,target2,5);
  printf("\nThe ptr target2 ary: \n");
  show_ary(target2);
  //
  printf("\n");
}

void copy_arr(const double src[],double tag[], int n){
    int i;
	for(i=0;i<n;i++)
		tag[i] = src[i];
}

void copy_ptr(const double *src, double *tag, int n){
   int i;
   for(i=0;i<n;i++){
	  *tag++=*src++;
   }
}

void show_ary(const double ary[]){
   for(int i=0;i<5;i++){
     printf("%f ",ary[i]); //*(ar+i)  //*ar,ar++
   }
}


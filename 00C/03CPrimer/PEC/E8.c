#include <stdio.h>
#include <stdlib.h>

int *make_array(int elem,int val);
void show_array(const int ar[], int n);

int main(void){

	int *pa;
	int size;
	int value;

	printf("Enter the number of elements: ");
	scanf("%d",&size);
	while(size>0){
	   printf("Enter the initialization value: ");
	   scanf("%d",&value);
	   pa = make_array(size,value);
       if(pa){
	     show_array(pa,size);
		 free(pa);
	   }

	   printf("\nEnter the number of elements (<1 to quit): ");
	   scanf("%d",&size);
	}

	printf("Done.\n");
	return 0;
}

int *make_array(int elem,int val){
  int *ptr;
  ptr = (int *)malloc(elem *sizeof(int));
  
  for(int i=0;i<elem;i++){
    ptr[i] = val;
  }
  return ptr;
}

void show_array(const int ar[],int n){
  for(int i=1;i<=n;i++){
	  printf("%3d ",ar[i-1]);
      if(i%8 == 0)
		  putchar('\n');
  }

}




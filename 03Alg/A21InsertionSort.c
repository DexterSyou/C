#include <stdio.h>
#include <stdlib.h>
#define SIZE 9
int Insertion_sort(int ary[] , int n);

int main(int argc, char *argv[]){

	if((argc-1) != SIZE ){
	    printf(" It must have 9 params.\n");
		return 1;
	}
	printf("Argc: %d.\n", argc);
    // put params into a sorted array
	int sortAry[SIZE]={0};
	int i=0;
	for(i=1;i<argc;i++){
	    printf("Argv[%d]=%d.\n",i,atoi(argv[i]));
	    sortAry[i-1]=atoi(argv[i]);
	}

	if(Insertion_sort(sortAry,SIZE) == 0){
	  printf("Insert Sorted successfully!\n");
	}
	
    printf("--After Sorted:------------------------\n");
	for(i=0;i<SIZE;i++){
	 printf("Argv[%d]=%d.\n",i+1,sortAry[i]);
	}


    return 0;
}

int Insertion_sort(int ary[],int n){
    int key=0;
	int i, j=0;
	for(j=1;j<n;j++){
	   key=ary[j];
       //Insert rigthOfAry[j] into the sorted sequence leftOfAry[0...j-1]
	   i=j-1;
       while(i>=0 && ary[i]>key){
	      ary[i+1]=ary[i];
		  i=i-1;
	   }
	   ary[i+1] = key;
	}
	return 0;
}

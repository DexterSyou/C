#include <stdio.h>
#include <string.h>
#define  SIZE  81
#define  LIM   20
#define  HALT  " "

void stsrt(char *strings[],int num);

int main(void){

	char input[LIM][SIZE];
	char *ptstr[LIM];
	int ct = 0;
	int k;

	printf("Input up to %d lines, and I will sort them.\n", LIM);
	printf("To stop press the Enter key at a line's start.\n");
	while(ct < LIM && gets(input[ct])!=NULL && input[ct][0]!='\0'){
	    ptstr[ct] = input[ct];
        //指针ptstr[ct]指向数组input[ct]的第一个字符
		//每个input[ct]是一个含有81个元素的数组
		//每个ptstr[ct]都是一个变量
		ct++;
	}

	stsrt(ptstr,ct);
	puts("\nHere's the sorted List: \n");
	for(k=0;k<ct;k++){
		puts(ptstr[k]);
	}
    return 0; 
}

void stsrt(char *strings[], int num){
    char *temp;
	int top,seek;
	for(top=0;top<num-1;top++)
		for(seek=top+1;seek < num;seek++)
			if(strcmp(strings[top],strings[seek])>0){
			   temp          = strings[top];
			   strings[top]  = strings[seek];
			   strings[seek] = temp;
			   /*
				* 排序过程交换指针
				* ptstr[0]
				* ptstr[1]
				* ...
				* ptstr[LIM-1]
				*/
			}
}


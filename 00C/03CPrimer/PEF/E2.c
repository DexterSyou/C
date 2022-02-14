#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char *itobs(int,char *);
int btois(char *,int);

int main(int argc, char *argv[]){
  if(argc != 3){
    printf("Usage: a.out bstr1 bstr2: \n");
    exit(1);
  }
  char bin_str[8*sizeof(int)+1];
  int size1=strlen(argv[1]);
  int size2=strlen(argv[2]);
  int num1=btois(argv[1],size1); 
  int num2=btois(argv[2],size2);
  printf("num1: %s[B] %d[D]\nnum2: %s[B] %d[D]\n",argv[1],num1,argv[2],num2);
  printf("%d\n",~num1);
  //printf("~num1:%s[B] %ud[D]\n~num2:%s[B] %d[D]\n",
  //		  itobs(~num1,bin_str),~num1,itobs(num2,bin_str),~num2);
  return 0;
}

int btois(char *pbin,int size){
   int result=0;
   for(;*pbin!='\0';pbin++,size--){
      if(*pbin=='1'){
	    result+=1<<(size-1);
	  }
   }
   return result;
}

char* itobs(int n,char *ps){
	int i;
	static int size = 8 * sizeof(int);
	for(i=size-1;i>=0;i--,n>>=1){
	  ps[i]=(01 & n) + '0';
	  //  01 :  0000000 0000000 0000000 0000001
	  //  num:  0000000 0000000 0000000 00000000                 
	  //        -                             *-
	}
	ps[size]='\0';
	return ps;
}
// 位运算作用域整形数据，包括char

#include <stdio.h>
//
static int mask = 0x01;
static int size = 8 * sizeof(int);
//
int countBits(int num);
char *itobs(int num,char *ps);
//
int main(){

    char bit_str[size+1];
    int num=0;
    printf("Please enter a number:");
    scanf("%d",&num);
    printf("The num %d binary %s has [%d] number 1\n",num,itobs(num,bit_str),countBits(num));
    return 0;
}

int countBits(int num){
  int count=0;  
    /*
  for(int i=0;i<size;i++,num>>=1){
      if((num & mask)==mask){
          count++; 
      }
  }*/
  while(num){
    count += (num & mask);
    num >>= 1;
  }  
  return count;
}

char *itobs(int num,char *ps){

    for(int i=size-1;i>=0;i--,num>>=1){
        ps[i]=(mask & num) + '0';
    }
    ps[size]='\0';
    return ps;
}

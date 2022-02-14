#include <stdio.h>
//
static int mask = 0x01;
static int size = 8 * sizeof(int);
//
int checkBits(int num, int bpos);
char *itobs(int num,char *ps);
//
int main(){

    char bit_str[size+1];
    int num =0;
    int bpos=0;
    printf("Please enter a number: ");
    scanf("%d",&num);
    printf("Enter the bit position: ");
    scanf("%d",&bpos);
    printf("The num %d binary %s \n",num,itobs(num,bit_str));
    printf("The %d position bit is %d \n",bpos,checkBits(num,bpos));
    return 0;
}

// if bit is 1, return 1
// else return 0
int checkBits(int num, int bpos){
  /*
  for(int i=0;i<bpos-1;i++,num>>=1);
  if((num & mask)==mask){   
     return 1; 
  }
  return 0;
  */
  return  (num & (1<<(bpos-1))); 
    
}

char *itobs(int num,char *ps){

    for(int i=size-1;i>=0;i--,num>>=1){
        ps[i]=(mask & num) + '0';
    }
    ps[size]='\0';
    return ps;
}

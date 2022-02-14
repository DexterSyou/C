#include <stdio.h>
#include <limits.h>
//
static unsigned int mask = 0x01;
static unsigned int size = 8 * sizeof(unsigned int);
//
unsigned int rotate_l(unsigned int x, int num);
char *itobs(int num,char *ps);
//
int main(){

    unsigned int num=0xffffff0a;
    unsigned int rnum=0;
    char bit_str[size+1];
    printf("The num[%20ud] binary:%s \n",num,itobs(num,bit_str));
    rnum = rotate_l(num,8);
    printf("After rotaing :  \n");
    printf("The num[%20ud] binary:%s \n",rnum,itobs(rnum,bit_str));
    return 0;
}

unsigned int rotate_l(unsigned int rnum, int num){
  for(int i=0;i<num;i++){
      //
      //11111111 11111111 11111111 00000000
      //00000000 00000000 00000000 00000001
      //                                  -
      //                                  高位
      unsigned int mask=( rnum>> (CHAR_BIT * sizeof(unsigned int)-1)) ;
      //
      rnum = (rnum<<=1) | mask;
  }
  return rnum;
}

//
char *itobs(int num,char *ps){
    for(int i=size-1;i>=0;i--,num>>=1){
        ps[i]=(mask & num) + '0';
    }
    ps[size]='\0';
    return ps;
}

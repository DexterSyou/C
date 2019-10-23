//---------------------------------------------- 
//  Date    : 2019-10-22
//  By      : Dexter.S
//  Content :
//    把十六进制的字符串转换为整形值
//    0～9 a～f A～F
//----------------------------------------------
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

void htoi(char s[]);

int main(void){
  htoi("0x123af");
  return 0;
}

void htoi(char s[]){
  int len=strlen(s);
  char hex[len-2];
  for(int i=0;i<len-2;i++){
    hex[i]=s[len-1-i]; 
  }

  int sum=0;
  int hexdigit=0;
  for(int n=0;n<len-2;n++){
	if(hex[n]>='0' && hex[n]<='9'){
	  hexdigit=hex[n]-'0';
	}else if(hex[n]>='a' && hex[n]<='z'){
	  hexdigit=hex[n]-'a'+10;
	}else{
	  hexdigit=hex[n]-'A'+10;
	}
	sum += hexdigit*pow(16,n);
  }  
  printf("H : %s ==> D : %d  \n", s, sum);
}

// ---------------------------------------------
/** 
 *  从低位到高位，从右往左运算，每逢16进1
 */



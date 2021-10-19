#include <stdio.h>
// 0xAcf9
int htoi(char s[]){

  int i;
  int decimalNum=0;
  int base=16;
  int value=0;
  
  // 0x 或0X不计算
  for(i=2;  s[i] != '\0'; i++){
	if(s[i]<='f' && s[i]>='a'){
		value= s[i] - 87;  
	}else if(s[i]<='F' && s[i] >='A'){
		value=s[i] - 55; 
	}else{
		value=s[i] - 48;   
	}

    //printf("value : %d \n", value);
    decimalNum = 16*decimalNum + value;
    
	/*
	 * ((A * 16 + C) * 16 + f ) *16 +9 
	 *  A*16*16*16 + C*16*16 + f*16 +9 
	 */
  }	
  return decimalNum;

}
int main(){

 int result = htoi("0xAcf9");
 printf("The Hex 0xAcf9 change to decimal %d \n", result);
 
 return 0;

}

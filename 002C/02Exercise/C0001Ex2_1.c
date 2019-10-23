//###############################################
//  Date    : 2019-10-22
//  By      : Dexter.S
//  Content : 
//       求cahr short int long 取值范围
//       两种方法1.用头文件 2.用计算方法 
//###############################################

#include <stdio.h>
#include <limits.h>
#include <float.h>
//###############################################

int main(void){

  // 1
  signed char sc_max=CHAR_MAX; 
  signed char sc_min=CHAR_MIN;
  unsigned char uc_max=UCHAR_MAX;
  signed int si_max=INT_MAX;
  signed int si_min=INT_MIN;
  unsigned int ui_max=UINT_MAX;
  signed short ss_max=SHRT_MAX;
  signed short ss_min=SHRT_MIN;
  unsigned short us_max=USHRT_MAX;
  signed long sl_max=LONG_MAX;
  signed long sl_min=LONG_MIN;
  unsigned long ul_max=ULONG_MAX;

  printf("Type\t\tMAX\t\t\tMIN\n");
  printf("Signed Char\t%d\t\t\t%d\n",sc_max,sc_min);
  printf("Unsigned Char\t%d\t\t\t%d\n",uc_max,0); 
  printf("Signed INT\t%d\t\t%d\n",si_max,si_min);
  printf("Unsigned INT\t%u\t\t%d\n",ui_max,0);
  printf("Signed SHORT\t%d\t\t\t%d\n",ss_max,ss_min); 
  printf("Unsigned SHORT\t%u\t\t\t%d\n",us_max,0); 
  printf("Signed LONG\t%ld\t%ld\n",sl_max,sl_min);
  printf("Unsigned LONG\t%lu\t%ld\n",ul_max,0L);

  printf("\n*********************************************\n");
  //2
  // (char)((unsigned char) ~0 >>1)
  // ~0 先把0的各个二进制全部转换为1
  // 将值转换为(unsigned char) 类型
  // 再把unsigned char类型值右移动一位清楚符号位
  // 在把他转换为char
  //   
  printf("signed int %d \n" ,(char)((unsigned char)~0>>1));
  printf("unsigned int %u \n", (unsigned int)~0);
  return 0;
}

//###############################################
/** 
 *
 */



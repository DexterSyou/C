#include <stdio.h>
char *itobs(int, char *);
void show_bstr(const char *);
int invert_end(int num, int bits);
int main(void){
   
	char bin_str[8 * sizeof(int)+1];
    int number;
	puts("Enter integers and see them in binary.");
    puts("Non-numeric input terminates program.");
	while(scanf("%d",&number)==1){
	   itobs(number,bin_str);
	   printf("%d is  ",number);
	   show_bstr(bin_str);
	   putchar('\n');

	   //
	   //
	   number = invert_end(number,4);
	   printf("Inverting the last 4 bits gives\n");
	   show_bstr(itobs(number,bin_str));
	   putchar('\n');
	}

	puts("Bye!");
	return 0;
}

char *itobs(int n, char *ps){
   int i;
   static int size = 8 * sizeof(int);

   for(i=size-1;i>=0;i--,n>>=1)
	   ps[i]=(01 & n) + '0';/*掩码00000001*/
   ps[size] = '\0';

   return ps;
}

void show_bstr(const char *str){
   int i=0;
   while(str[i]){
      putchar(str[i]);
	  if(++i % 4 == 0 && str[i])
		  putchar(' ');
   }
}

int invert_end(int num, int bits){

    int mask = 0;   // 00000000 00000000 00000000 00000000
	int bitval = 1; // 00000000 00000000 00000000 00000001

	while(bits-- > 0){
	   mask |= bitval;  //
	   bitval <<= 1;    //1. 0 00000000 00000000 00000000 00000010 
                        //2. ......
	
	}

	return num ^ mask;
}


/*
 *二进制整数：
 *  一个字节通常包括8个位
 *  C的byte表示用于 存放系统字符集的空间大小
 *
 ******这里假定8位（存储芯片，传输数据一般8位）
 *   7    6   5  4  3  2  1  0 
 *   0    1   0  0  1  0  0  1
 *  128  64  32 16  8  4  2  1
 *
 *  通过改变对位模式的解释方式
 *  unsigned char   0～255
 *  signed char     -128～+127     
 *
 *有符号整数：
 *   有符号数的表示方法由硬件决定，而不是由C决定的
 *   two's-complement 
 *   one's-complement
 *
 *二进制数浮点数
 *   二进制小数 和 二进制指数
 *   1.01 
 *   1/2+0/4+1/8
 *八进制   octal
 *十六进制 hex
 *
 *************************************
 *C的位运算 
 * bitwise ： 4个位运算符用于整形数据
 *            作用于一个位    
 * 
 *  ～按位取反
 *      var=00000010, ~val=11111101
 *      ~运算不改变val的值，也不创建一个可以在别处使用或被赋值的新值
 *      var=～val
 *   
 *  & 按位与
 *      逐位进行比较，位都为1时，结果才为1
 *      val &= 0377
 *      val = val & 0377
 *
 *  | 按位或 
 *      逐位进行比较，位都为0时，结果才为0
 *      val |= 0377 
 *
 *  ^ 位异或
 *      逐位进行比较，相异为1，相同为0
 *      val ^= 0377
 *  
 ***************************************     
 *  IF  MASK is 2 --> MASK 00000010
 *1.掩码  
 *  flag = flag & MASK 
 *  ***掩码MASK中0覆盖了flag中相应的位，只有位1的对应位才可见
 *    
 *  flags &= MASK 
 *     ch &= 0xff（0377 十进制）   11111111 
 *     该掩码留下ch的最后八位，将其余位设为0，留下一个字节 
 *     
 *2. 打开位
 *   打开一个值中特定位，同时保持其他位不变
 *   flags |= MASK 
 *   *** 任何位与0 | 运算结果为本身，与1 | 结果为1
 *   
 *3. 关闭位
 *   *** 任何位与1 & 运算结果为本身，与0 & 结果为0 
 *   flags &= ～MASK
 *
 *4. 转置位
 *   flags ^= MASK     
 *   
 *   if b is a bit
 *   if b=1,             1^b is 0 
 *   if b=0,             1^b is 1
 *   if b=0 ro 1 ,       0^b is b   
 *                    对应掩码1的位被转置，对应掩码0的位不变
 *
 *5.查看以为的值
 *   
 *  if((flag&MASK)==MASK)
 *      puts("Wow");
 *
 ************************************
 * 左移 <<
 *    产生新的值，不改变其操作数，空位补0，丢位  
 *        10001010 << 2
 *    10  00101000
 *    --        --
 *    丢        补
 *
 *    var = var<<2
 *
 * 右移 >>
 *    空位补0（unsigned）,结果依赖机器（signed）
 *   
 *    （signed）
 *    10001010 >> 2
 *    00100010 10
 *    --       --
 *    11100010 10
 *    --       --
 *    补       丢
 *      
 *    （unsigned）
 *    10001010 >> 2
 *    0010001010 
 *    --      --
 *    补      丢
 *
 * num<<n 乘以2的n次幂
 * num>>n 除以2的n次幂
 *
 *
 *
 *
 *
 *     
 */

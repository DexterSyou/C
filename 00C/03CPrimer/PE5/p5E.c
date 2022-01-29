#include <stdio.h>
int main(void){

    char  ch;
	int   i;
	float f1;
    f1=i=ch='A';
	printf("ch=%c,i=%d,f1=%2.2f\n",ch,i,f1);
	ch=ch+1;
	i=f1+2*ch;
	f1=2.0*ch+i;
	printf("ch=%c,i=%d,f1=%2.2f\n",ch,i,f1);
	ch=5212205.17;
	printf("Now ch=%c\n",ch);
	return 0;
	/**
	 *  1.表达式 有符号，无符号的char，short 都将自动转换为int
	 *  2.K&R C下，float自动被转换为double
	 *  3. int --> unsigned int --> long -->unsigned long -->long long --> unsigned long long 
	 *     -->float --> double -->long double
	 *     注意short，int ，long的大小，字节是否相同
	 *  4. 赋值运算转换为左边的类型
	 *  5.函数参数，char与short ---> int
	 *              float ---> double
	 *
	 *
	 */
}

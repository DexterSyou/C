#include <stdio.h>
#define TWO 2
#define OW "Consistency is the last refuge of the unimagina\
	tive. - Oscar Wilde"
#define FOUR TWO*TWO
#define PX printf("X is %d.\n",x)
#define FMT "X is %d.\n"

int main(void){
    int  x=TWO;
	PX;
    x=FOUR;
	printf(FMT,x);
    printf("%s\n",OW);
	printf("TWO:OW\n");
	return 0;
}

/*
 * 预处理前，编译器会进行几次翻译
 *    源代码出现的字符映射到源字符集
 *    转换换行，变成一行逻辑（删除\，和换行）
 *    用空格代替每一个注释
 *    用单个空格代替每一个空白字符
 *
 *进入预处理，寻找预处理指令#
 *
 */

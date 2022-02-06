#include <stdio.h>
#define MAXLINE 20
int main(void){

	char line[MAXLINE];

	while(fgets(line,MAXLINE,stdin)!=NULL && line[0]!='\n')
		fputs(line,stdout);
	/*
	 * fgets :
	 *    第一个参数：存储输入的地址
	 *    第二个参数：输入字符串的最大长度
	 *    第三个参数：指向要读取的文件
	 *
	 *    函数读取到它所遇到的第一个换行符后面 或读取比字符串的最大长度少一个的字符
	 *    或者读取到文件结尾。然后fgets函数相末尾添加一个空字符。
	 *    ###会保存读入的换行符
	 *    fgets遇到EOF时会返回NULL值，否则它返回传递给它的地址值
	 * fputs :
	 *    第一个参数：一个字符串地址
	 *    第二个参数：一个文件指针
	 *    ###不自动添加换行
	 *
	 *
	 */
	return 0;
}

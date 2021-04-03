#include <stdio.h>
/*
 * 标准库的输入/输出都是按照字符流的方式处理
 * EOF  end of file 是个整形数
 * */

int main(){
  int c;
  c = getchar();
  //while(c!=EOF){
  //  putchar(c);
  //	c = getchar();
  //}
  //
  while((c=getchar())!= EOF)
	  putchar(c);

  return 0;
}

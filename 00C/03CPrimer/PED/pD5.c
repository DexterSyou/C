#include <stdio.h>
#include <stdlib.h>
//#define  CNTL_Z  '\032'
#define  SLEN    50

int main(void){
  
  char  file[SLEN];
  char  ch;
  FILE  *fp;
  long  count, last;

  puts("Enter the name of the file to be processed: ");
  gets(file);
  if((fp=fopen(file,"rb"))==NULL){
    printf("reverse can't open %s\n",file);
	exit(1);
  }
  fseek(fp,0L,SEEK_END);
  /*
   ****** fseek
      第一个参数：一个指向被搜索文件的FILE指针
      第二个参数：偏移量，long类型，从起始点要移动的距离
                 正数（前移）
                 负数（后移）
                 0L （保持不动）
      第三个参数：标识起始点 
                 SEEK_SET   文件开始 0L
                 SEEK_CUR   当前位置 1L
                 SEEK_END   文件结尾 2L
      返回值    ：正常终了返回0，如果出现错误，返回-1
  */
  last = ftell(fp);
  /*
   *******ftell
   long类型，返回文件当前位置
   ANSI 的ftell 在stdio.h中被声明
   UNIX 中实现ftell函数通过返回文件开始处字节数来确定文件的位置，文件第一个字节到文件开始处的距离是字节0，以此类推。
  */ 

  /*
    实际系统之间存在差异，可移植性的局限性
    在文件模式下：
    fseek(file,ftell-pos,SEEK_SET)
  */
  for(count = 1L;count <= last;count++){
       // 文件结尾前的第一个字符，即文件最后一个字符
	  fseek(fp,-count,SEEK_END);
	  ch = getc(fp);
	/* MS-DOS
       文本模式     \r\n ---> \n
       二进制模式   将看到\r\n
	  if(ch!=CNTL_Z && ch !='\r')
		  putchar(ch); */
	  if(ch == '\r')
		  putchar('\n');
	  else
		  putchar(ch);
  }

  putchar('\n');
  fclose(fp);
  return 0;
}
/*
 *******fgetpos()  fsetpos()
 fpos_t 指定文件中的一个位置
 int fgetpos(FILE *restrict stream, fpos_t * restrict pos);
 **pos 所指的位置放置一个fpos_t的值（描述了文件中的一个位置）
 函数成功返回0，否则返回一个非0值

 int fsetpos(FILE *stream, fpos_t *pos);

*/

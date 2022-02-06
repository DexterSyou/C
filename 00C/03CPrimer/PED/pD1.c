#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
 
	int ch;
	FILE *fp;
	long count = 0;

	if(argc != 2){
	  printf("Usage: %s filename\n",argv[0]);
	  exit(1);//exit函数的参数会被传递给操作系统，0正常终止，非0，非正常终止
              //终止程序
	}

	if((fp=fopen(argv[1],"r"))==NULL){
	  //打开文件
	  //fopen函数返回一个文件指针，如果不能打开文件fopen函数返回空指针
	  printf("Can't open %s\n",argv[1]);
	  exit(1);
	}

	while((ch=getc(fp))!=EOF){
     /*
	  * 读入字符时发现达到文件结尾，getc函数返回一个特殊值EOF
	  * C程序只有在读取超出文件结尾以后才会发现文件的结尾
	  */
	  putc(ch,stdout);
	  // 从fp指定的文件中获得一个字符
	  // 将ch写入到stdout
	  count++;
	}

	fclose(fp);
	/* fclose函数关闭由指针fp指定的文件，同时根据需要刷新缓冲区
	 * 文件关闭成功，返回0，否则返回EOF
	 *
	 * if(fclose(fp)!=0)
	 *    printf("Error in closing file %s\n",argv[1]);
	 */
	printf("File %s has %ld characters\n",argv[1],count);
	return 0;
}
/*
 * 文件：磁盘上的一段命名的存储区
 *       C将文件看成是连续的字节序列，\n表示行尾
 * #  文本文件，二进制文件
 * #  I/O 级别
 *    操作系统提供的基本I/O服务  
 *    标准C库函数 
 *
 * 标准文件：
 *   C程序自动打开3个文件
 *   标准输入 getchar gets scanf
 *   标准输出 putchar puts printf
 *   标准错误
 *
 * 标准文件指针：
 *   FILE 
 *     stdin
 *     stdout
 *     stderr
 *     
 * 标准I/O：
 *   1.专用的函数，可以方便处理I/O问题
 *   2.对输入，输出进行缓冲。（大块数据复制到缓冲区）
 *
 *
 */






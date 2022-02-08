#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define BUFSIZE 1024
#define SLEN 81

void append(FILE *source, FILE *dest);

int main(void){

	FILE *fa,*fs;
	int files=0;
	char file_app[SLEN];
	char file_src[SLEN];
	puts("Enter name of destination file: ");
	gets(file_app);
	if((fa=fopen(file_app,"a"))==NULL){
	   fprintf(stderr,"Can't open %s\n",file_app);
	   exit(2);
	}

	if(setvbuf(fa,NULL,_IOFBF,BUFSIZE)!=0){
	/*
	 * 如果setvbuf不能创建缓冲区，返回非0值
	 * int setvbuf(FILE *restrict fp,char *restrict buf,int mode,size_t size)
	 * fp   :指定文件流
	 * buf  :指向将使用的存储区
	 *       buf为NULL时函数将自动为自己分配一个缓冲区
	 *       不为NULL时，就必须创建一个缓冲区
	 * zise :指定数组的大小
	 * mode :
	 *    _IOFBF   表示完全缓冲（缓冲区满是刷新）
	 *    _IOLBF   表示行缓冲  （缓冲区满是或一个新行写入）
	 *    _IONBF   表示无缓冲
	 *******
	 */
	   fputs("Can't create output buffer\n",stderr);
	   exit(3);
	}

	puts("Enter name of first source file (empty line to quit):");
	while(gets(file_src)&&file_src[0]!='\0'){
	   if(strcmp(file_src,file_app)==0)
		   fputs("Can't append file to itselft\n",stderr);
	   else if((fs=fopen(file_src,"r"))==NULL)
		   fprintf(stderr,"Can't open %s\n",file_src);
	   else{
	       if(setvbuf(fs,NULL,_IOFBF,BUFSIZE)!=0){
		      fputs("Can't create input buffer\n",stderr);
		      continue; 
		   }
		   append(fs,fa);
		   if(ferror(fs)!=0)
			   //如果发生读写错误，ferror函数返回一个非0值，否则返回0
			   //feof 最近一次调用到达文件结尾，feof函数返回一个非零值
			   fprintf(stderr,"Error in reading file %s.\n",file_src);
           if(ferror(fa)!=0)
			   fprintf(stderr,"Error in writing file %s.\n",file_app);
           fclose(fs);
           files++;
	       printf("File %s appended.\n",file_src);
		   puts("Next file (empty line to quit):"); 
	   }
	}
	printf("Done. %d files appended.\n",files);
	fclose(fa);
	return 0;
}

void append(FILE *source, FILE *dest){
  
	size_t bytes;
	static char temp[BUFSIZE];

	while((bytes=fread(temp,sizeof(char),BUFSIZE,source))>0)
		fwrite(temp,sizeof(char),bytes,dest);
/*
 * 二进制形式存储：数据存储在一个使用与程序具有相同表示方法的文件中
 * 标准I/O：fread，fwrite提供了二进制形式的存储
 * ***
 * size_t fwrite(const void * restrict ptr, size_t size,size_t nmemb, FILE *restrict fp)
 *  ptr   : 要写入数据块的地址 
 *  size  : 要写入数据块的大小（以字节为单位）
 *  nmemb : 数据块的数目
 *  fp    : 要写入的文件
 *
 *返回值size_t :返回成功写入的项目数，正常情况下与nmemb相等
 *
 * ***
 * size_t fread(void * restrict ptr, size_t size, size_t nmemb, FILE *restrict fp)
 *
 * 
 * fp  : 读取的文件
 * 返回成功读取的项目数，正常情况下与nmemb相等
 */

}






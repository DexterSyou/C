#include <stdio.h>
#include <stdlib.h>

int main(void){
 
	int ch;
	FILE *fp;
	long count = 0;
    char filename[20];
	printf("Please enter a file name : ");
	scanf("%s",filename);
	if((fp=fopen(filename,"r"))==NULL){
	  //打开文件
	  //fopen函数返回一个文件指针，如果不能打开文件fopen函数返回空指针
	  printf("Can't open %s\n",filename);
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
	printf("File %s has %ld characters\n",filename,count);
	return 0;
}



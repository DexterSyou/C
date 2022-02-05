#include <stdio.h>
//
#define SIZE 10
//
//
void myGetStr(char *str,int n);
void e1(void);
void e2(void);
//
int main(void){
  //e1();
  e2();
  return 0;
}

void e1(void){
	char str[SIZE];
	puts("Please enter your string?");
    fgets(str,SIZE,stdin);
    // 读入SIZE-1个字符，自动在结尾加‘\0’
	// 可读入空格，制表符，换行符
	// 读取换行符或读入SIZE-1个字符停止读入
	puts("THE STRINGS: ");
    fputs(str,stdout);
}

void e2(void){
    char str[SIZE];
    puts("Please enter your string?");
    //gets(str); 读取所有的字符，知道遇到第一个换行为止
	//scanf 基于单词读取，遇到下一个空白（空格，制表符，换行符）为止
    //自定义
	myGetStr(str,SIZE); 
	puts(str);
}

void myGetStr(char *str,int n){
    int  i=0;
    char ch;
    while( i<n-1 && (ch=getchar()) != '\n' &&(ch != ' ') && (ch != '\t')){
	    str[i++]=ch;
	}
	while(getchar()!='\n') 
		continue;
	str[i] ='\0';
}




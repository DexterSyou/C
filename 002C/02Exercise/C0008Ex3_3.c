//---------------------------------------------- 
//  Date    :
//  By      :
//  Content :
//     将字符串s1中类似于 a-z 一类的速记符号在字符串中s2中扩展为等价的完整列表
//     该函数可以处理大小写
//     可以处理a-b-c a-z0-9 -a-z等类似情况，作为签到和尾随的-一样牌瘾
//----------------------------------------------
#include <stdio.h>
//void expand(char s1[], char s2[]){
void expand(){
  char s1[]="a-z";
  char s2[100]={'0'};
  char c;
  int i=0;
  int j=0;

  while((c=s1[i++]!='\0')){
     if(s1[i]=='-' && s1[i+1]>=c){
	       i++;
		   while(c<s1[i]){
//		     s2[j++]= c++;
             printf("%c", c++); 
		   }
	 }else{
	    s2[j++]=c;
	 }
  }

  s2[j]='\0';

  printf("%s \n",s1);
}


int main(void){
  //char s1[20]="a-z-0-9";
  //char s2[100]={'\0'};
  expand();
  //  printf("The expanded str : %s ", s2);
}

// ---------------------------------------------
/** 
 */



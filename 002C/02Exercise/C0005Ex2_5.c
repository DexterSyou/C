//---------------------------------------------- 
//  Date    :
//  By      :
//  Content :
//      将字符串中s2中的任意字符 在s1中第一次出现的位置作为返回
//
//----------------------------------------------
#include <stdio.h>
int any(char s1[] , char s2[]){
  
  for(int i=0; s2[i]!='\0';i++){
  
     for(int j=0;s1[j]!='\0';j++){
	    if(s1[j]==s2[i]){
		   return i;
		}
	 }
  }
  return -1;
}


int main(void){
  char s1[]="helloworld";
  char s2[]="y0o";
  printf("%d \n",any(s1,s2));
  return 0;
}











// ---------------------------------------------
/** 
 *
 *
 */



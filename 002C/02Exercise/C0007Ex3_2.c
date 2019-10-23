//---------------------------------------------- 
//  Date    :
//  By      :
//  Content :
//      将字符串t复制到字符串s中
//。    将转义字符显示出来
//----------------------------------------------
#include <stdio.h>

void escape(char s[], char t[]){
  int i,j;
  for(i=j=0;t[i]!='\0';i++){ 
    switch(t[i]){
	  case '\n': 
	    s[j++] = '\\';
        s[j++] = 'n';
		break;
	  case '\t':
		s[j++]='\\';
		s[j++]='t';
		break;
	  default:
		s[j++]=t[i];
		break;
	}
  }

  s[j]='\0'; 
  
}


void unescape(char s[], char t[]){

  int i, j;
  for(i=j=0;t[i]!='\0';i++){ 
    if(t[i]!='\\'){
	  s[j++] = t[i];
	}else{
	  switch(t[i]){
 	    case 'n': 
	      s[j++] = '\n';
          break;
	    case 't':
		  s[j++] = '\t';
          break;
      } 	
   }
  }

  s[j]='\0';
}


int main(void){
  char test1[]="abcd	defr";
  char test2[]={'0'};  
  escape(test2,test1);
  printf("%s \n",test2);
  return 0;
}






// ---------------------------------------------
/** 
 *
 *
 */



#include <stdio.h>

/* strlen: return length of s */
int sdx_strlen(char s[]){
  int i;

  while(s[i] != '\0'){
    ++i;
  }

  return i;
}

/* atoi: convert s to integer */
int sdx_atoi(char s[]){
  int i, n;
  n=0;

  for(i=0;s[i]>='0' && s[i]<='9';++i){
    n=10*n + (s[i]-'0');
	//s[i] - '0'  计算出s[i]中存储的字符所对应的数字值
    //因为'0'、'l'等在字符集中对应的数值是一个连续的递增序列 
  }
  return n;
}

/* lower: convert c to lower case; ASCII only */
int lower(int c){
  if(c>='A' && c<='Z'){
    return c + ('a'-'A');
  }else{
    return c;
  }
}
 
/* squeeze: delete all c from s */
void sdx_squeeze(char s[], int c){

	int i, j;
	for(i=j=0; s[i] != '\0'; i++){
	  if(s[i] != c){
	    s[j++] = s[i];
	  }
	}
	s[j]='\0';
}

/* strcat: concatenate t to end of s; s must be big enought */
void strcat(char s[], char t[]){
  int i,j;
  i=j=0;

  while(s[i]!='\0'){
    i++;
  } // find end of s

  while((s[i++]=t[j++]) != '\0') ; // copy t 
}




/* mian */
int main(){

 return 0; 
}
















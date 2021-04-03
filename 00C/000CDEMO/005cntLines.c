#include <stdio.h>

int main(){
  
  int c, cnt;
  cnt = 0;
  /* 
   *  单引号的字符表示一个整型值，该值等于此字符串在机器字符集中对应的数值
   *  小的整形数的另一种写法而已
   * */
  while((c=getchar()) != EOF){
    if(c == '\n'){
	  cnt++;
	}
	// space
	// \t
	// \n
  }

  printf("%d\n",cnt);
  return 0;
}

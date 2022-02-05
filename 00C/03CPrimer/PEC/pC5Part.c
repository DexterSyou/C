#include <stdio.h>
void report_count();
void accumulate(int k);

int count = 0;
int main(void){

   int value;
   register int i;//请求将i存储在一个寄存器内

   printf("Enter a positive integer(0 to qiut):");
   while(scanf("%d",&value)==1 && value > 0){
      ++count;
	  for(i=value;i>=0;i--)
		  accumulate(i);
	  printf("Enter a positive integer(0 to quit):");
   }
   report_count();
   return 0; 
}

void report_count(){
     printf("Loop executed %d times\n",count);
}
/* 存储类说明符：
 * auto  register  static  extern  typedef
 *
 *
 */

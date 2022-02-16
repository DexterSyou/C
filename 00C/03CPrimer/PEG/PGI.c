#include <stdio.h>
#include <stdarg.h>

double sum(int, ...);

int main(void){

  double s,t;
  s=sum(3,1.1,2.5,13.3);
  printf("return value for %f\n",s);
  return 0;
}

double sum(int lim, ...){
  
	va_list ap; //声明存放参数的变量ap
	double tot=0;
	int i;
	va_start(ap,lim); //把参数列表复制到va_list变量中
	for(i=0;i<lim;i++)
		tot += va_arg(ap,double);//第一次返回第一项，第二次返回第二项
	va_end(ap);//清理工作，释放内存
	return tot;
	//va_copy(apcopy,ap) apcopy为ap的一个副本 
}

#include <stdio.h>
#include <stdarg.h>

double sum (int,...);
int main(void){
  double s;

  s=sum(3,1.1,2.5,13.3);
  printf("return value is : %f",s);

}

double sum (int lim, ...){
   va_list ap;
   double tot = 0;
   int i;
   va_start(ap,lim);
   for(i = 0;i<lim;i++){
     tot += va_arg(ap,double);
   }

   va_end(ap);
   return tot;
}

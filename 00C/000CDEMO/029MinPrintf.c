#include <stdio.h>
#include <stdarg.h>

void minprintf(char *fmt, ...){

	va_list ap;
	char *p , *sval;
	int    ival;
	double dval;

	va_start(ap,fmt);
	for(p=fmt; *p; p++){
	  if(*p != '%'){
	    putchar(*p);
		continue;
	  }
	  switch (*++p){
	    case 'd':
			ival = va_arg(ap, int);
			printf("%d",ival);
		    break;
		case 'f':
			// ...
			break;
		case 's':
			// ...
			break;
		default:
			putchar(*p);
			break;
	  }
	}
    
    va_end(ap);
}



int main(void){
  int d = 100;
  minprintf("The value : %d \n", d);
  return 0;
}

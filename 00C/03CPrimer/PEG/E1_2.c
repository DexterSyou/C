#include <stdio.h>
#define TH(X,Y) (1/((1/(X)+1/(Y))/2))

double checkTH(double,double);

int main(void){

    double x=5,y=9;  
	printf("     TH(X,Y) = %f\n",TH(x,y));
	printf("checkTH(X,Y) = %f\n",checkTH(x,y));
	return 0;
}

double checkTH(double x,double y){
    double n = (1/x+1/y) / 2;
    double r = 1/n;  
	return r;
}

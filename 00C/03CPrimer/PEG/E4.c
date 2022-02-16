#include <stdio.h>
#include <time.h>

int main(void){

    double cs = clock();
	for(int i=0;i<999999;i++);
    double cd = clock();

	printf("clock %f\n",(CLOCKS_PER_SEC /(cd-cs)));
	printf("clock %f\n",(cd-cs)/CLOCKS_PER_SEC);
	return 0;
}

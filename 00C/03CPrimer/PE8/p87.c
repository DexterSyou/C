#include <stdio.h>
#include <stdbool.h>

int    get_int(void);
bool   bad_limits(int begin, int end, int low, int high);
double sum_squares(int a, int b);
int main(void){

   const int MIN = -1000;
   const int MAX = +1000;
   int start;
   int stop;
   double answer;

   printf("This program computes the sum of the squares of"
		  "integers in a range.\nThe lower bound should not"
		  "be less than -1000 and\n the upper bound should not"
		  "be more than +1000.\nEnter the limitsenter 0 for( "
		  "both limits to quit):\nlower limit: ");
   start = get_int();
   printf("upper limit: ");
   stop = get_int();
   while(start !=0 || stop !=0){
       if(bad_limits(start,stop,MIN,MAX)){
	      printf("Please try again.\n");
	   }else{
	      answer = sum_squares(start, stop);
	      printf("The sum of the squares of the integers from");
		  printf(" %d to %d is %g\n",start,stop,answer);
	   }
	   printf("Enter the limits(enter 0 for both limits to quit):\n");
	   printf("lower limit: ");
	   start = get_int();
       printf("upper limit: ");
	   stop  = get_int();
   }
   printf("Done.\n");
}

int get_int(void){

   int  input;
   char ch;

   while(scanf("%d",&input) !=1){
       while((ch=getchar())!='\n')
           putchar(ch);
	   printf(" is not an integr.\nPlease enter an ");
	   printf("integer value, such as 25,-178, or 3: ");
   }
   return input;
}

double sum_squares(int a, int b){
  
	double total = 0;
	int i;

	for(i=a;i<=b;i++){
	   total += i * i;
	}

	return total;
}

bool bad_limits(int begin, int end, int low, int high){

	bool not_good = false;
	if(begin > end){
       printf("%d isn's smaller than %d.\n",begin,end);
	   not_good = true;
	}
    if(begin<low || end < low){
       printf("Values must be %d or greater.\n",low);
       not_good = true;
    }
	if(begin > high || end > high){
	   printf("Values must be %d or less.\n",high);
	   not_good = true;
	}
    return not_good;
}
































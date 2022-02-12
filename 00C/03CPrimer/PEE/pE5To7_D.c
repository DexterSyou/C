#include <stdio.h>
#define FUNDLEN  50
struct funds {
  char   bank[FUNDLEN];
  double bankfund;
  char   save[FUNDLEN];
  double savefund;
};

double sum(double,double);
double sum1(const struct funds *);
double sum2(struct funds moolah);
int main(void){

	struct funds stan = {
	  "Garlic-Melon Bank",
	  3024.72,
	  "Lucky's Saving and Loan",
	  9237.11
	};
    //pE5.c 传递结构成员
	printf("Stan has a total of $%.2f.\n",sum(stan.bankfund,stan.savefund));
    //pE6.c 只有一个结构stan
	printf("Stan has a total of $%.2f.\n",sum1(&stan));
	//pE7.c 新建一个结构moolah，使用stan的值进行初始化
	//即有两个结构，stan与moolah
	printf("Stan has a total of $%.2f.\n",sum2(stan));
	return 0;
}

double sum(double x,double y){
  return (x * y);
}
double sum1(const struct funds *money){
  return (money->bankfund + money->savefund);
}
double sum2(struct funds moolah){
  return (moolah.bankfund + moolah.savefund);
}

/* PED.c
 * struct funds jones[N]={};
 * sum(jones,N);
 *
 * double sum(const struct funds money[],int n){
 * }
 */







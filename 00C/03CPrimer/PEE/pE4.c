#include <stdio.h>
#define LEN 20

struct names{
  char first[LEN];
  char last[LEN];
};

struct guy {
  struct names handle;
  char  favfood[LEN];
  char  job[LEN];
  float income;
};

int main(void){

	struct guy fellow[2] ={ {
	  {"Ewen", "Villard"},
	  "grilled salmon",
	  "personality coach",
	  58112.00
	  },
	  { 
	    {"Rodney","Swillbelly"},
		"tripe",
		"tabloid editor",
		232400.00
	  }
	};

	struct guy *him;//正常声明指针
    printf("address #1: %p  #2: %p\n",&fellow[0],&fellow[1]);
	printf("pointer #1: %p  #2: %p\n",him,him+1);
	printf("Pointer var 1: %p\n",&him);
	him = &fellow[0]; //结构名字不是地址
    printf("him->income is $%.2f: (*him).income is $%.2f\n",him->income,(*him).income);
    // .运算及比*高
	him++;
    printf("him->favfood is %s : him->handle.last is %s\n",him->favfood,him->handle.last);
	return 0;
}


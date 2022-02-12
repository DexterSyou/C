#include <stdio.h>
#define MAXTITL 41
#define MAXAUTL 31

struct book {
  char  title[MAXTITL];
  char  author[MAXAUTL];
  float value;
};

struct flex{
  int count;
  double average;
  double scores[];
};

int main(void){

  
 //C99
 struct book readfirst = (struct book) { "Crim and Punishment",
                                         "Fyodor Dostoyevsky",
                                          9.99
                                        };
 /*
  *function1((struct someone){value1,value2,...})
  *function2(&(struct sometwo){value1,value2,...})
  */

  struct flex *pf2 =malloc(sizeof(struct flex) + 9 *sizeof(double)); 
  struct flex *pf1 =malloc(sizeof(struct flex) + 5 * sizeof(double));
  free(pf1);
  free(pf2);
}

//PEC
/*
 * 伸缩性数组成员
 * struct flex {
 *   int count;
 *   double average;
 *   double scores[];
 * };
 * C99 希望声明一个指向struct flex的指针
 * 然后使用malloc来分配足够的空间，来存储常规内容与伸缩性数组
 * 成员需要的任何额外空间
 *
 * 如果声明一个struct flex类型的变量，不能使用scores
 *
 */

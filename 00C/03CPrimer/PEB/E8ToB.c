#include <stdio.h>
void menu(void);
int main(void){

  char ch;	  
  menu();
  while(scanf("%c",&ch) != 1){
    printf("Please enter number like 1 or 2 or q (0<num<8)");
  }

  while(ch != 'q'){
      printf("Your entered %c \n",ch);
	  menu();
  }

}

//EA.c
void menu(void){
  // char ch;
  // while(scanf("%c",&ch)==1){	
     printf("enter menu No.<eg. 1 or 2 or q ...>");	
	 puts("1.output init string.");
     puts("2.output the string by ascii.");
     puts("3.output the sorted string by string length.");
     puts("4.output init sorted string by first word length.");
     puts("5.E8 reverse your string");
     puts("6.E9 delete the string space");
     puts("7.E11 info the string <words, UPPER, lowwer, punctuation, characher>");
     puts("q ( to quit ).");
  // }
}

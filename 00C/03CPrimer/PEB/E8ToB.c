#include <stdio.h>
#include <string.h>
//
#define  ROWS   5
#define  COLS   81
//
void menu(void);
void excute(char ch, char str[][COLS]);
void m1InitStr(char str[][COLS]);
void showStr(const char str[][COLS]);
void comLenStr(const char *str[],int num);
int main(void){
  char str[ROWS][COLS];
  char ch;
  menu();
  printf("*Enter number 1 or 2 or q...(0<num<8) : ");
  scanf("%c",&ch);
  getchar(); //

  while(ch != 'q'){
     if( ch >= '1' && ch <='7'){
	    menu();
        excute(ch,str);
//        showStr(str);
	 }else{ 
	    printf("num %c error: \n", ch);
	 }
     printf("*Enter number 1 or 2 or q...(0<num<8) : ");
     scanf("%c",&ch);
     getchar(); //清除输入缓冲区的'\n'
  }
}

void excute(char ch, char str[][COLS]){
  switch(ch){
     case '1':
		 puts("***init the Str***");
		 m1InitStr(str);
         showStr(str);
		 break;
	 case '2':
		 puts("String by ASCII");
		 break;
	 case '3':
		 puts("***Sorted Str by length***");
         const char *pstr[ROWS];
		 for(int i=0;i<ROWS;i++){
		    pstr[i] = str[i];
		 }
		 comLenStr(pstr,ROWS);
		 for(int i=0;i<ROWS;i++)
             puts(pstr[i]);
         break;
	 default : break;
     
  }
}

//EA.c
void menu(void){ 
     puts("*----------------------------------------------------------------------");
	 puts("*\t1.output init string.");
     puts("*\t2.output the string by ascii.");
     puts("*\t3.output the sorted string by string length.");
     puts("*\t4.output init sorted string by first word length.");
     puts("*\t5.E8 reverse your string");
     puts("*\t6.E9 delete the string space");
     puts("*\t7.E11 info the string <words, UPPER, lowwer, punctuation, characher>");
     puts("*\tq ( to quit ).");
     puts("*----------------------------------------------------------------------");
}
//1.
void m1InitStr(char str[][COLS]){
 char *find;	
 for(int i=0;i<ROWS;i++){	
   printf("enter str%d:", i+1); 
   fgets(str[i],COLS,stdin);
   find=strchr(str[i],'\n');
   if(find)
	   *find = '\0';
 }
}
//2.
//void comAscii(){
// 利用strcmp函数
//}
//3.
void comLenStr(const char *str[],int num){
     const char *temp;
     int top, seek;
	 int ls1;
	 int ls2;
	 for(top=0;top<num-1;top++)
		 for(seek=top+1;seek<num;seek++){
		     ls1=strlen(str[top]);
			 ls2=strlen(str[seek]);
		     if(ls1 > ls2 ){
			    temp = str[top];
				str[top] = str[seek];
				str[seek] = temp;
			 } 
		 }
}
//4.
//
//
//E9.c
/*
 * while(*str1++ !='\0')
 *   if(*str1 != ' ')
 *      *str2++ = *str1;
 * return str2;
 */
//E11.c
/*
 *  toupper
 *  ispunct
 */
void showStr(const char str[][COLS]){
   for(int i=0;i<ROWS;i++)
	   puts(str[i]);
}


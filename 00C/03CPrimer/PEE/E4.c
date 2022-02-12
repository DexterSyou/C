#include <stdio.h>
#include <string.h>
#define SIZE 5
//
typedef struct person{
   char fname[10];
   char mname[10];
   char lname[10];
}PERSON;

typedef struct socail {
   int socaikId;
   PERSON person; 
} SCL;
//
void showByStruct(SCL scl[]);
void showByStructPoint(SCL *);
//
int main(void){
   
	SCL sclInfo[SIZE] = {
	  {1234567,{"Herry","Titi","Thierry"}},
	  {1256781,{"SHOW","SGHJ","GOOG"}},
	  {2314122,{"Jacky","JKLS","Chen"}},
	  {2133112,{"David","DaWei","Beckham"}},
	  {1210398,{"CCCC","","OK"}},
	};

	// 
    showByStruct(sclInfo);
	//
	puts("\nshow by struct pointer: ");
	showByStructPoint(sclInfo);
	return 0;
}
//
void showByStruct(SCL scl[]){
  char c;
  char m;
  for(int i=0;i<SIZE;i++){
     if(scl[i].person.mname[0]){
	    m = scl[i].person.mname[0];
		c = '.';
	 }
     printf("%s, %s  %c%c - %d\n",scl[i].person.fname,
			 scl[i].person.lname,m,c,scl[i].socaikId); 
     c=m='\0';
  }
}
//
void showByStructPoint(SCL *scl){
   for(int i=0;i<SIZE;i++,scl++){ 
     printf("%s, %s  %c. - %d\n",scl->person.fname,
			 scl->person.lname,scl->person.mname[0],scl->socaikId); 
   }
}



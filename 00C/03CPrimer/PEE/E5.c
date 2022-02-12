#include <stdio.h>
#include <stdbool.h>
#include <string.h>

//
#define NAME_SIZE 10
#define CSIZE     4 
//
struct nm {
  char fname[NAME_SIZE];
  char lname[NAME_SIZE];
};

struct student {
  struct nm name;
  double  grade[3];
  double  average;
};
//
void getScore(struct student *);
void showInfo(struct student *);
//
int main(void){
  
  struct student stus[CSIZE] = {
    {{"Jack","Liu"},},
	{{"David","Han"},},
	{{"Ansek","Peng"},},
	{{"Valeop","Si"},},
  };

  //d
  getScore(stus);

  //f
  showInfo(stus);
  return 0;
}

void getScore(struct student *ptr){
    char name[10];
	int sidx = 0;	
    double total=0;
	bool getscore=false;
	printf("Enter student name : ");
	scanf("%s",name);
	while(true){ 	   	
      //
	  if(!strcmp(name,(ptr+sidx)->name.fname)){
           getscore=true;
	  }else{
	       sidx++;
	  }
      //
	  if(getscore){
        for(int i=0;i<3;i++){
	      printf("Enter %s score %d: ",(ptr+sidx)->name.fname,i+1);
	      scanf("%lf",&(ptr+sidx)->grade[i]);
	      total+=(ptr+sidx)->grade[i];
	     }
		 //e,g
	     (ptr+sidx)->average = total /3;
		 //
		 while(getchar()!='\n'){
		    continue;
		 }
		 printf("Please enter student name: ");
		 scanf("%s",name);
		 getscore=false;
	  } 

      if(sidx==CSIZE){
	     break;
	  }
   }  
}

//
void showInfo(struct student * sptr){
	for(int i=0;i<CSIZE;i++){
	    printf("%s  %s ", sptr->name.fname,sptr->name.lname);
		printf("score:%f %f %f average:%f",
				sptr->grade[0],sptr->grade[1],sptr->grade[2],sptr->average); 
		sptr++;
		putchar('\n');
	}
}


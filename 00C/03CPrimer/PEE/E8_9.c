#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>
//
#define NAME_SIZE 10
#define SEAT_SIZE 12
//
typedef struct bookseat{
  int  seatNo;
  bool empty;
  char person[NAME_SIZE];
}BKSEAT;
//
static int stSeatNo[SEAT_SIZE]={0,0,0,0,0,0,0,0,0,0,0,0};
//
char menu(void);
void clearline(void);
void showTitle(void);
bool assignedSeated(int);
bool checkSeatNo(int);
void showEmptySeats(const BKSEAT *);
void showNotEmptySeats(const BKSEAT *);
void showAphaSeats(const BKSEAT *);
void assignCustomerSeat(BKSEAT *);
void deleteCustomerSeat(BKSEAT *);
//
int main(void){
  char choice;
  //6.a
  BKSEAT seats[SEAT_SIZE];
  //init the book seats
  for(int i=0;i<SEAT_SIZE;i++){
     seats[i].seatNo=i+1;
	 seats[i].empty=true;
	 strcpy(seats[i].person,"");
  }
  //6.d
  while((choice=menu())!='f'){
    switch (choice){
		case 'a':
			showEmptySeats(seats);
			break;	
		case 'b': 
			showNotEmptySeats(seats); 
			break;	
		case 'c': 
			showAphaSeats(seats);
			break;
		case 'd': 
			assignCustomerSeat(seats);
			break;
		case 'e': 
			deleteCustomerSeat(seats);
		    break; 
		case 'f': 
			puts("Bye Bye!!!");
			break;
	}
  }
  
}
//****************************************
//6.b
char menu(void){
   char ch;	
   printf("To choose a function, enter its letter label: \n");
   puts("a) Show list of empty seats ");
   puts("b) Show list of not empty seats ");
   puts("c) Show alphabetical list seats ");
   puts("d) Assign a customer to a seat assignment ");
   puts("e) Delete a seat assignment "); 
   puts("f) Quit");
   //获得选项
   ch=tolower(getchar());
   //清除输入缓冲区
   clearline();
   while(strchr("abcdef",ch)==NULL){
     puts("Please enter a,b,c,d,e or f ");
	 ch=tolower(getchar());
	 clearline();
   }
   return ch;
}

//6.c
void showEmptySeats(const BKSEAT *ptr){
	showTitle();
	for(int i=0;i<SEAT_SIZE;i++,ptr++){
	    if(ptr->empty){	
		   printf("[%d]\t[%s]\t[%s] \n",
				   ptr->seatNo,(ptr->empty?"no":"yes"),ptr->person);
		}
	}
}
//*****
void showNotEmptySeats(const BKSEAT *ptr){
	showTitle();
	for(int i=0;i<SEAT_SIZE;i++,ptr++){
	    if(!ptr->empty){	
		   printf("[%d]\t[%s]\t[%s] \n",
				   ptr->seatNo,(ptr->empty?"no":"yes"),ptr->person);
		}
	}
}
//*****
void showAphaSeats(const BKSEAT *ptr){
    const BKSEAT *temp;
    const BKSEAT *AphaSeat[SEAT_SIZE];
	int aphaIdx=0;
	for(int i=0;i<SEAT_SIZE;i++,ptr++){
	   if(!ptr->empty){
	     AphaSeat[aphaIdx] = ptr;
		 aphaIdx++;
	   }
	}
    // sorted by name
	for(int i=1;i<aphaIdx;i++)
		for(int j=i;j>0;j--){
		   if(strcmp(AphaSeat[j]->person,AphaSeat[j-1]->person) > 0 ){
		     temp =  AphaSeat[j];
			 AphaSeat[j] = AphaSeat[j-1];
			 AphaSeat[j-1] = temp;
		   }
	}
	for(int i=0;i<aphaIdx;i++){
	    if(!AphaSeat[i]->empty){	
		   printf("[%d]\t[%s]\t[%s] \n",
				   AphaSeat[i]->seatNo,(AphaSeat[i]->empty?"no":"yes"),AphaSeat[i]->person);
		}
	}
}
//*****
void assignCustomerSeat(BKSEAT *ptr){
	 int seatno=0;
     puts("******Choice the seat******\n");
	 printf("Please enter the number (1~12, q to quit): "); 
     while(scanf("%d",&seatno)==1){
       clearline();//  
	   if(!checkSeatNo(seatno)){
	      if(!assignedSeated(seatno)){
	        printf("The customer name: ");
	        scanf("%s",(ptr+seatno-1)->person);
		    (ptr+seatno-1)->empty=false;
		    stSeatNo[seatno-1]=1;
		    printf("Assigned Succeed!");
	      }
	   }
	   printf("Please enter another number: ");
	 }
}
//******
void deleteCustomerSeat(BKSEAT *ptr){
	 int seatno=0;
     puts("******Choice the seat******\n");
	 printf("Please enter the number (1~12, q to quit): ");  
     while(scanf("%d",&seatno)==1){
       clearline();//
	   if(assignedSeated(seatno)){
		  strcpy((ptr+seatno-1)->person,""); 
		  (ptr+seatno-1)->empty=true;
		  stSeatNo[seatno-1]=0;
		  printf("Delete Succeed!");
	   }else{  
	      printf("The seat is empty.can't delete.\n");
	   }
       printf("Please enter seat number: ");
	}
}
//****************************************************
void clearline(void){ 
   while(getchar()!='\n'){
     continue;
   }
}
void showTitle(void){
 puts("*********************************");
 puts("SEATNO\tEMPTY\tPERSON");
}

bool assignedSeated(int num){
  bool has=false;
  if(stSeatNo[num-1]){
    has = true;
	printf("The seat has assigned.\n");
  }
  return has;
}

bool checkSeatNo(int no){
   bool illegal = false;
   if(no>12 || no <1){
	 printf("The no is illegal.\n");
     illegal = true;
   }
   return illegal;
}





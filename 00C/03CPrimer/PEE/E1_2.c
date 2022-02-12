#include <stdio.h>
#include <string.h>
//
#define MONTH_NAME_SIZE 10
#define MONTH_ABBREV_SIZE 4
//
typedef struct dt {
  char monthName[MONTH_NAME_SIZE];
  char abbrev[MONTH_ABBREV_SIZE];
  int  monthNo;
  int  dyas; 
} DATE;

const char *months[12] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
//
int isLeap(int year);
int computeDays(DATE *ptr, int year,int month);
void toMonthNo(const char month[], int *ptr);

int main(void){
   
    DATE ms[12] = {
        {"January","Jan",1,31},
        {"February","Feb",2,28},
        {"March","Mar",3,31},
        {"April","Apr",4,30},
        {"May","May",5,31},
        {"June","Jun",6,30},
        {"July","Jul",7,31},
        {"August","Aug",8,31},
        {"September","Sep",9,30},
        {"October","Oct",10,31},
        {"November","Nov",11,30},
        {"December","Dec",12,31},
    };

    int year=0;
    char month[MONTH_NAME_SIZE];
    int monthNo=0;
    int day=0;
    printf("Please enter your year : ");
    scanf("%d",&year);
    printf("Please enter your month: ");
    scanf("%s",month);
    //
    toMonthNo(month,&monthNo);
    //
    printf("Please enter your day  : ");
    scanf("%d",&day);
   
    printf("Year:%d ,Month: %d , Days:%d\n",year,monthNo,day);
    printf("Total Days :  %d\n",    computeDays(ms,year,monthNo)+day);

    return 0;
}

void toMonthNo(const char month[], int *ptr){
    for(int i=0;i<12;i++)
      if((strcmp(month,months[i]))==0)
          *ptr = i;
}

int isLeap(int year){
    return ((year%4==0 && year%100!=0) || (year%400==0));
}

int computeDays(DATE *ptr, int year,int monthNo){
    int totaldays=0;
    for(int i=0;i<monthNo-1;i++){
       totaldays+=ptr[i].dyas;
    }
    printf("The year is leap : %d\n", isLeap(year));
    if(isLeap(year) && monthNo >=2){ 
          totaldays+=1;
    }
    return totaldays;
}

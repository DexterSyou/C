/*
*1.
  struct {
     char itable;
     int num[20];   
     char *togs;
  };


*2. 
  6 1
  22 Spiffo Road
  S p

*3,4,5.
  *****3 
  struct tdate{
     char mName[15];
     char abbrev[3];
     int  days;
     int  month;
  }; 
  *****4
  struct tdate m[12]={
   {"","",31,1},
   {},
   ...
   {}
  };
  *****5
  void computeDays(struct tdate *pm,int m){
      int totalDays=0;
      for(int i=1;i<m;i++){
          totalDays+=pm[i].days;
      }
  }

*6.  
   *****a
      LENS bigEye[10];
      bigEye[2].foclen = 500;
      bigEye[2].fstop = 2.0;
      strcpy(bigEye[2].brand,"Remarkatar");
   *****b C99
      LENS bigEye[10] = {[2]={500,2"Remarkatar""}};
*7.
 *****7.a 
   6
   Archuran
   cturan
 *****7.b
   pb->title.last
 *****7.c
   void show(struct bem * ptr){
       // ptr->title.first pte->title.last ptr->limbs  ptr->type
   }

*8.
  *****a
     willie.born
  *****b
     pt->born
  *****c
     &willie.born
  *****d
     &pt->born
  *****e
     willie.fname
     willie.lname
  *****f
     pt->fname
     pt->lname
  *****g
     willie.fname[2]
  *****h
     strlen(willie.fname) +  strlen(willie.lname)

*9. struct car { ... };　
*10. ... 
*11. enum choices {no,yes,maybe};
*12. char * (*fptr) (char *, char)
*13. typedef double (*pfun)(double,double)
     pfun pf[4]; 
*/

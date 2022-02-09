#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
//
#define  ARGC_NUM 4
#define  BUFSIZE  100
#define  STR_CMP_SIN  "nn"
//
//
int main(int argc, char *argv[]){
  // to asscume that is right (<ARGC_NUM)
  if(argc > ARGC_NUM){
      fprintf(stderr,"Usage : a.out filename1 filename2 true");
      exit(1);
  }
  //
  FILE *fpsrc1;
  FILE *fpsrc2;

  char src1[BUFSIZE];
  char src2[BUFSIZE];
  char *fpl1;
  char *fpl2;
  char *find;
  if((fpsrc1=fopen(argv[1],"r"))==NULL){
       fprintf(stderr,"Can't open %s file.\n",argv[1]);
       exit(3);  
  }   
  if((fpsrc2=fopen(argv[2],"r"))==NULL){
       fprintf(stderr,"Can't open %s file.\n",argv[2]);
       exit(3);  
  }

  while(true) {
    if((fpl1=fgets(src1,BUFSIZE,fpsrc1))!= NULL){
       if(!strcmp(argv[3], STR_CMP_SIN)){
            src1[strlen(src1)-1] = '\0'; 
       } 
       fputs(src1,stdout);
    } 
    
    if((fpl2=fgets(src2,BUFSIZE,fpsrc2)) != NULL){
       if(!strcmp(argv[3], STR_CMP_SIN)){
          src2[strlen(src2)-1] = '\0'; 
       } 
       fputs(src2,stdout); 
    } 

    if((!fpl1) && (!fpl2))
        break;
    else{
       if(!strcmp(argv[3], STR_CMP_SIN)){
          putchar('\n');
       }
    }
  }  
}

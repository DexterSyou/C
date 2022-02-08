#include <stdio.h>
#include <stdlib.h>

#define BUFSIZE 1024
int main(int argc, char *argv[]){

  if(argc != 3){
    printf("Usage a.out [source filename] [target filename]");
    exit(1);
  }
//E4.c 
  
//
  FILE * fsrc;
  FILE * ftar;
  size_t bytes;
  char temp[BUFSIZE];
  
  if((fsrc=fopen(argv[1],"r"))==NULL){
    fprintf(stderr,"Can't open the %s file.\n",argv[1]);
    exit(1);
  }

  if((ftar=fopen(argv[2],"w"))==NULL){ 
    fprintf(stderr,"Can't open the %s file.\n",argv[2]);
    exit(1);
  }
  while((bytes =fread(temp,sizeof(char),BUFSIZE,fsrc))>0){
    fwrite(temp,sizeof(char),bytes,ftar);		  
  }
//    
  return 0;
}

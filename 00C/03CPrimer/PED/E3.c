#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int main(void){

  char infile[10];
  char outfile[10];
  FILE *pfin;
  FILE *pfout;
  int  ch;

  printf("Please enter your input file : ");
  scanf("%s",infile);
  printf("Please enter your output file: ");
  scanf("%s",outfile);

  if((pfin=fopen(infile,"r")) == NULL){
     printf("Can't open the %s file.\n ",infile);
	 exit(1);
  }

  if((pfout=fopen(outfile,"w"))==NULL){
    printf("Can't open the %s file.\n",outfile);
	exit(1);
  }

  while((ch=fgetc(pfin)) != EOF)
    fputc(toupper(ch),pfout);

  printf("Writed. Bye!\n");
  return 0;
}


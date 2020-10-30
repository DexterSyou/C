#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define BUFSIZE 1024

int main(int args, char *argv[]){
  
  int buf_size=1024;
  buf_size = atoi(argv[1]);

  FILE *fi , *fo;
  char *file_o = "out.dat";
  char *file_i = "In.dat";

  size_t bytes;
  char temp[10];

  if((fi = fopen(file_i, "r")) == NULL){
     printf("Can't open %s \n",file_i);
	 exit(0);
  }

  if((fo = fopen(file_o,"w")) == NULL){
     printf("Can't open %s \n",file_o);
     exit(0);
  } 
  int i=0;
  char *token;
  char splitStr[6];
  while((bytes = fread(temp,sizeof(char),buf_size, fi))>0){
	  i=1;
	  strcpy(splitStr,temp);
      for(token=strtok(splitStr,",");token;token=strtok(NULL,","),i++)
	  {
	    printf("str[%d]: %s  ",i,token);
	  }	  

	  //printf("\n*-----------------------*\n");
	  //	  fwrite(temp,sizeof(char),buf_size,fo);
  }

  if(bytes == 0 ){
    printf("The in file end !!!!\n");
  }
  fclose(fo);
  fclose(fi);
  return 0;
}

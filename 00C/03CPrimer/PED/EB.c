#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define BUFSIZE 30
#define ARGC_LEAST_SIZE 3

int main(int argc, char *argv[]){
  
	if(argc != 3){
		printf("Usage: a.out string file.\n");
		exit(1);
	}

	char string[BUFSIZE];
	FILE *fp;
	if((fp=fopen(argv[2],"r"))==NULL){
	   printf("Can't open file.\n"); 
	}

	while(fgets(string,BUFSIZE,fp) != NULL){
	    if(strstr(string,argv[1])){
		  fputs(string,stdout);
		}
	}

	return 0;
}

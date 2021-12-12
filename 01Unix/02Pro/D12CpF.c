#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

#define BUFSIZE 4096

int main(void){

	int n;
	char buf[BUFSIZE];

	while((n=read(STDIN_FILENO,buf,BUFSIZE)) > 0){
	  if(write(STDOUT_FILENO,buf,n) != n)
		  printf("Write error");
	}

	if(n<0){
	  printf("Read error");
	}
	exit(0);
}

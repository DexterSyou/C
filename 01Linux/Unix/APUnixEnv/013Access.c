#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
//#include <fcntl.h>

int main(int argc, char *argv[]){
  if(argc != 2){
      printf("Usage : ./a.out filename \n");
	  exit(0);
  }

  if(access(argv[1], R_OK) < 0 ){
     printf("access error for %s \n", argv[1]);
  }else{
     printf("read access OK");
  } 
  //
  //
  exit(0);
}

/* 
 *  int access(const char *pathname, int mode);
 *  R_OK
 *  W_OK
 *  X_OK
 *  F_OK
 */

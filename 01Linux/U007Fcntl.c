#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>

int main(int argc, char *argv[]){
  int val;
  if(argc != 2){
     printf("Usage: a.out <descriptor#>");
  }

  if((val=fcntl(atoi(argv[1]),F_GETFL,0)) < 0){
     printf("fcntl error for fd %d", atoi(argv[1]));
  }

  switch (val & O_ACCMODE){
	  case O_RDONLY:
		  printf("Read only");
		  break;
	  case O_WRONLY:
		  printf("Write only");
		  break;
      case O_RDWR:
		  printf("Read and Write");
		  break;
	  default:
		  printf("Unknown access mode");
  }

  if(val & O_APPEND){
    printf(", append");
  }

  if(val & O_NONBLOCK){
    printf(",nonblocking");
  }
/*
#if defined(O_SYNC)
  if(val & O_SYNC)
	  printf(", synchronous writes");
#endif

#if !define(_POSIX_C_SOURCE) && define(O_FSYNC)
  if(val & O_FSYNC)
	  printf(", synchronous writes");
#endif
*/
  putchar('\n');
  exit(0);

}

#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>

int main(int argc, char *argv[]){

  int fd;	
  char buf[10];
  if(argc != 2){
    printf("Usage: a.out filename\n");
  }
  //open
  if((fd =open(argv[1] , O_RDONLY)) < 0){
    printf("%s open error\n", argv[1]);
    exit(1);
  }

  if(lseek(fd,0,SEEK_SET) == -1){
    printf("cannot seek \n");
	exit(1);
  }else{
    printf("seek OK \n");
  }
  
  if(read(fd,buf,10)<0){
    printf("read error \n");
	exit(1);
  }
  printf("The str : %s \n", buf);
  exit(0);
}

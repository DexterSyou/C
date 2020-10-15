#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>

char buf1[] = "abcdefghij";
char buf2[] = "ABCDEFGHIJ";

int main(void){

   int fd;

   if((fd=creat("file.hole",FILESEC_MODE))<0){
     printf("creat error");
   }

   if(write(fd,buf1,10) != 10){
     printf("buf1 write error");
   }

   if(lseek(fd,500,SEEK_SET) == -1){
	   printf("lseek error");
	}

   if(write(fd,buf2,10)!=10){
      printf("buf2 write error");
   }

   exit(0);
}

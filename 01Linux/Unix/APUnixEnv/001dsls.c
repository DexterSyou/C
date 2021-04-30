#include "./ApueHeader/dsapue.h"
#include <dirent.h>

int main(int argc, char *argv[]){

  DIR *dp;
  struct dirent *dirp;

  if(argc != 2){
     err_quit("Usage: ls directory_name");
  }

  if((dp = opendir(argv[1])) == NULL ){
     err_sys("can't open %s", argv[1]);
  }

  while((dirp = readdir(dp)) != NULL){
    printf("%s\n", dirp->d_name);
  }

  closedir(dp);
  exit(0);

}

/*
   opendir 函数返回指向DIR结构的指针
   readdir 来读每个目录项，目录项没有目录时，返回NULL指针
   exit(0) 正常结束程序
*/






#include "./ApueHeader/dsapue.h"
#include <sys/wait.h>

int main(void){
  
	char   buf[MAXLINE];
	pid_t  pid;
	int    status;
   
	printf("%% ");
	while(fgets(buf,MAXLINE,stdin) != NULL){
	  if(buf[strlen(buf)-1] == '\n'){
	    buf[strlen(buf)-1] = 0;
	  }

      if((pid = fork()) < 0){
	     err_sys("fork error");
	  }else if(pid == 0){
	     execlp(buf,buf,(char *)0);
		 err_ret("couldn't execute: %s", buf);
		 exit(127);
	  }

	  if((pid = waitpid(pid, &status, 0)) < 0){
	    err_sys("waitpid error");
	  }

	  printf("%% ");
	}

	exit(0);
}

/*
 * fork 创建一个新进程，新进程是调用进程的复制品
 * 调用进程   f
 * 创建的进程 s
 * 
 * fork向父进程返回新子进程的进程ID，对子进程则返回0
 * 创建一次，返回两次
 *
 *
 */





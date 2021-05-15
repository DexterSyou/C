//20210428  default header FILE
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//20210429 
#include <unistd.h> 
//20210506
#include <sys/stat.h>

//*******************************************
#define MAXLINE 4086
#define STDIN_FILENO 0
#define STDOUT_FILENO 1

//*******************************************
//20210428 errorOut
void err_quit(const char *, ...);
void err_exit(int, const char *,...);
void err_sys(const char *, ...);
void err_ret(const char *, ...);
void err_dump(const char *,...);

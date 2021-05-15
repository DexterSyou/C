#include "./ApueHeader/dsapue.h"
#include <errno.h>
#include <limits.h>


#ifdef PATH_MAX
static int pathmax = PATH_MAX
#else
static int pathmax = 0
#endif

#define SUSV3 200112L
#define long posix_version = 0

char * path_alloc(int *sizep){

   char *ptr;
   int  size;
   
   if(posix_version == 0){
     posix_version = sysconf(_SC_VERSION);
   }

   if(pathmax == 0)
	   errno = 0;

   if((pathmax = pathconf("/", _PC_PATH_MAX)) < 0){
      if(errno == 0){
	    pathmax = PATH_MAX_GUESS;
	  }else{
	    err_sys("pathconf error for _PC_PATH_MAX");
	  }   
   }else{
      pathmax++;
   }
   if(posix_version < SUSV3)
	   size = pathmax + 1;
   else
	   size = pathmax;
    
    if((ptr = malloc(size)) == NULL){
	   err_sys("malloc error for pathname");
	}

	if(sizep != NULL)
		*sizep = size;

	return (ptr);
}




/******************
 *  取得运行时限制
 *  #inlcude <unistd.h>
 *  long sysconf(int name)
 *  long pathconf(const char *pathname , int name)
 *  long fpathconf(int filedes, int name)
 *
 *  _SC_ 用作表示运行时限制sysconf参数
 *  _PC_ 用作标识运行时限制pathconf 和fpathconf 参数
 *
 *
 *  static 
 *   修饰变量
 *    局部变量，全局变量都存在内存的静态区
 *    静态全局变量，作用域仅限于变量被定义的文件中，从定义开始处到文件结尾
 *    静态局部变量
 *   修饰函数
 *    是指函数作用域只限于本文件
 *   
 *
 *
 */





#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>

/*  每个文件都有一个所有者 和 组所有者
 *  stat结构中st_uid , st_gid 
 *  st_mode 文件模式字
 *      设置用户ID位 S_ISUID
 *         将程序的有效用户ID 设置为 文件所有者的用户ID（st_uid）
 *       
 *         执行文件的进程的有效组ID 设置为 文件的组所有者ID(st_gid)
 *      设置组ID位  S_ISGID
 *
 *  进程的有效用户ID 必须 等于文件的所有者ID
 *  或者该进程具有超级用户权限
 *  int chmod(const char *pathname, mode_t mode) 成功返回0， 出错返回-1
 *
 *  进程相关联的ID
 *    实际用户ID
 *    实际组ID
 *       标示我们究竟是谁
 *       取自口令文件的登录项（在一个登录会话间并不改变） 
 *    有效用户ID （通常 等于实际用户ID）
 *    有效组ID   （通常 等于实际组ID）
 *    附加组ID
 *       决定了我们的文件访问权限
 *
 *    保存的设置用户ID
 *    保存的设置组ID 
 *       在执行一个程序时包含了有效用户ID 和 有效组ID 的副本
 */
int main(void){
  
  	
  if(chmod("File014bar", S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH) < 0){
     printf("chmod error for file ...\n");
  } 
  exit(0);
}

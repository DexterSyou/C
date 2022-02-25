#include "./../apue.h"

int main(void){

	printf("uid = %d, gid = %d\n",getuid(),getgid());
	exit(0);
/*
 * 每个用户有一个唯一的用户ID
 * ID：0 根用户
 * 
 * 组ID
 *    允许同组成员共享资源
 */
}

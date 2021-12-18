/*
 * 3.1
 *    不带缓冲I/O，指的是在用户的进程中对这两个函数不会自动缓冲
 *
 * 3.2 
 *    int dup(int filedes)
 *    由dup返回的新文件描述符 一定是当前可用文件描述符中的最小值
 *
 *    int dup2(int filedes, int filedes2)
 *    dup2可以用fileds2参数指定新描述符的数值
 *        如果filedes2已经打开，则先将其关闭
 *        如果filedes等于filedes，则dup2返回filedes2，而不关闭它。
 *        
 *    这些函数返回的新文件描述符与参数filedes共享同一个文件表项
 *
 *    int my_dup(int fd1, int newfd){
 *
 *        if(newfd < 0 ) printf("fd error msg");
 *        if(fd1 == newfd) return newfd;
 *
 *        close(newfd); 
 *        int tempfd;
 *        while(1){
 *            tempfd = dup(fd1);
 *            if(tempfd == newfd){
 *                return newfd; 
 *            }
 *        }
 *    }
 *
 *  3.3
 *      int fcntl(int filedes, int cmd, ...)
 *      F_SETFD --> fd1 
 *      F_SETFL --> fd1 fd2 
 *
 *  3.4     
 *
 *  3.5
 *  3.6 写文件只能从文件尾
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

## Unix

```
#*********1*********2*********3*********4*********5*********6*********7*********8*********9*********0
#1.Unix
#*********1*********2*********3*********4*********5*********6*********7*********8*********9*********0
#1.Unix
#1-1.Unix体系结构
       内核：控制计算机硬件资源，提供程序运行环境
   内核接口：系统调用
 公用函数库：构建在系统调用接口之上
      shell：一种特殊的应用，为运行其他应用程序提供了一个接口
  应用软件 ：即可以使用内核接口 ，也可以使用公用函数库

#
#1-2.文件 和 目录
     目录的起点 称为根，其名字是一个字符/。
	 / 用来分隔构成路径名
	 null 空操作符则用来终止一个路径名

#
#1-3.I/O
   文件描述符
	 file descriptor 内核用它标识一个特定进程正在访问的文件。当内核打开一个已有
	 或创建一个新文件时，它返回一个文件描述符,读写文件就可以使用它。
	   按照惯例，每当运行一个新程序，所有shell都为其打开三个文件描述符
	     标准输入 standard input
	     标准输出 standard output
	     标准出错 standard error
         一般，三个描述符都链向终端。

   不用缓冲的I/O
     open read write lseek close 这些函数都使用文件描述符
   标准I/O函数 提供一种对不用缓冲I/O函数的带缓冲的接口
#
#1-4.程序 进程
   程序，是存放在磁盘上，处于某个目录中的一个可执行文件。
   程序的执行实例 称为进程。
   UNIX 确保每一个进程都有一个唯一的ID，即进程ID
     getpid()
   
   进程控制exec函数
   一个进程 只有一个控制线程

#
#1-5.出错处理
#
#1-6.用户标识
    user ID
	0 为root用户ID
     getuid()
	组ID group ID
	 getgid()
#
#1-7.信号
	signal 是通知进程已发生某种情况的一种技术。
#
#1-8.时间值
	日历时间 time_t
	进程时间 clock_t
    
   度量一个进程的执行时间
	  时钟时间
      用户时间
	  系统时间
#
#1-9.系统调用 和 库函数
     2 操作系统多种服务的入口点，系统调用
     3 通用函数可能调用一个 或 多个内核的系统调用 
	   如printf 函数 会调用write系统调用
     
#Unix 标准化
  ISO C
  POSIX.1
  Single UNIX Specification  

#*********1*********2*********3*********4*********5*********6*********7*********8*********9*********0
#2.文件I/O
#*********1*********2*********3*********4*********5*********6*********7*********8*********9*********0
#不带缓冲是--> 每个read 和 write 都调用内核中的一个系统调用。

#2-1.文件描述符
    对于内核来讲，所有打开的文件都通过文件描述符引用。
	按照惯例，UNIX系统shell使用文件描述符0 与 进程的标准输入关联
	          1 与 进程的标准输出关联 ， 2 与 标准出错输出相关联

			  POSIX unistd.h中 
			    0 --> STDIN_FILENO
                1 --> STDOUT_FILENO
				2 --> STDERR_FILENO
#
# open函数可以打开或创建一个文件，返回值，
  若成功则返回文件描述符，若出错则返回-1
    #include <fcntl.h>
    int open(const char *pathname, int oflag, .../*mode_t mode */);
    多选项用或  进行构成oflag参数
    O_RDONLY
	O_WRONLY
	O_RDWR
	等等

# create 函数创建一个新文件
  若成功则返回为只写打开的文件描述符，出错则返回-1
   #include <fcntl.h>
   int creat(const char *pathname, mode_t mode);

# close 函数 关闭一个打开的文件
  #include <unistd.h>
  int close(int filedes);

# lseek 函数 每个打开的文件都有一个与其关联的 当前文件偏移量
  系统默认为0，成功，返回文件新的偏移量，出错返回-1，lseek中的l
  表示常整形。
    #include <unistd.h>
	off_t lseek(int filedes, off_t offset, int whence);
	 whence是SEEK_SET  距文件开始offset个字节
	         SEEK_CUR  文件偏移量的当前值加offset
			 SEEK_END  文件偏移量设置为文件长度加offset

# read 函数从打开文件中读取数据,成功返回读到的字节数，读到文件结尾返回0，出错返回-1
    #include <unistd.h>
	ssize_t read(int fileds, void *buf, size_t nbytes);
# write 函数 向打开的文件写数据,成功返回已写的字节数，出错则返回-1
	 #include <unistd.h>
	ssize_t write(int filedes, const void *buf, size_t nbytes);

# 原子操作
  pread ， pwrite  无法中断其定位 和 读操作
                   不更新新文件指针

# dup 和 dup2 函数，复制一个现存的文件描述符，成功返回新的fd，出错返回-1
   #include <unistd.h>
   int dup(int filedes) 返回当前文件描述符的最小值
   int dup2(int filedes, int filedes2) 
                        filedes2 参数可指定新描述符的值
                        filedes 已经打开，则先将其关闭，
						如果filedes等于filedes2，则返回filedes2，而不关闭它
   文件系统数据结构
     进程表  ：fd，文件指针
	 文件表  ：文件状态标志，当前文件偏移量，v节点指针 
     v节点表 ：v节点信息，i节点信息，当前文件长度

	 返回的新文件描述符 与 参数filedes共享同一个文件表项

#sync fsync fdatasync函数
    保证磁盘上实际文件系统与缓冲区高速缓存中内容的一致性
    #include <unistd.h>
    int fsync(int filedes) 函数只对由文件描述符fileds指定的单一文件起作用
    int fdatasync(int fileds)
	void sync(void)
	将所有修改过的块缓冲区排入写队列，然后返回

#fcntl函数 可以改变已打开的文件的性质
    #include <fcntl.h>
	int fcntl(int fileds, int cmd, ... /* int arg */);
    返回值，若成功则依赖于cmd，若出错则返回-l

	（1）复制一个现有的描述符        cmd=F_DUPFD cn
	（2）获得/设置文件描述符         cmd=F_GETFD    F_SETFD
	（3）获得/设置文件状态标志       cmd=F_GETFL    F_SETFL
	（4）获得/设置异步I/O所有权      cmd=F_GETOWN   F_SETOWN
	（5）获得/设置记录锁             cmd=F_GETLK    F_SETLK  F_SETLKW

#ioctl 函数
  #include <unistd.h>
  #include <sys/ioctl.h>
  #include <stropts.h>  
  int ioctl(int fileds, int request, ...) 
 
#/dev/fd
 打开文件/dev/fd/n 等效于 复制描述符n
 
#*********1*********2*********3*********4*********5*********6*********7*********8*********9*********0
# 文件 和 目录
#--------------------
#
#stat fstat lstat
 #include <sys/stat.h>
 int stat (const char *restrict pathname, struct stat *restrict buf)
  返回与pathname文件有关的信息结构
 int fstat (int filedes, struct stat *buf)
   获取已在描述符filedes上打开文件的有关信息
 int lstat (const char *restrict pathname, struct stat *restrict buf)
   与stat类似，当文件为一个符号链接时，返回该符号链接的有关信息
 以上三个函数成功返回0，若出错则返回-1，第二个参数buf指向一个必须提供的结构struct stat
#
#文件类型
 普通文件     regular file
              包含了某种形式的数据
 目录文件     directory file
              包含了其他文件名字 以及 指向与这些文件有关信息的指针。
 块特殊文件   block special file
              提供对设备带缓冲的访问，每次访问以固定长度为单位进行
 字符特殊文件 character special file
              提供对设备不带缓冲的访问，每次访问长度可变（系统所有设备要么是字符特殊文件，要么是块特殊文件）
 FIFO
              这种文件用于进程间的通信，named pipe
 套接字（socket）
              这种文件类型用于进程间的网络通信
 符号链接 symbolic link
              这种文件类型指向另一个文件。
	 文件类型信息包含在stat结构的st_mode成员中
     sys/stat.h 中的文件类型宏
	 S_ISREG()
	 S_ISDIR()
	 S_ISCHR()
	 S_ISBLK()
	 S_ISFIFO()
	 S_ISLNK()
	 S_ISSOCK()

# 用户ID  组ID  &  文件访问权限
  与一个进程相关联的ID有6个 或 更多
    实际用户ID
    实际组ID              
	   实际是谁，取自口令文件中的登录项，在一个登录会话间有这些并不改变，超级用户进程有方法改变它们
	 -----------------------------------------------
    有效用户ID
	有效组ID
	附加组ID   
	   用于文件访问权限检查
	 ---------------------------------------------
	保存的设置用户ID
	保存的设置组ID    
	   由exec 函数保存
     ---------------------------------------------
  当执行一个程序文件时，进程的有效用户ID 通常就是实际用户ID ，有效组ID通常就是实际组ID
  每个文件都有所有者 stat.st_uid ，组所有者stat.st_gid
  所有的文件类型都有访问权限
    9个访问权限位
	u        g        o 
    S_IRUSR  S_IRGRP  S_IROTH
	S_IWUSR  S_IWGRP  S_IWOTH
	S_IXUSR  S_IXGRP  S_IXOTH
  新文件和目录的所有权
    
	新文件的用户ID 设置为 进程的有效用户ID
	新文件的组ID 可以是 进程的有效组ID
    新文件的组ID 可以是 它所在目录的组ID
#############
# access 函数
    当open函数打开一个文件时，内核以进程的有效用户ID 和 有效组ID 为基础执行其访问权限测试。
    #include <unistd.h>
	int access (const char *pathname, int mode)
    按实际用户ID 和 实际组ID进行访问权限测试的，成功返回0，不成功返回-1
	R_OK
	W_OK
	X_OK
	F_OK 测试文件是否存在

  umask 函数
    为进程设置文件模式创建屏蔽字，并返回以前的值。
    #include <sys/stat.h>
	mode_t umask(mode_t cmask); 返回以前的文件模式创建屏蔽
	UNIX系统的大多数用户从不处理他们的umask值，通常登录时，由shell的启动文件设置一次，然后从不改变
  
  chmod函数 fchmod函数
    更改现有文件的访问权限
    #include <sys/stat.h>
	int chmod(const char *pathname, mode_t mode) 指定文件上进行操作
	int fchmod(int fileds, mode_t mode)          对已打开的文件进行操作
    成功则返回0，出错则返回-1
   chown
   fchown
   lchown
  
  文件长度
    对于普通文件
	    包含空洞（所设置的偏移量）超过文件尾端，并写了某些数据后造成的
	目录长度通常时是一个数16，512 的倍数
    符号链接，文件长度是文件名中的实际字节数
  文件揭短
  文件系统
    





#*********1*********2*********3*********4*********5*********6*********7*********8*********9*********0
#*********1*********2*********3*********4*********5*********6*********7*********8*********9*********0
#*********1*********2*********3*********4*********5*********6*********7*********8*********9*********0
#*********1*********2*********3*********4*********5*********6*********7*********8*********9*********0
#*********1*********2*********3*********4*********5*********6*********7*********8*********9*********0
#*********1*********2*********3*********4*********5*********6*********7*********8*********9*********0
#*********1*********2*********3*********4*********5*********6*********7*********8*********9*********0
#*********1*********2*********3*********4*********5*********6*********7*********8*********9*********0
#*********1*********2*********3*********4*********5*********6*********7*********8*********9*********0
#*********1*********2*********3*********4*********5*********6*********7*********8*********9*********0
#*********1*********2*********3*********4*********5*********6*********7*********8*********9*********0


```














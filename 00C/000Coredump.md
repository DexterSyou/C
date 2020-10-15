## Coredump

```

#########################
# coredump
core 文件会包含 程序运行时的内存，寄存器状态，堆栈指针，内存管理信息
还有各种函数调用堆栈信息

可以看到core文件配置的路径
cat /proc/sys/kernel/core_pattern

/proc/pid/limits 
 core的soft
 core的hard

#########################
#
ulimit -c unlimited
echo "/tmp/core-%e-%p" > /proc/sys/kernel/core_pattern
gcc -o main -g a.c
gdb main /tmp/core-main-10815 


```

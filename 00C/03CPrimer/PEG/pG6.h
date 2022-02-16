/*
这些内容是编译器用于产生可执行代码的信息
*/
#define SLEN 32

struct names_st{
   char first[SLEN];
   char last[SLEN];
};

typedef struct names_st names;

void get_names(names *);
void show_names(const names *);
/*
#define常量
宏函数

类型定义
结构模板定义
函数声明

外部变量声明
文件作用域内部链接const变量
*/

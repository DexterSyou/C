#include <stdio.h>

int main(void){
    char *mesg = "Don't be a fool!";
    char *copy;

	copy = mesg;
	printf("%s\n",copy);
	printf("mesg=%s; &mesg=%p; value=%p \n",mesg,&mesg,mesg);
	printf("copy=%s; &copy=%p; value=%p \n",copy,&copy,copy);
    // 指针的值value 是该指针中存放的地址
	// copy=mesg，所做的事即 复制字符串的地址
	return 0;
}

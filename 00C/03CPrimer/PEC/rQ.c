#include <stdio.h>

int main(){


	return 0;
}

/* 
 *  存储类 auto register staic extern
 * 1.  auto，register，static（静态空链接）
 * 2.  静态空链接（static），静态外部链接，静态内部链接（static）
 * 3.  静态外部链接 ，  静态内部链接static
 * 4.  空链接
 * 5.  声明一个已经定义的变量，告诉该作用域可以使用这个变量
 * 6.  malloc 分配的空间没有被置0
 *     calloc分配的空间被置为0
 * 7.  daisy，        file1的main，petal
 *                       file2的stem，root
 *     file1的lily，  file的main
 *     file2的lily    file2的stem，root
 *
 *     rose       ，  file1的main，petal
 *                    file2的stem，root
 *
 *     file1中extern int lily错误               
 * 8. color in main() is B
 *    color in first() is R
 *    color in main() is B
 *    color in second() is G
 *    color in main() is G
 * 9. plink不可被其他文件使用，保护arr中的数值
 *    不会
 *           
 */

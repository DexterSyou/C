#include <stdio.h>

int main(void){


	return 0;
}

/*
 * 1. fopen("gelatin","w");
 *    fputs参数位置调反了
 *    fclose(fp);
 * 2. 输出指定文件的digit字符
 * 3. ch = getc(fp1);
 *    fprintf(fp2,"%c\n",ch);
 *    putc(ch,fp2);
 *    fclose(fp1);
 * 6. 二进制文件和文本文件的不同在于两种文件格式对系统的依赖性不同
 *    二进制流和文本流之间的不同吧，读写流时执行的转换
 * 7.  a.fprintf 将8238201转换成字符串写入
 *       fwrite 使用该数值的二进制表示把它存为一个4字节的整数
 *
 *     b. 没有不同，都保存一个字节的二进制码
 * 8.  
 * 9.r+ 可以在文件中任何位置读写
 *   a+ 只能在末尾追加
 *   w+ 提供一个空文
 */

/*
 * EOF 表示读入 文本文件的结束符
 * feof（fp）用于测试所指向的文件的当前状态是否为 文件结束，是返回非0，否则返回0
 *
 *
 */

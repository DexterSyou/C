static unsigned long int next = 1;
int rand0(void){
   next = next * 1103515245 + 12345;
   return (unsigned int)(next/65536) % 32768;
}

int rand1(void){
   next = next * 1103515245 + 12345;
   return (unsigned int)(next/65536) % 32768;
}

void srand1(unsigned int seed){
   next = seed;
}
/*
 * 函数的存储类
 *   外部的（默认）：
 *          被其他文件使用
 *   静态的        ：
 *          只能在该文件中使用
 *   内联（C99）   ：
 */

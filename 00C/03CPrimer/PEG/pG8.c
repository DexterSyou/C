#include <stdio.h>
#include "pG6.h"
/*
   #include <>
   #include "" 根据编译器
   #include "path"
   包含头文件的内容是编译器产生最终代码所需要的信息
*/

int main(void){
    names candidate;
    get_names(&candidate);
    printf("Let's welcome ");
    show_names(&candidate); 
    printf("to this program!\n");
    return 0;
}

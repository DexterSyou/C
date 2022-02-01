#include <stdio.h>
#define SIZE 4
int main(void){
   
   int no_data[SIZE];
   // C90 标准整数常量，数组大小必须是大于0的整数
   // C99 允许变长数组  no_data[vla];
   int i;
   // 初始化之前元素的数值是不定的
   // 编译器使用的数值是存储单元中已有的数值
   printf("%2s%14s\n","i","no_data[i]");
   for(i=0;i<SIZE;i++){
	  // 数组索引不可超过数组的边界（编译器不检查索引的合法性）
	  // 借助数组的索引对数组成员进行赋值
	  // 
	  //
	  //
     printf("%2d%14d\n",i,no_data[i]);
   }
   /*
	* 初始化的元素数目应该和数组大小一致
	* int some_data[SIZE] = {1492, 1066}; 
	*    当数值数目少于数组元素数目时，多余数组元素被初始化为0
	*    如果初始化列表中项目个数大于数组大小，编译器认为这是一个错误
	*        可以const int days[] = {31,28,31,30,31,30,31,31,30,31} 
	*        编译器会根据列表中的数值数目来确定数组大小
	*        
	*        用sizeof(days) / sizeof(days[0])
	*/
	
	//
	/* C99 新特性，指定初始化项目
	 * int arr[6] = {[5]=212};
	 * int days[MONTHS] = {31,28,[4]=31,30,31,[1]=29}
	 *    指定初始化项目后跟有不止一个值，这些数值将用来对后续的数组元素初始化
	 *    days[4] = 31，--> days[5]=30， days[6]=31
	 *    多次对一个元素指定初始化，最后一次有效
	 *    即days[1]最终值为29
	 */
    return 0; 
}

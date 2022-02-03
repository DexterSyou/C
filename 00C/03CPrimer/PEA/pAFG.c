#include <stdio.h>
int main(void){

   int zippo[4][2] = {{2,4},{6,8},{1,3},{5,7}};
   /*
	*  zippo 是数组首元素地址，       &zippo[0]， 
	*  zippo[0]的值是其首元素的地址， &zippo[0][0]
	*  对一个指针取值，得到的是该指针所指向对象的数值
	*  zippo[0]是其zippo[0][0]的地址 
	*    *（zippo[0]）是zippo[0][0]中的数值
	*
	*  **zippo 等价于 *&zippo[0][0]
	*/
   int (*pz)[2]; 
   pz = zippo;
   /*  pz 指向包含两个int值的数组的指针
	*  int *pax[2] 表示pax是两个指针组成的数组，创建两个指向当个int值的指针
	*
	*/
   printf(" zippo=%p ,zippo+1=%p\n",zippo,zippo+1);
   printf(" zippo[0]=%p ,zippo[0]+1=%p\n",zippo[0],zippo[0]+1);
   printf(" *zippo=%p ,*zippo+1=%p\n",*zippo,*zippo+1); 
   printf(" zippo[0][0]=%d\n",zippo[0][0]);
   printf(" *zippo[0]=%d\n",*zippo[0]);
   //
   printf(" *pz[0]=%d\n",*pz[0]);
   /*
	* zippon[m][n] == *(*(zippo +m) +n)
	* pz[m][n]     == *(*(pz + m) +n)
	*
    */
   printf(" **zippo=%d\n",**zippo);
   printf(" zippo[2][1]=%d\n",zippo[2][1]);
   printf(" *(*(zippo+2)+1)=%d\n",*(*(zippo+2)+1)); 
   return 0;
}

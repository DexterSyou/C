#include <stdio.h>

int main(void){

  int urn[5] = {100,200,300,400,500};
  int *ptr1, *ptr2, ptr3;
  // 把一个地址赋给指针，地址与指针的类型应该相同
  ptr1 = urn;
  ptr2 = &urn[2]; 
  // 求值，运算符*可取出指针指向地址中的存储数值
  // 取指针地址 &pointer
  printf("Pointer value, dereferenced pointer, pointer address:\n");
  printf("ptr1=%p, *ptr1=%d, &ptr1=%p\n",ptr1,*ptr1,&ptr1);
  
  //指针加法
  ptr3 = ptr1 +4;
  printf("\n adding an int to a pointer;\n");
  printf("ptr1+4=%p, *(ptr4+3)=%d\n",ptr1+4, *(ptr1+3));
  ptr1++; 
  printf("\nvalues after ptr1++\n");
  printf("ptr1=%p, *ptr1=%d, &ptr1=%p\n",ptr1,*ptr1,&ptr1);
  //指针减法
  ptr2--;
  printf("\nvalues after --ptr2\n"); 
  printf("ptr2=%p, *ptr2=%d, &ptr2=%p\n",ptr2,*ptr2,&ptr2);

  --ptr1;
  ++ptr2;
  printf("\nPointers reset to original values:\n");
  printf("ptr1=%p, ptr2=%p\n",ptr1,ptr2);
  //求差值，
  //ptr2-ptr1 求出指针指向对象之间的2个int类型的数值，2不是字节数
  printf("\nsubtracting one pointer from another:\n");
  printf("ptr2=%p, ptr1=%p,ptr2-ptr1=%lu\n",ptr2,ptr1,ptr2-ptr1);

  printf("\nsubtracting one pointer from another:\n");
  printf("ptr3=%p,ptr3-2=%p\n",ptr3,ptr3-2);
  return 0;
}

/*
 * 当创建一个指针时，系统只分配了用来存储指针本身的内存空间
 *                   并不分配用来存储数据的内存空间
 *                   （int *p; *p=5; 🈲️）
 *
 *
 */



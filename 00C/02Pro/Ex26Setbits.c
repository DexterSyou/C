#include <stdio.h>

/*  p:3    n:2
 *  x >> (p+1-n) & ~(~0 << n)
 * idx:    ... 210
 *       1000 1110
 *       x >> 2
 *     
 *       0010 0011
 *     
 *      ~1111 1100
 *       0000 0011
 *
 *       0010 0011
 *       0000 0011
 *       0000 0011 
 *
 */
int main(){



}
//
// unsigned 大多数编译器认为unsigned int
// x 1110 1110
// y 0011 0001
// p : 3  n : 2
//
// 1100 1110
// 
unsigned getbits(unsigned x, int p, int n, int y){
   
   return x >> (p+1)
}


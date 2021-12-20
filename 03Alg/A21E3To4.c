//3. n个数的一个序列A=<a1,a2,a3...an> 和 v
// pseudcode
   
  for i=1 to n
    if A[i] == v
	  return i
  return NIL

 初始化 ： 循环第一次迭代之前，i=0，没有数据，v肯定不再其中为NIL
 保持   ： 其次每次迭代，如果没有找到，v为NIL，保持不变
 终止   ： 当A[i] = v 时，循环条件终止，返回下标i，v已经找到。查找终止
  
//4.两个n位二进数相加
//
   二进制整数只能由1和0组成
   二进制数相加按位相加
     运用异或性质实行二进制位的相加
	   A ^  B  =  C' ^ carry = C
       1    1  =  0
	   1    0  =  1
	   0    1  =  1
	   0    0  =  0
     注意进位如何判断进位
       carry 初始化0 
	   A   B  carry  --> carry
       1   1   1          1
       1   0   1          1
	   0   1   1          1
	   0   0   1          0
       1   1   0          1           
	   1   0   0          0 
	   0   1   0          0
	   0   0   0          0 
   最后的一个进位，存储在数组C的n+1中
// pseudcode
   carry=0
   for i=1 to n
     C[i] = (A[i] ^ B[i] ) ^ carry
	 if A[i] + B[i] +carry >= 2	
	    carry = 1
     else
		carry = 0
   C[n+1] = carry




//java.lang是默认导入到每个java文件中的，所以它的所有类都可以直接使用
import java.util.*;//import 指示编译器

class P1HelloDate{
  public static void main(String []args){

      System.out.println("Hello, it's : ");
      System.out.println(new Date());
  } 
}
/*
 *****
   基本数据类型   BYTE    bits    成员数据默认值
   boolean       -      -        false
   char          2      16       '\u0000'(null) 
   byte          1      8        byte(0)
   short         2      16       short(0)
   int           4      32       0 
   long          8      64       0L
   float         4      32       0.0f
   double        8      64       0.0d
   void          -      - 
 1.所有数值类型都是有符号的
 2.boolean所占存储空间的大小不确定，仅定义为能够存取字面值true和false
 3.BigInteger
   BigDecimal 
 4.char 无符号Unicode0~Unicode2^16-1   

 ***** 
  （对象）成员数据：
      会默认初始化
  （对象）成员方法：
      A.f() 向对象A发送f()消息
   类成员：
   类方法：
   自动变量：
*/

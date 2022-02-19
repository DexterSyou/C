import java.util.*;

public class P1Rock{
  /*
       构造器:
        1.与类名字相同
        2.创建对象时，为对象分配空间，并调用相应构造器，编译器的责任是调用构造器
          初始化期间，自动调用构造器
		3.没有任何返回值

     *** 
       java中定义和初始化概念不可分离，捆绑在一起
       C 则完全不同于java
     ***
  */
   Rock(){
    System.out.println("Creating Rock");
   }

   Rock(int i){
       System.out.println("Creating Rock number " +i);
   }
   
   
   public static void main(String[] args){
      int i;
      for(i=0;i<10;i++)
        new Rock();  // 分配相应的存储空间，并调用构造器，保证对象得到正确的初始化  
        new Rock(i);
      //
        new Bird(); //  默认构造器
      //  Bush()      //  如果已经定义一个构造器，编译程序都不会帮我们自动创建一个
   }
}


class Bird{
   int i;
}

class Bush{
    Bush(int i){}
    Bush(double d){}
}

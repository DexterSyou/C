class Soup1{
  private Soup1(){
  
  }

  public static Soup1 makeSoup(){
    return new Soup1();
  }

}

class Soup2{
  private Soup2(){
  
  }

  private static Soup2 ps1 = new Soup2();
  public static Soup2 access(){
    return ps1;
  }

  public void f(){}
}


class Lunch{
  
   void testPrivate(){
     //Can't do this! Private constructor
	 //! new Soup1()
   }

   void testStatic(){
     Soup1.makeSoup();
	 Soup2.access().f();
   }
}
public class P2Permission {
//Lunch

    public static void main(String []args){

      


    }

}

/* 
 * 类的访问权限：
 *    每个编译单元只有一个公共接口，一个public类
 *    public类名必须与相应的编译单元名相匹配
 *
 * 类的访问权限
 *     public
 *     包访问权限
 *
 * 私有化构造器是类不能被创建，可以通过静态方法被创建（单列模式）
 *
 */

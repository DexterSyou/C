import java.util.*;
public class P3class {
    public static void main(String []args){
    }
}
//******************************************************************
/* 类字面常量（在编译时会接受到检查）
 * 包装器类的TYPE字段指向对应的基本数据类型的Class对象
 *
 */
class Initable {
  static final int staticFinal = 47;
  static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
  static {
    System.out.println("Initializing Initable");
  }
}
class Initable2 {
  static int staticNonFinal = 147;
  static {
    System.out.println("Initializing Initable2");
  }
}
class Initable3 {
  static int staticNonFinal = 74;
  static {
    System.out.println("Initializing Initable3"); 
  }
}
class ClassInitialization {
  public static Random rand = new Random(47);
  public static void main(String[] args) throws Exception {
     Class initable = Initable.class;
	 System.out.println("After creating Initable ref");
     System.out.println(Initable.staticFinal);
     System.out.println(Initable.staticFinal2);
     System.out.println(Initable2.staticNonFinal);
	 Class initable3 = Class.forName("Initable3");
	 System.out.println("After creating Initable ref");
	 System.out.println(Initable3.staticNonFinal);
  }
}
//******************************************************************


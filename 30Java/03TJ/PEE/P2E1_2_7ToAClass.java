import java.util.*;
public class P2E1_2_7ToAClass{}
//************************************************************************ */
/* 类型信息在运行时，如何表示的 
   Class对象的特殊对象 包含了与类有关的信息: 
   Class对象就是用来创建类的所有的“常规”对象，java使用Class对象来执行RTTI。类是 程序的一部分，每个类都有一个Class对象。
   每当编写或编译了一个新类，就会产生一个Class对象（被保存在一个同名的.class文件中）。java虚拟机（JVM）将使用被称为“类加载器”的子系统生成这个类的对象。
   
   所有的类都是在对其第一次使用时，动态加载到JVM中的，当程序创建第一个对类的静态成员引用时，就会加载这个类。（构造器时静态的）
   类加载器首先检查这个类的Class对象是否已经加载。
   一旦某个类的Class对象被载入内存，它就被用来创建这个类的所有对象。
*/
//************************************************************************ */
class Candy {
    static { System.out.println("Loading Candy");}
}

class Gum {
    static { System.out.println("Loading Gum");}
}

class Cookie {
    static { System.out.println("Loading Cookie");}
}

class SweetShop {
    public static void main(String[] args){
        System.out.println("inside main");
        new Candy();
        System.out.println("After creating Cnady"); 
   
        try{
            //Class类（所有Class对象属于这个类）
			//取得Class对象引用
			Class.forName("Gum");
        }catch(ClassNotFoundException e){
           System.out.println("Couldn't find Gum");             
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");

    }
}
//************************************************************************ */
interface HasBatteries {}
interface Waterproof {}
interface Shoots {}
//E2
interface E2 {}
class Toy{
  //E1	
  Toy(){}
  Toy(int i){}
}
class FancyToy extends Toy implements E2,HasBatteries,Waterproof,Shoots { 
  FancyToy(){super(1);}
}

class ToyTest {
  static void printInfo(Class cc){
	//全限定类名 //isInterface 是否表示某个街口 
    System.out.println("Class name:    "+cc.getName() + "is interface? [" +cc.isInterface()+"]");
    //类名
	System.out.println("Simple name:   "+cc.getSimpleName());
	System.out.println("Canonical name:"+cc.getCanonicalName());
  }

  public static void main(String[] args){
    Class c = null;
	try{
	  c = Class.forName("FancyToy");
	  //创建Class引用，并将其初始化指向FancyToy的Class
	}catch(ClassNotFoundException e){
	  System.out.println("Can't find FancyToy");
	  System.exit(1);
	}
	printInfo(c);
	//返回Class对象，表示的是所包含的接口
	for(Class face : c.getInterfaces()){
	  printInfo(face);
	}
	//得到Class对象的直接基类，指向Toy对象
	Class up = c.getSuperclass();
	Object obj = null;
    try{
        //E1 Cannot instantiate
		//使用newInstance()来创建类，必须带有默认构造器
		obj = up.newInstance();
	}catch(InstantiationException e){
	   System.out.println("Cannot instantiate");
	   System.exit(1);
	}catch(IllegalAccessException e){
	   System.out.println("Cannot access");
	   System.exit(1);
	}
	printInfo(obj.getClass());//getClass获取Class引用
  }
}
//************************************************************************ */

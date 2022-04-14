
import java.util.*;
public class P2 {}
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
           Class.forName("Gum");
        }catch(ClassNotFoundException e){
           System.out.println("Couldn't find Gum");             
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");

    }
}

import java.util.*;

public class P5Init{
    public static void main(String [] args){
          //
          System.out.println("\n//初始化**************************************");          
          InitialValues iv = new InitialValues();
          iv.printInitialValues();
          new InitialValues().printInitialValues();
          // 
          System.out.println("\n//构造器初始化*********************************");          
          House h = new House();
          h.f();
          //
          System.out.println("\n//静态数据初始化********************************"); 
          System.out.println("Creating new Cuppoard() in main");   
          new Cupboard();      
          System.out.println("Creating new Cuppoard() in main");   
          new Cupboard();      
          table.f2(1);
          cupboard.f3(1);
    }
    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}
//初始化
class InitialValues{
    /*
     所有变量在使用前都能得到初始化
     局部变量：编译器以错误的形式来保证
     成员变量：采用默认初始值
    */ 
    boolean t;
    char c;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    InitialValues reference;
    //指定初始化，方法调用初始化
    //char x='c'; int i=f();
    void printInitialValues(){
          System.out.println("DataType       InitialValue");
          System.out.println("boolean        "+t);
          System.out.println("char            "+c);
          System.out.println("byte            "+b);
          System.out.println("short           "+s);
          System.out.println("int             "+i);
          System.out.println("long            "+l);
          System.out.println("float           "+f);
          System.out.println("double           "+d);
          System.out.println("reference       "+reference);
    }
}
//构造器初始化
class Window{

   Window(int marker){
       System.out.println( "Window("+marker+")" );
   }
}

class House{
    //
    int i;//自动初始化为0
    House(int x){
        //通过x付给i初始化
        this.i = x;
    }

    //变量定义的先后顺序决定了初始化的顺序，它们会在任何方法被调用之前得到初始化
    //包括构造器
    Window w1 = new Window(1);
    House(){
        System.out.println( "House" );
        w3=new Window(33);
    }
    Window w2 = new Window(2);
    void f() {System.out.println("f()");}
    Window w3 = new Window(3);
}
//静态数据初始化
/*
  静态数据都只占用一份存储区域，static关键字不能用于局部变量，它只能作用域
  基本类型默认为标准初值，对象引用默认初始值为null
*/
class Bowl{  
      Bowl(int marker){
          System.out.println("Bowl("+marker+")");
      }
       
      void f1(int marker){
          System.out.println("f1("+marker+")");
      }
}
//静态初始化只有在必要时刻才会进行，第一个静态对象创建，第一次访问静态数据
//初始化顺序是，先静态对象，后非静态对象
class Table {
    static Bowl bowl1 = new Bowl(1);
    Table(){
       System.out.println("Table()");
       bowl2.f1(1);
    }

    void f2(int marker){
        System.out.println("f2("+marker+")");
    }
    static Bowl bowl2 = new Bowl(2);
}

class Cupboard {
   Bowl bowl3 = new Bowl(3);
   static Bowl bowl4 = new Bowl(4);
   Cupboard(){
        System.out.println("Cupboard()");
        bowl4.f1(2);
   }
   void f3(int marker){
        System.out.println("f3("+marker+")");
   }
   static Bowl bowl5 = new Bowl(5);
}
import java.util.*;

public class Test{
    public static void main(String [] args){
          //
          System.out.println("\n//初始化**************************************");          
          InitialValues iv = new InitialValues();
          iv.printInitialValues();
          new InitialValues().printInitialValues();
          // 
          System.out.println("\n//构造器初始化*********************************");          
          House h = new House();
          h.f();
          //
          System.out.println("\n//静态数据初始化********************************"); 
/* 
  对象创建过程
  IF has a Dog class
  1.即使没有显示地使用static关键字，构造器实际也是静态方法
     首次创建Dog对象时或者Dog类的静态方法/静态域首次被访问时，java解释器必须查找类路径，以定位Dog.class
  2.载入Dog.class （将创建一个Class对象），有关静态初始化的所有动作都会执行, 静态初始化只在Class对象中首次加载的时候进行一次
  3.当new Dog() ，首先在堆上为Dog对象分配足够的存储空间
  4.这块存储空间会被清0，这就自动的将Dog对象中的基本数据类型设置成默认值，引用为null
  5.执行所有出现于字符按定义处的初始化动作
  6.执行构造器
*/
          System.out.println("Creating new Cuppoard() in main");   
          new Cupboard();      
          System.out.println("Creating new Cuppoard() in main");   
          new Cupboard();      
          table.f2(1);
          cupboard.f3(1);
    }
    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}
//初始化
class InitialValues{
    /*
     所有变量在使用前都能得到初始化
     局部变量：编译器以错误的形式来保证
     成员变量：采用默认初始值
    */ 
    boolean t;
    char c;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    InitialValues reference;
    //指定初始化，方法调用初始化
    //char x='c'; int i=f();
    void printInitialValues(){
          System.out.println("DataType       InitialValue");
          System.out.println("boolean        "+t);
          System.out.println("char            "+c);
          System.out.println("byte            "+b);
          System.out.println("short           "+s);
          System.out.println("int             "+i);
          System.out.println("long            "+l);
          System.out.println("float           "+f);
          System.out.println("double           "+d);
          System.out.println("reference       "+reference);
    }
}
//构造器初始化
class Window{

   Window(int marker){
       System.out.println( "Window("+marker+")" );
   }
}

class House{
    //
    int i;//自动初始化为0
    House(int x){
        //通过x付给i初始化
        this.i = x;
    }

    //变量定义的先后顺序决定了初始化的顺序，它们会在任何方法被调用之前得到初始化
    //包括构造器
    Window w1 = new Window(1);
    House(){
        System.out.println( "House" );
        w3=new Window(33);
    }
    Window w2 = new Window(2);
    void f() {System.out.println("f()");}
    Window w3 = new Window(3);
}
//静态数据初始化
/*
  静态数据都只占用一份存储区域，static关键字不能用于局部变量，它只能作用域
  基本类型默认为标准初值，对象引用默认初始值为null
*/
class Bowl{  
      Bowl(int marker){
          System.out.println("Bowl("+marker+")");
      }
       
      void f1(int marker){
          System.out.println("f1("+marker+")");
      }
}
//静态初始化只有在必要时刻才会进行，第一个静态对象创建，第一次访问静态数据
//初始化顺序是，先静态对象，后非静态对象

class Table {
    static Bowl bowl1 = new Bowl(1);
    Table(){
       System.out.println("Table()");
       bowl2.f1(1);
    }

    void f2(int marker){
        System.out.println("f2("+marker+")");
    }
    static Bowl bowl2 = new Bowl(2);
}

class Cupboard {
   Bowl bowl3 = new Bowl(3);
   static Bowl bowl4 = new Bowl(4);
   Cupboard(){
        System.out.println("Cupboard()");
        bowl4.f1(2);
   }
   void f3(int marker){
        System.out.println("f3("+marker+")");
   }
   static Bowl bowl5 = new Bowl(5);
}

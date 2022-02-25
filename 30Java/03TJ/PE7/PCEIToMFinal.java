import java.util.*;
public class PCEIToMFinal{

}

//Final property
class Value{
    int i;
    public Value(int i){this.i = i;}
}
class FinalData{
    private static Random rand = new Random(47);
    private String id;
    public FinalData(String id){this.id =id;}
    //Compile-time
    //带有恒定初始值,static
    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;
    public static final int VALUE_THREE = 39;
    //————————————————————————————
    //Cannot Compile-time
    //E18
    //static运行初始化时才展现区别，INT_5转载时已被初始化，不是每次创建对象初始化
    //final 域是跟着每次创建新对象时都初始化，static final域不是每次创建新对象时都初始化
    private final int i4 = rand.nextInt(20);
    static final int INT_5 = rand.nextInt(20);
    //————————————————————————————
    //引用成为常量
    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private static final Value VAL_3 = new Value(33);
    private final int[] a = {1, 2, 3, 4, 5, 6};

    public String toString(){
      return id + ": " + "i4 =" + i4 + ", INT_5 =" + INT_5;
    }

       /*
      **********************
      final数据
         1. 一个永远不变的编译时期常量 
            1 必须是基本数据类型， 有final，必须定义时进行初始化赋值
         2. 一个运行时被初始的值，不希望被改变
      **********************
      编译时执行计算，减轻运行时负担
         2.编译时期的static final域  只占据一段不能改变的存储空间
         3.final使基本数据恒定不变，使对象的引用恒定不变
   */
    public static void main(String[] args){  
      //Final property
      FinalData fd1 = new FinalData("fd1");
      //!fd1.valueOne++ //Error can't change value
      fd1.v2.i++;        //Object is not constant
      fd1.v1 = new Value(9); //OK
      for(int i=0;i<fd1.a.length;i++){
         fd1.a[i]++; //Object is not constant
      }
      //!fd1.v2 = new Value(0);
      //!fd1.VAL_3 = new Value(1);
      //!fd1.a = new int[3];
      System.out.println(fd1);
      System.out.println("Creating new FinalData");
      FinalData fd2 = new FinalData("fd2");
      System.out.println(fd1);
      System.out.println(fd2);
    }
}

//Final 空白
//声明final未给定初值的域，编译器确保空白final在使用前必须被初始化
//final域根据对象而有所不同
class Poppet{
    private int i;
    Poppet(int ii){i=ii;}
}

class BlankFinal{

    private final int i = 0;
    private final int j;
    private final Poppet p;
    //在域的定义出或构造器中对空白final域赋值
    public BlankFinal(){
        j=1;
        //E19
        p = new Poppet(1);
    }

    public BlankFinal(int x){
       j=x;
       p=new Poppet(x);
    }



    public static void main(String[] args){
      new BlankFinal();
      BlankFinal bf=new BlankFinal(47);
      //! bf.p = new Poppet(23);//无法为最终变量p分配值 
    }
}

//Final 参数
//无法在方法中更改引用所指向的对象
class Gizmo{
    public void spin(){}
}

class FinalArguments{
    void with(final Gizmo g){
        //!g=new Gizmo(); //Illegal -- g is final
    }

    void without(Gizmo g){
        g = new Gizmo();
        g.spin();
    }

    //!void f(final int i){i++;} 
    int g(final int i){return i+1;} //read only

    public static void main(String[] args){
        FinalArguments fa = new FinalArguments();
        fa.without(null);
        fa.with(null);
        fa.g(1);
    }
}

//Final METHOD
//处于设计考虑，防止任何类继承修改它的含义,确保继承中方法的行为保持不变，并且不会被覆盖
//效率(但禁止使用final优化，让编译器和JVM处理效率问题)
class WithFinals{

    private final void f(){System.out.println("WithFinals.f()");}
    // 所有的private方法都隐式地指定为是final
    private void g(){System.out.println("WithFinals.g()"); }
    //E21
    protected final void h(){System.out.println("WithFinals.g()"); }
}
class OverridingPrivate extends WithFinals{
    private final void f(){System.out.println("OverridingPrivate.f()");}
    // 所有的private方法都隐式地指定为是final
    private void g(){System.out.println("OverridingPrivate.g()"); }
    //E20 E21
    //@Override
    //OverridingPrivate中的h()无法覆盖WithFinals中的h()
    //protected final void h(){System.out.println("OverridingPrivate.g()"); }

}

class OverridingPrivate2 extends OverridingPrivate{
    public final void f(){System.out.println("OverridingPrivate2f()");}
    // 所有的private方法都隐式地指定为是final
    public void g(){System.out.println("OverridingPrivate2.g()"); }
}

class FinalOverridingIllusion{
    public static void main(String[] args){
        //覆盖 只有在某方法是基类的接口的一部分时才会出现
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        OverridingPrivate op = op2;
        //private方法为类对象自己部分，不属于接口的部分
        //!op.f();
        //!op.g();
        WithFinals wf = op2;
        //!wf.f();
        //!wf.g();
    }
}

//Final Class
class SmallBrain(){}

final class Dinosaur{
    int i = 7;
    int j = 1;
    SmallBrain x = new SmallBrain();
    void f(){}
}
//E22
//!class Further extends Dinosaur{}
//error: Cannot extends final class "Dinosaur"

class Jurassic{

    public static void main(String[] args){
       Dinosaur n = new Dinosaur();
       n.f();
       n.i = 40;
       n.j++;
       //final类的域可以是final或不是final
       //final类的方法不可以覆盖
    }
}

public class P1Com{

    public static void main(String[] args){
       //Composition
       SprinklerSystem sprinklers = new SprinklerSystem();
       System.out.println(sprinklers);
       //
       System.out.println("\n//Init************************************");
       Bath b = new Bath();
       System.out.println(b);
    }

}
//
class SprinklerSystem{
     private String value1, value2, value3, value4;
     private WaterSource source = new WaterSource();
     private int i;
     private float f;
     public String toString(){
         return 
         "value1 = " +value1 + " " +
         "value2 = " +value2 + " " +
         "value3 = " +value3 + " " +
         "value4 = " +value4 + "\n" +
         "i = " + i + " " + "f = " + " " +
         "source = " + source;
     }

}
class WaterSource{
    private String s;
    WaterSource(){
       System.out.println("WaterSource()");
       s = "Constructed";
    }

    public String toString(){
        return s;
    }
}

//
class Soap{

     private String s;
     Soap(){
      System.out.println("Soap()");
      s = "Constructed";
     }
     public String toString(){
          return s;
     }
}

class Bath{
    //1.Initializing at point of definition
    private String
    s1 = "Happy",
    s2 = "Happy",
    s3,s4;

    private Soap castille;
    private int i;
    private float toy;
    public Bath(){
      //2.
      System.out.println("Inside Constructor Bath()");
      s3 = "Joy";
      toy = 3.14f;
      castille = new Soap();
    }
    //3.Instance initialization
    {
        System.out.println("Instance initialization{ }");
        i = 47;
    }
    public String toString(){
        if(s4 == null) s4 = "Joy"; //4.Delayed initialization
        return 
         "s1 = " + s1 + "\n" +
         "s2 = " + s2 + "\n" +
         "s3 = " + s3 + "\n" +
         "s4 = " + s4 + "\n" +
         "i = " + i + "\n" +
         "toy = " + toy + "\n" +
         "castille = " + castille;
    }
}

/*
java初始化：
   所有变量在使用前都能得到恰当的初始化
   自动初始化在构造器调用之前发生
   实列初始化在构造器调用之前发生
   静态初始化只有在必要时刻才会进行
   初始化是先静态顺序，后非静态顺序
   数组在创建的时候初始化，可以出现任何地方

   1.载入.class对象时，静态初始化所有动作都会执行，所有的一起执行，只执行一次（静态成员属于类）
   2.为对象分配空间，自动的将对象中所有对象设置成默认值
   3.执行所有出现与定义字段的初始化动作
   4.执行构造器

*/

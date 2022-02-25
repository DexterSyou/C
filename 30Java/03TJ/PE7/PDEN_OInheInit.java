public class PDEN_OInheInit{

    public static void main(String[] args){
      System.out.println("Beetle Constructor.");
      Beetle b = new Beetle();
      /* 
        试图访问Beetle.main，加载器开始加载Beetle.class，发现extends继续加载Inserct.class
        开始执行static初始化，从基类开始一次类推到导出类

        至此必要的类都已加载完，可以创建对象了。
        首先将对象内存设为二进制0（对象中所有基本类型设为默认值，引用设为null）
        然后调用构造器(基类开始，导出类与基类一样相同顺序经历相同过程)
        实例变量开始初始化
      */
      System.out.println("\n-----------------------------------------\n");
      
      //E24 
      System.out.println("Firefly Constructor.");
      Firefly f = new Firefly();
      //E23
      /**因为Beetle b = new Beetle(); Insect 中与Beetle中的静态已经初始化过了
       ***!
       Firefly Constructor.
       static Firefly.x2 initilized  //!
       i = 9, j =0
       Beetle.k initialized
       k=47
       j=39
       Firefly.k initialized
       k=47
       j=39

       ***注释掉Beetle b = new Beetle()
       Firefly Constructor.
       static Insect.x1 initilized
       static Beetle.x2 initilized
       static Firefly.x2 initilized
       i = 9, j =0
       Beetle.k initialized
       k=47
       j=39 
       Firefly.k initialized
       k=47
       j=39
      */

    }
}
////////////////////////////
//.class只有在使用时才被加载（//创建第一个对象，访问静态域或静态方法）
//所有的static对象和static代码在加载时依程序中的顺序而依次初始化，只初始化一次
class Insect{
    private int i = 9;
    protected int j;
    Insect(){
        System.out.println("i = " + i +", j =" + j);
        j=39;
    }

    private static int x1 = printInit("static Insect.x1 initilized");

    static int printInit(String s){
       System.out.println(s);
       return 47;
    }
}

class Beetle extends Insect{

     private int k = printInit("Beetle.k initialized");
     public Beetle(){
        System.out.println("k=" +k);
        System.out.println("j=" +j);
     }

     private static int x2 = printInit("static Beetle.x2 initilized");

}

class Firefly extends Beetle {
     private int k = printInit("Firefly.k initialized");
     public Firefly(){
        System.out.println("k=" +k);
        System.out.println("j=" +j);
     }
     private static int x2 = printInit("static Firefly.x2 initilized");
}

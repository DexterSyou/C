public class PAEM_NWhyInnerCls{

    public static void main(String[] args){
     //E22   
       Sequence sequence = new Sequence(10);
       for(int i=0;i<10;i++){
           sequence.add(Integer.toString(i));
       }
       Selector selector = sequence.reverseSelector();
       while(!selector.end()){
           System.out.print(selector.current() + " ");
           selector.next();
       } 
     System.out.println("\n******************************************\n");   
    //E23   
     A[] as = {new A(),
               new A(),
               new A()}; 
     B b    =  new B(3);
     for(int i=0;i<as.length;i++){
        b.setUItems(as[i].makeU());
     }
     b.showItems();
     b.setItemsNull();
   }
}
//E22 EM
interface Selector{
    boolean end();
    Object current();
    void next();
}

class Sequence {
   private Object[] items;
   private int next = 0;
   private String str = "world.";
   public Sequence(int size){ items = new Object[size];}
   public void add(Object x){
      if(next < items.length){
          items[next++] = x;
      }
   }

   private class SequenceSelector implements Selector{
       private int i = items.length-1;
       public boolean end() { return i==-1;  }
       public Object current() { return items[i]; }
       public void next() { if(i>=0) i--; }
   }

   public Selector reverseSelector(){
       return new SequenceSelector();
   }
   // 
}
//E23 EN
interface U {
  void  umtd1();
  void  umtd2();
  void  umtd3();
}

class A {
    public U makeU(){
        return new U(){ 
          public void  umtd1(){ System.out.println("U method1");}
          public void  umtd2(){}
          public void  umtd3(){}
        };
    }
}

class B {
  U[] items;
  public B(int size){ items= new U[size];}
  private int i=0;
  public void setUItems(U u){
      if(i<items.length)
         items[i++] = u;
  }

  public void setItemsNull(){
      for(int i=0;i<items.length;i++){
          items[i] = null;
      }
  }

  public void showItems(){
      for(int i=0;i<items.length;i++){
          items[i].umtd1();
          items[i].umtd2();
          items[i].umtd3();
      }
  }
}
/*
interface A{}
interface B{}

class X implements A, B {}
class Y implements A {
    B makeB(){
        //Anonymous inner class
        return new B(){};
    }
}

class MultiInterfaces {

    static void takesA(A a){}
    static void takesB(B b){}

    public static void main(String[] args){
        X x = new X();
        Y y = new Y();
        takesA(x);
        takesA(y);
        takesB(x);
        takesB(y.makeB());
    }
}
//
//内部实现多继承（非接口）
class D{}
abstract class E{}
class Z extends D {
    E makeE(){ return new E(){};}
}

class MultiImplementation{
    static void takesD(D d){}
    static void takesE(E e){}
    public static void main(String[] args){
       Z z = new Z();
       takesD(z);
       takesE(z.makeE());
    }
}
*/
/*
内部类可以有多个实例
单个外围类内，可以让多个内部类以不同的方式实现同一个接口
内部类对象不依赖于外部类对象的创建
内部类独立的实体（not is-a）
*/

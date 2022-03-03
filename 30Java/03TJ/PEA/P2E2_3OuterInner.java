public class P2E2_3OuterInner {
   
   public static void main(String[] args){
       //P2
       Sequence sequence = new Sequence(10);
       for(int i=0;i<10;i++){
           sequence.add(Integer.toString(i));
       }
       Selector selector = sequence.selector();
       while(!selector.end()){
           System.out.print(selector.current() + " ");
           selector.next();
       }
       System.out.println("\n//******************************************   ");
       //E2
       Sequence e2Sequence = new Sequence(5);
       for(int i=0;i<5;i++){
           e2Sequence.add(new E2());
       }
       Selector e2selector = e2Sequence.selector();
       while(!e2selector.end()){
           System.out.print(e2selector.current() + " ");
           e2selector.next();
       }
       System.out.println("\n//******************************************   ");
       //E3
       Sequence e3Sequence = new Sequence(5);
       for(int i=0;i<5;i++){
           e3Sequence.add(e3Sequence.makeE3());
        }   
       Selector e3selector = e3Sequence.selector();
       while(!e3selector.end()){
           System.out.print(e3selector.current() + " ");
           e3selector.next();
       }
       System.out.println("\n//******************************************   ");
   }
}

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
       /*
         可以访问外围对象的所有成员（不需要任何特殊条件）
         内部类自动拥有对其外围类所有的成员的访问权
         内部类拥有还有其外围类的所有元素的访问权
       */
       /*
         当某个外围类的对象创建了一个内部了对象时，此内部类对象必定会捕获一个指向那个外围对象的引用
        */
       private int i = 0;
       public boolean end() { return i==items.length;  }
       public Object current() { return items[i]; }
       public void next() { if(i<items.length) i++; }
   }

   public Selector selector(){
       return new SequenceSelector();
   }
   // 
   class E3{
      public String toString(){ return str;}
   }

   public E3 makeE3(){
       return new E3();
   }
   //
}

//***********************************************************
//E2
class E2 {
    private String str = "hello.";
    public String toString(){ return str;}
}

public class P6AnonymousInner {

   public static void main(String[] args){
       //
       Parcel7 p7 = new Parcel7();
       Contents c = p7.contents();
       //
       Parcel8 p8 = new Parcel8();
       Wrapping w = p8.wrapping(10);
       //
       Parcel9 p9 = new Parcel9();
       Destination d9 = p9.destination("Tasmania"); 
       //
       Base base = AnonymousConstructor.getBase(47);
       base.f();
       //
       Parcel10 p10 = new Parcel10();
       Destination d10 = p10.destination("Tasmania",101.395F);
   }
}
//*************************************** */
interface Contents {
   int value();
}

interface Destination{
    String readLabel();
}

class Wrapping {
    private int i;
    public Wrapping(int x) { i=x; }
    public int value() { return i; }
}

abstract class Base {
    public Base(int i){
        System.out.println("Base constructor, i = " + i);
    }
    public abstract void f();
}

//*************************************** */

 class Parcel7 {
  
  public Contents contents(){
     return new Contents(){
        private int i = 11;
        public int value(){ return i;}
     };
     /*
         class MyContents implements Contents{
            ....
         }
         public Contents contents(){ return new MyContents(); }
     */
 }
}

class Parcel8 {

    public Wrapping wrapping(int x){
       return new Wrapping(x){
         public int value(){
           return super.value() * 47; 
         }
       };//表达式的结束，该表达式正巧包含了匿名内部类
    }
}

class Parcel9 {
    //使用外部定义对象时，编译器要求参数引用是final
    public Destination destination(final String dest){
        return new Destination() {
           private String label = dest;
           public String readLabel() { return label; }
        };
    }
}


class AnonymousConstructor {
   public static Base getBase(int i){
       return new Base(i){//i不在匿名类使用，在其基类使用
          {
              System.out.println("Inside instance initi ");
          }  
          public void f(){
              System.out.println("In anonymous f()");
          }
       };
   }
}

class Parcel10 {
    public Destination destination(final String dest, final float price){
       return new Destination(){
          private int cost;
          {
              cost = Math.round(price);
              if(cost > 100)
                  System.out.println("Over budget!");     
          }
            private String label = dest;
            public String readLabel() { return label;}
        };
    }
}

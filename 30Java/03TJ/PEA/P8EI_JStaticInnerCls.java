 public class P8EI_JStaticInnerCls{

    public static void main(String[] args){
         //
         Contents c = Parcel11.contents();
         Destination d = Parcel11.destination("Tasmania");
    }
}

/* 不需要内部类与其外围类之间有联系，那块、么可以将内部类声明为static（嵌套类）
   内部类          ：
       普通内部类对象隐式的保存了一个引用，指向创建它的外围类对象
   sataic（嵌套类） ：
       创建嵌套类的对象，并不需要其外围类的对象
       不能从嵌套类的对象中访问非静态的外围类对象 */
interface Destination {
  String readlabel();
}
interface Contents {
    int value();
}

class Parcel11 {
    //E18 EI 
    private static class ParcelContents implements Contents {
        private int i = 11;
        public int value(){ return i; }
    }
    protected static class ParcelDestination implements Destination{
        private String label;
        private ParcelDestination(String whereTo){
            label = whereTo;
        }
        public String readlabel() { return label;}
        public static void f(){}
        static int x = 10;
        static class AnotherLevel {
            public static void f(){}
            static int x = 10;
        }
    }

    public static Destination destination(String s){
        return new ParcelDestination(s);
    }

    public static Contents contents(){
        return new ParcelContents();
    }
}


//EJ
class EJ { //EJ.class
    class EJInner {//EJ$EJInner.class
        class EJInnerInner {} //EJ$EJInner$EJInnerInner.class
    }

    static class SEJInner { //EJ$SEJInner.class
        static class SEJInnerInner {} //EJ$SEJInner$SEJInnerInner.class
    }
}

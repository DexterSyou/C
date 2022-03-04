public class P9EK_LNestInIntefaceInnerClass{

    public static void main(String[] args){
    
    }
}

/*
  嵌套类置于接口的命名空间
  接口中任何类都是自动的public static
*/
//E20 EK
interface ClassInInterface{
    void howdy();
    class Test implements ClassInInterface{
        public void howdy(){
            System.out.println("Howdy!");
        }

        public static void main(String[] args){
            new Test().howdy();
        }
    }
}

//E21 EL
interface TestBed {
    void printStr();

    class Test implements TestBed{
         public void printStr(){
             System.out.println("Test TestBed.");
         };  
         static void callprint(TestBed tb){
             tb.printStr();
         }  

        public static void main(String[] args){
          TestBed tb= new Test();
          Test.callprint(tb);
        }
    }
}

//Nested class
class MNA {
    private void f(){}
    class A{
        private void g(){}
        public class B {
            void h(){
                g();
                f();
            }
        }
    }
//
/* 透明的访问所有嵌入的外围类的所有成员
 MNA mna = new MNA();
 MNA.A mnaa = mna.new A();
 MNA.A.B mnaab = mnaa.new B();
 mnaab.h();
*/
}

import java.io.*;
class PAEPHierarchies {}
//************************************************************ */
class Annoyance extends Exception {}
class Sneeze extends Annoyance {}

class Human {
    public static void main(String[] args){
        try{
            //
            //throw new Sneeze(); //警告: catch 子句无法访问
            throw new Annoyance();
        }catch(Sneeze s){
            System.out.println("Caught Sneeze");   
        }catch(Annoyance a){
            System.out.println("Caught Annoyance");
        }
    
        try{
           throw new Sneeze();
        }catch(Annoyance a){
           System.out.println("Caught Annoyance");
        } 
    }
}
//************************************************************ */
//EP E25
class E1 extends Exception {}
class E2 extends E1 {}
class E3 extends E2 {}

class E25A{
    void f() throws E1 { throw new E1(); }
}
class E25B extends E25A{
    void f() throws E2 { throw new E2(); }
}
class E25C extends E25B{
    void f() throws E3 { throw new E3(); }
}

class E25{
   public static void main(String[] args){
       E25A c = new E25C();
       try{
           c.f();
       }catch(Exception e){
           e.printStackTrace();
       }
   }
}
//************************************************************
class MainException  {
    //Pass all exceptions to the console
    //...
    public static void main(String[] args) throws Exception{

    }
}

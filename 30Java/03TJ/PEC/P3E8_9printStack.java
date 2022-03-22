class P3E8_9printStack{}
//************************************************************************************************************************ */
/* 异常声明 throws
*/
//
class E8 {
  public static void main(String[] args) throws Exception{
      try{
        String str = null;
        str.length();
      }catch(Exception e){
        //捕获所有异常，Exception所有异常类的基类
        /*
          Eception 可以调用从其基类Throwable继承的方法
          Str
         */  
        e.printStackTrace(); 
      } 
  }
}
//
class ExceptionMethods {

   public static void main(String[] args){
      try{
         throw new Exception("My Exception."); 
      }catch(Exception e){
         System.out.println("Caught Exception.");
         System.out.println("getMessage() : " + e.getMessage());
         System.out.println("getLocalizedMessage() : " + e.getLocalizedMessage());
         System.out.println("toString() : " + e);
         System.out.println("printStackTrace(): ");
         e.printStackTrace(System.out);
      }
   }
}
//
class E9E1 extends Exception {}
class E9E2 extends Exception {}
class E9E3 extends Exception {}

class E9{

   void f() throws E9E1{
       System.out.println("E9.f()");
       throw new E9E1();
   }

   public  static void main(String[] args){
       E9 e9 = new E9();
       try{
          e9.f();
       }catch(Exception e){
          e.printStackTrace();
       }
   }
}
//
/*
    栈轨迹printStackTrace所提供的信息可以通过getStackTrace方法来直接访问
    getStackTrace返回数组
          数组元素0是栈顶元素，最后一个方法调用
          数组中元素和栈底是调用第一个方法调用
*/
class WhoCalled {
    static void f(){
        try{
           throw new Exception();
        }catch(Exception e){
           for(StackTraceElement ste : e.getStackTrace()){
               System.out.println(ste.getMethodName());
           }
        }
    }
    static void g(){ f();}
    static void h(){ g();}
    public static void main(String[] args){
         f();
         System.out.println("------------------------------------");
         g();           
         System.out.println("------------------------------------");
         h();
    }
}
//
class Rethrowing {
    public static void f() throws Exception {
        System.out.println("originating the exception in f()");
        throw new Exception("thrown from f()"); 
    }
    public static void g() throws Exception {
        try{
           f();  
        }catch(Exception e){
           System.out.println("Inside g(), e.printStackTrace()");
           e.printStackTrace();
           throw e; 
        }
    }
    public static void h() throws Exception {
       try{
          f();
       }catch(Exception e){
          System.out.println("Inside h() , e.printStackTrace()");
          e.printStackTrace();
          throw (Exception)e.fillInStackTrace(); 
       }
    }
    public static void main(String[] args){
       try{
         g();
       }catch(Exception e){
          System.out.println("main: printStackTrace()");
          e.printStackTrace(System.out);
       }
       try{
         h();
       }catch(Exception e){
          System.out.println("main: printStackTrace()");
          e.printStackTrace(System.out);
       }
    }
}

//
class OneException extends Exception {
  public OneException(String s) { super(s); }
}

class TwoException extends Exception {
  public TwoException(String s) { super(s); }
}

class RethrowNew {

    public static void f() throws OneException {
      System.out.println("originating the exception in f()");
      throw new OneException("thrown from f() ");
    }

    public static void main(String[] args){
      try{
         try{
            f();
         }catch(OneException e){
            System.out.println("Caught in inner try, e.printStackTrace()");
            e.printStackTrace(System.out); 
            throw new TwoException("from inner try");
         } 
      }catch(TwoException e){
         System.out.println("Caught in outer try, e.printStackTrace()");
         e.printStackTrace(System.out); 
      }   
    }
}



import java.util.logging.*;
import java.io.*;
class P2E6_7LogException{}
//* **************************************************************
class LoggingException extends Exception {
    //创建一个String参数相关联的Logger对象
    private static Logger logger = Logger.getLogger("LoggingException");
    public LoggingException(){
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        //获取异常
        logger.severe(trace.toString());
    }
}

class LogginExceptions {

    public static void main(String[] args){
        try{
           throw new LoggingException();
        }catch(LoggingException e){
            System.err.println("Caught " + e);
        }
        try{
           throw new LoggingException();
        }catch(LoggingException e){
            System.err.println("Caught " + e);
        }
    }
}

class LogginExceptions2 {
    private static Logger logger = Logger.getLogger("LogginExceptions2");
    static void LogException(Exception e){
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public static void main(String[] args){
        try{
            throw new NullPointerException();
        }catch(NullPointerException e){
            LogException(e);
        }
    }
}

class MyException2 extends Exception{
     private int x;
     public MyException2(){}
     public MyException2(String msg){super(msg);}
     public MyException2(String msg, int x){
         super(msg);
         this.x = x;
     }

     public int val(){return x;}
     //覆盖Throwavle的getMesage方法，以产生更详细的信息，类似与toString()
     public String getMessage(){
         return "Detail Message: " + x + " " + super.getMessage();
     }
}

class ExtraFeatures { 
    public static void f() throws MyException2 {
        System.out.println("Throwing MyException2 from f()");
        throw new MyException2();
    }
    public static void g() throws MyException2 {
        System.out.println("Throwing MyException2 from g()");
        throw new MyException2("Originated in g()");
    }
    public static void h() throws MyException2 {
        System.out.println("Throwing MyException2 from h()");
        throw new MyException2("Originated in h()",47);
    }
    public static void main(String[] args){
       try{
          f();
       }catch(MyException2 e){
          e.printStackTrace(System.out);   
       }
       try{
          g();
       }catch(MyException2 e){
          e.printStackTrace(System.out);   
       }
       try{
          h();
       }catch(MyException2 e){
          e.printStackTrace(System.out);   
          System.out.println("e.val() = " + e.val());
       }
    }
}

//************************************************* */
//E6Cls1 E6Cls2
class E6Cls1 {
    private static Logger logger = Logger.getLogger("E6Cls1");
    static void logException(Exception e){
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
   
   public static void main(String[] args){
       try{
        throw new NullPointerException();
       }catch(NullPointerException e){
         logException(e);
       }
   }
}

//E7
class E7 {
    private static Logger logger = Logger.getLogger("E7");
    public static void main(String[] args){
        String[] test = new String[3];
        try{
            test[3] = "world";
        }catch(Exception e){
            StringWriter trace = new StringWriter();
            e.printStackTrace(new PrintWriter(trace));
            logger.severe(trace.toString());
        }
    }
}

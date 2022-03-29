import java.io.*;
class PBERToUWrapRunTimeException {}
//************************************************************ */
//E30
class WrapCheckedException {
    void throwRuntimeException(int type){
        try{
            switch(type){
                case 0  :  throw new FileNotFoundException();
                case 1  :  throw new IOException();
                case 2  :  throw new RuntimeException("Where am I");
                default :  return;
            }
        }catch(Exception e){
            throw new RuntimeException(e); //包装以上的异常
            //用运行时的异常来包装被检查时的异常
            //可以创建自己的RuntimeException的子类
        }
    }
}

class SomeOtherException extends Exception {}

class TurnOffChecking {
    public static void main(String[] args){
        WrapCheckedException wce = new WrapCheckedException();
        wce.throwRuntimeException(3);
        for(int i =0 ;i<4;i++){
            try{
                if(i < 3){
                   wce.throwRuntimeException(i);
                }else{
                   throw new SomeOtherException();
                }
            }catch(SomeOtherException e){
                System.out.println("SomeOtherException ： " + e);
            }catch(RuntimeException re){
                try{
                   throw re.getCause(); //把结果抛出来
                }catch(FileNotFoundException e){
                   System.out.println("FileNotFoundException ： " + e);
                 
                }catch(IOException e){
                   System.out.println("IOException ： " + e);
                }catch(Throwable e){
                   System.out.println("Throwable ： " + e);
                }
            }
        }
    }
}
//************************************************************ */
//ER  ES ET EU
//E27 28 29 30
class E27 {
    public static void main(String[] args){
          E27 []e27 = new E27[1];

          try{
              e27[1] = new E27();
          }catch(ArrayIndexOutOfBoundsException e){
             throw new RuntimeException(e);
          }
    }
}
class E28 extends RuntimeException{
     String s;
     E28(String s){
         super(s);
         this.s = s;
     }

     public static void main(String[] args){
         throw new E28("hello exception");
     }
}
//E29 RuntimeException 略
//




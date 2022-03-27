public class P1E1To5 {
    public static void main(String []args){

    }
}
//*******************************************
/*
 * 基本异常：
 *     
 * 抛出异常后有几件事随之发生：
 *  1.将使用new在堆上创建异常对象
 *  2.当前的执行路径被终止，并且从当前环境中弹出对异常对象的引用
 *  3.开始寻找一个恰当的地方来继续执行程序
 *   （异常处理程序：
 *       将程序从错误状态恢复，以使程序要么换一种方式运行，要么继续运行下去     
 *
 *    ）
 *
 *  异常参数：
 *    标准异常类有两个构造器，一个默认构造器，一个是接受字符串作为参数
 *   
 *    throw new NullPointerException("t=null") 
 *    new创建对象之后，此对象引用将传给throw  
 *   
 *    捕获异常
 *    try{
 *      
 *    }catch（）{
 *
 *    }
 *
 */
class SimpleException extends Exception {
 // 自定义异常类必须从已有的异常类继承
 // //让编译器产生默认构造器
}

class InheritingExceptions {
   public void f() throws SimpleException{
      System.out.println("Throw SimpleException from f()");
	  throw new SimpleException();
   }

   public static void main(String[] args){
     InheritingExceptions sed = new InheritingExceptions();
	 try{
	   sed.f();
	 }catch(SimpleException e){
	   System.out.println("Caught it!");
	 }
   }
}

//
class MyException extends Exception {
   public MyException(){}
   public MyException(String msg){ super(msg);}
}
class FullConstructors {

  public static void f() throws MyException {
    System.out.println("Throwing MyException from f()");
	throw new MyException();
  }	

  public static void g() throws MyException {
    System.out.println("Throwing MyException from g()");
	throw new MyException("Originated in g()");
  }

  public static void main(String[] args){
	//E1 
    try{
	  f();	
	}catch(MyException e){
	  e.printStackTrace(System.out);
	}finally{
	  System.out.println("f() try catch finally");
	}

    try{
	  g();
	}catch(MyException e){
      // Throwable类声明 printStackTrace 
	  // 打印从方法调用处直到异常抛出处的方法调用序列
	  e.printStackTrace(System.out);
	  // 被输出到标准错误流
	  e.printStackTrace();
	}
  }
}

//E2
class E2 {
 public void test(){}
}
class E2Driver {
  public static void main(String[] args){
     E2 e2 = null; 
	 try{
	   e2.test();
	 }catch(Exception e){
	   e.printStackTrace();
	 }
  }
}

//E3
class E3 {
 public static void main(String[] args){
  try{ 
   String[] str = new String[3];
   str[3] = "test";
  }catch(Exception e){
   e.printStackTrace();
  }
 }
}

//E4
class E4Exception extends Exception {
   private String str; 
   public E4Exception(String str){
       this.str = str; 
   }
   
   public void showStr(){
     System.out.println(str);
   }
}

class E4 {

  public static void fun() throws E4Exception{
     System.out.println("E4 fun()");
	 throw new E4Exception("Test My Exception");	
  }

  public static void main(String[] args){
    try{ 
	  fun();
	}catch(E4Exception e){
      e.showStr();
	  e.printStackTrace();
	}
  }
}

//E5

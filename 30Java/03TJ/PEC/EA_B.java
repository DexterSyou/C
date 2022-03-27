public class EA_B {

    public static void main(String []args){

    }

}
//*******************************************
class EAException extends Exception{}
class EAException2 extends Exception{}
class EA{
   //方法的定义上使用 throws 表示这个方法可能抛出某种异常
  public void f() throws Exception{
    try{
	  g();
	}catch(Exception e){
	  throw new EAException2();
	}
  }

  public void g() throws Exception{
    throw new EAException();
  }

  public static void main(String[] args){
      EA ea = new EA();
	  try{ 
	    ea.f();
	  }catch(Exception e){
	    e.printStackTrace();
	  }
  }
}

//
class EB {
  static void f() throws Exception{
    try{
	  g();
	}catch(RuntimeException e){
	  e.printStackTrace(System.out);
	  System.out.println("throw from f()");
	  throw new Exception("way of f()");
	}
  }
  
  static void g() throws RuntimeException{
     System.out.println("throw from g()");
     throw new RuntimeException("way of g()");
  }

  public static void main(String[] atgs) {
     try{
		 f();
	 }catch(Exception e){
        e.printStackTrace(System.out);	 
	 }
  }
}




import java.util.*;

public class P6Finally { }
//*******************************************
class ThreeException extends Exception { }
class FinallyWorks {
  static int count = 0;
  public static void main(String[] args){
     while(true){
       try{
	     if(count++ == 0)
			 throw new ThreeException();
		 System.out.println("No Exception");
	   }catch(ThreeException e){
	     System.out.println("ThreeException");
	   }finally{
	     System.out.println("In finally clause");
		 if(count == 2) break;
	   }  	 
	 }
  }
}

//
/*  当把除内存之外的资源恢复到它们的初始状态，就要用到finally子句 */
class Switch {
  private boolean state = false;
  public boolean read() { return state;}
  public void on()  { state=true;  System.out.println(this); }
  public void off() { state=false; System.out.println(this); }
  public String toString() { return state ? "on" : "off"; }
}

class OnOffException1 extends Exception {}
class OnOffException2 extends Exception {}

class OnOffSwitch {
  private static Switch sw = new Switch();
  public static void f() throws OnOffException1, OnOffException2 {}

  public static void main(String[] args){
     try{
	   sw.on();
		   f();
	  // sw.off();
	 }catch(OnOffException1 e){
	   System.out.println("OnOffException1");
	  // sw.off();
	 }catch(OnOffException2 e){
	   System.out.println("OnOffException2");
	  // sw.off();
	 }finally{
	   sw.off();
	 }
  }
}
//
class FourException extends Exception {}

class AlwaysFinally {
  
  public static void main(String[] args){
    System.out.println("Entering first try block");
	try{
	  System.out.println("Entering second try block");
	  try{
	    throw new FourException();
	  }finally{
		System.out.println("finally in 2nd try block");  
	  }
	}catch(FourException e){ 
	    System.out.println("Caught FourException in 1st try block");
        while(true){  
		   break;
		}
	}finally{ 
		System.out.println("finally in 1st try block");  
	} 
  }	
}
//**************************************************
//ED
class ED {
  static ED a = null;
  static void b(){
    a.toString();
  }

  public static void main(String[] args){
    try{
	  b();
	}catch(NullPointerException e){
	  e.printStackTrace(System.out);
	}finally{
	  System.out.println("finnally");
	}
  } 
}
//EE
//
class EE {
  private static Switch sw = new Switch();
  public static void f() throws OnOffException1, OnOffException2 {}

  public static void main(String[] args){
     try{
	   sw.on();
	   f();
//	   throw new RuntimeException();
//     error: unreachable statement
//	   sw.off();
	 }catch(OnOffException1 e){
	   System.out.println("OnOffException1");
	   sw.off();
	 }catch(OnOffException2 e){
	   System.out.println("OnOffException2");
	   sw.off();
	 }
  }
}
//EF
class EF {
  private static Switch sw = new Switch();
  public static void f() throws OnOffException1, OnOffException2 {}

  public static void main(String[] args){
     try{
	   sw.on();
	   f();
	   throw new RuntimeException();
	 }catch(OnOffException1 e){
	   System.out.println("OnOffException1");
	 }catch(OnOffException2 e){
	   System.out.println("OnOffException2");
	 }finally{
	   sw.off();
	 }
  }
}






















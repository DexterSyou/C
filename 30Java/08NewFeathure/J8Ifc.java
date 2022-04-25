public class J8Ifc {}
//********************************************
interface MyFun{
  default String getName(){
    return "HelloWorld!";
  }
}
interface MyIfc {
  default String getName(){
    return "Okokook.";
  }

  public static void show(){
    System.out.println("MyIfc....");
  }
} 
//类优先
class MyClass {
  String getName(){
    return "HowAreYou!!!";
  }
}

class SubCls /*extends MyClass*/ implements MyFun,MyIfc{
  
	public String getName(){
	  return MyIfc.super.getName();
	}
	public static void main(String[] args){
	   SubCls sub = new SubCls();
	   System.out.println(sub.getName());
	   MyIfc.show();
	}
}



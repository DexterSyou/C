public class E9ToB {

    public static void main(String []args){
       //
	   E9 e9 = new E9();
	   IE9 e9mhdInner = e9.method1();
	   e9mhdInner.printStr();
	   IE9 eaIfInner = e9.method2(true);
	   eaIfInner.printStr();
	   //
	   EB eb = new EB();
	   //!not a statement (EBInner)eb.from();
	   //
	}
}

//*******************************************
interface IE9 {
  void printStr();
}

class E9 {
  IE9 method1(){
    class E9Inner implements IE9{
	   public void printStr(){
	     System.out.println("E9.method1.E9Inner");
	   } 
	}
	return new E9Inner();
  }

 IE9 method2(boolean b){ 
    if(b){
   	   //EA
	   class EAInner implements IE9{
	      public void printStr(){
	         System.out.println("IE9.method2.if.EAInner");	  
		  }
	   }
	  return new EAInner();
	}
	return null;
    //!	return new EAInner(); //cannot find symbol
 }
// 
}

//
interface IEB{

}

class EB{
  
	private class EBInner implements IEB{
	
	} 

	public IEB from(){
	   return new EBInner();
	}
}




public class E9_AToC_E {

    public static void main(String []args){
    //9
    Rodent[] rdts = {
	   new Mouse(),
	   new Gerbil(),
	   new Hamster()
	};
	for(Rodent r : rdts){
	   //EE
		System.out.println(r);
        r.what();
	}
	//E10
	E10 e10 = new Ocls();
	e10.m1();
    }
}

//*******************************************
//E9_BC
class Rodent{

    public Rodent(){
	  System.out.println("Creating Rodent...");
	}
	public void what(){
	  System.out.println("Rodent...");
	}
}
class Mouse extends Rodent{
    
	public Mouse(){
	  System.out.println("Creating Mouse...");
	}
	public void what(){
	  System.out.println("Mouse...");
	}
}
class Gerbil extends Rodent{
    public Gerbil(){
	  System.out.println("Creating Gerbil...");
	}
	public void what(){
	  System.out.println("Gerbil...");
	}
}
class Hamster extends Rodent{
    //EE
	private static int refCount = 0;
   
    //
	public Hamster(){
      refCount++; 
	  System.out.println("Creating Hamster...");
	}
	public void what(){
	  System.out.println("Hamster...");
	}
    public String toString(){
      return "Creating Hamster Cnt: " + refCount;
	}
}

//E10
class E10{
   public void m1(){
      System.out.println("E10.m1() called E10.m2().");
      m2();
   }
   public void m2(){
      System.out.println("E10.m2()");
   }
}

class Ocls extends E10{
   public void m2(){
     System.out.println("Ocls.m2()");
   }
}


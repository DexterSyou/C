public class E9_A {

    public static void main(String []args){
    //9
    Rodent[] rdts = {
	   new Mouse(),
	   new Gerbil(),
	   new Hamster()
	};
	for(Rodent r : rdts)
        r.what();
	//E10
	E10 e10 = new Ocls();
	e10.m1();
    }
}

//*******************************************
//E9
class Rodent{
	public void what(){
	  System.out.println("Rodent...");
	}
}
class Mouse extends Rodent{
	public void what(){
	  System.out.println("Mouse...");
	}
}
class Gerbil extends Rodent{
	public void what(){
	  System.out.println("Gerbil...");
	}
}
class Hamster extends Rodent{
	public void what(){
	  System.out.println("Hamster...");
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


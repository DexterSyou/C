public class ED {

    public static void main(String []args){


      PrtMth p = new PrtMth();
	  p.pmethod(1);
	  p.pmethod(1.0f);
	  p.pmethod(1.0);
	  p.pmethod(true);

    }

}

class Prt{

  void pmethod(int i){
    System.out.println("Method Integer.");
  }

  void pmethod(float i){
    System.out.println("Method Float.");
  }

  void pmethod(double i){
    System.out.println("Method Double.");
  }
}

class PrtMth extends Prt{
  
  void pmethod(boolean b){
    System.out.println("Method Boolean.");
  }
}

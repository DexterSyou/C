public class PEOverridenInnerCls {

    public static void main(String []args){

    }

}

//*******************************************

class Egg {

  private Yolk y;
  protected class Yolk {
    public Yolk(){ System.out.println("Egg.Yolk()");} 
  }
  public Egg(){
    System.out.println("New Egg()");
	y = new Yolk();
  }
}

class BigEgg extends Egg {
    
   public class Yolk {
     public Yolk() { System.out.println("BigEgg().Yolk()");} 
   }	
  
   public static void main(String[] args){
     new BigEgg();
   }
}

class Egg2 {
  protected class Yolk {
    public Yolk() { System.out.println("Egg2.Yolk()");}
    public void f(){ System.out.println("Egg2.Yolk.f()");}
  }

  private Yolk y = new Yolk();
  public Egg2() { System.out.println("New Egg2()");}
  public void insertYolk(Yolk yy){ y = yy;}
  public void g() { y.f(); } 
}

class BigEgg2 extends Egg2 {
  public class Yolk extends Egg2.Yolk {
    public Yolk() { System.out.println("BigEgg2.Yolk()");}
	public void f(){ System.out.println("BigEgg2.Yolk.f()");}
  }

  public BigEgg2() { insertYolk(new Yolk());}
  public static void main(String[] args){
    Egg2 e2 = new BigEgg2();
	e2.g();
  }
}










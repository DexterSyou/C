
class Mug{

  Mug(int marker){
    System.out.println("Mug(" + marker + ")");
  }

  void f(int marker){
    System.out.println("f(" + marker + ")");
  }
}

public class P6Mugs{
   Mug mug1;
   Mug mug2;
   {
     mug1 = new Mug(1);
	 mug2 = new Mug(2);
     System.out.println("mug1 & mug2 initialized");
   }

   P6Mugs(){
     System.out.println("Mugs()");
   }
  
   P6Mugs(int i){
     System.out.println("Mugs(int)");
   }

   public static void main(String[] args){
      System.out.println("Inside main()");
	  new P6Mugs();
	  System.out.println("new Mugs() completed");
      new P6Mugs(1);
	  System.out.println("new Mugs(1) completed");
   }
}

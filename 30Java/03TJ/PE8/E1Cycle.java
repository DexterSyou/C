public class E1Cycle {

   public static void run(Cycle c){
       c.ride();
   }

   public static void main(String []args){
            run(new Unicycle());
			run(new Bicycle());
            run(new Tricycle());
   }
}

class Cycle {

   public void ride(){
      System.out.println("E1Cycle.ride()...");   
   }
}

class Unicycle extends Cycle{

   public void ride(){
      System.out.println("Unicycle.ride()...");
   }
}

class Bicycle extends Cycle{

   public void ride(){
      System.out.println("Bicycle.ride()...");
   }
}

class Tricycle extends Cycle{
    
   public void ride(){
      System.out.println("Tricycle.ride()...");    
   }
}





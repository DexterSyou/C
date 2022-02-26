public class E5Cycle {

   	
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
   public void wheels(){ 
   }

   public void ride(){
	  wheels(); 
      System.out.println("E1Cycle.ride()...");   
   }
}

class Unicycle extends Cycle{
   public void wheels(){
     System.out.println("One wheels.");
   }
   public void ride(){
	  wheels();  
      System.out.println("Unicycle.ride()...");
   }
}

class Bicycle extends Cycle{

   public void wheels(){
      System.out.println("Two Bicycle.");
   }	
   public void ride(){
	  wheels(); 
      System.out.println("Bicycle.ride()...");
   }
}

class Tricycle extends Cycle{
   public void wheels(){
      System.out.println("Three Tricycle."); 
   } 
   public void ride(){
	  wheels();  
      System.out.println("Tricycle.ride()...");    
   }
}





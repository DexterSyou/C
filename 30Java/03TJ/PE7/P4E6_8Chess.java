public class P4E6_8Chess extends BoardGame{
    
	P4E6_8Chess(){
    //E6
    //System.out.println();	
	  super(11);//调用基类构造器必须是第一件事
	            // call to super must be first statement in constructor
	  System.out.println("Chess Constructor.");
	} 
    public static void main(String []args){
       new P4E6_8Chess();
    }
}

class Game{
   Game(int i){
     System.out.println("Game Constructer. ");
   }
}

class BoardGame extends Game{
  //E8 
  BoardGame(){
	 super(1);
     System.out.println("BoardGame Default Constructor.");
   }
   BoardGame(int i){
	   super(i);
	   System.out.println("BoardGame Constructor");
   }
}

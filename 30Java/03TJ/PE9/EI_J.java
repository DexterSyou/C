public class EI_J {
//E18
    public static void makeCycle(Factory f){
	   f.getCycle(); 
	}
    public static void main(String []args){
         //E18
		 makeCycle(new UnicycleFactory());
    }

}
//*******************************************
interface Cycle {

}

interface Factory{
  Cycle getCycle();
}
//
class Unicycle implements Cycle {
  public Unicycle(){
    System.out.println("Unicycle ");
  }
}

class UnicycleFactory implements Factory{
  public Cycle getCycle(){
    System.out.println("Greating Unicycle");
	return new Unicycle();
  }
}
//...
//Bicycle
//Tricycle
//

//E19
//*******************************************
interface Game{

}

interface GameFactory {
   Game getGame();
}
class Coin implements Game{}

class CoinFactory implements GameFactory{
   public Game getGame(){
      return new Coin(); 
   }
}

class Dice implements Game{}

class DiceFactory implements GameFactory{
   public Game getGame(){
     return new Dice();
   }   
}



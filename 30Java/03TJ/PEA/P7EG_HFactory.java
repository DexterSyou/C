public class P7EG_HFactory {
    //
	 public static void serviceConsumer(ServiceFactory fact){
	  Service s = fact.getService();
	  s.method1();
	  s.method2();
	 }
    //
	 public static void playGame(GameFactory factory){
	  Game s = factory.getGame();
	  while(s.move());
	 }
    //
     public static void runCycle(CycleFactory factory){
	  Cycle c = factory.getCycle();
	  c.move();
	 }
    
     public static void main(String []args){
     //
      serviceConsumer(Implementation1.factory);
	  serviceConsumer(Implementation2.factory);
     //
       playGame(Checkers.factory);
	   playGame(Chess.factory);
     //
       runCycle(Unicycle.factory);
       runCycle(Bicycle.factory);
       runCycle(Tricycle.factory);

     }
}

//*******************************************
interface Service {
  void method1();
  void method2();
}

interface ServiceFactory {
  Service getService();
}



class Implementation1 implements Service {
  private Implementation1() {} 
  public void method1(){
    System.out.println("Implementation1 method1");
  }
  public void method2(){
    System.out.println("Implementation1 method2");
  }

  public static ServiceFactory factory = new ServiceFactory(){
      public Service getService(){
          return new Implementation1();
      }
  };
}

class Implementation2 implements Service{
   private Implementation2(){}
   public void method1(){
    System.out.println("Implementation2 method1");
   }
   public void method2(){
    System.out.println("Implementation2 method2");
   }

   public static ServiceFactory factory = new ServiceFactory(){
      public Service getService(){
          return new Implementation2();
      }
   };
}

//********************************************* */
interface Game { boolean move(); }
interface GameFactory { Game getGame(); }

//*******************************************
class Checkers implements Game {
   private Checkers(){};
   private int moves = 0;
   private static final int MOVES = 3;

   public boolean move(){
     System.out.println("Checkers move " + moves);
     return ++moves != MOVES;
   }

   public static GameFactory factory = new GameFactory(){
     public Game getGame(){ return new Checkers(); }
   };
}


class Chess implements Game {
  private Chess(){}
  private int moves = 0;
  private static final int MOVES = 4;
  public boolean move(){
    System.out.println("Chess move " + moves);  
    return ++moves!=MOVES;
  }

  public static GameFactory factory = new GameFactory(){
     public Game getGame(){ return new Chess(); }
  };
}

//*******************************************
//E16 EG
interface Cycle { void move(); }
interface CycleFactory { Cycle getCycle(); }

class Unicycle implements Cycle{
    private Unicycle(){}
    public void move(){
        System.out.println("Unicycle moving...");
    }
    public static CycleFactory factory = new CycleFactory(){
     public Cycle getCycle(){ return new Unicycle(); }
    };
}

class Bicycle implements Cycle{
    private Bicycle(){}
    public void move(){
        System.out.println("Bicycle moving...");
    }
    public static CycleFactory factory = new CycleFactory(){
     public Cycle getCycle(){ return new Bicycle(); }
    };
}

class Tricycle implements Cycle{
    private Tricycle(){}
    public void move(){
        System.out.println("Tricycle moving...");
    }
    public static CycleFactory factory = new CycleFactory(){
        public Cycle getCycle(){ return new Tricycle(); }
    };     
}
//E17 EH  如上


public class P5Proxy {

    public static void main(String []args){
       SpaceShipDelegation ssd = new SpaceShipDelegation("NSEA Protector");
	   ssd.forward(100);

    }
}

class SpaceShipControls{

   void up(int velocity){}
   void down(int velocity){}
   void left(int velocity){}
   void right(int velocity){}
   void forward(int velocity){}
   void back(int velocity){}
   void turboBoost(int velocity){}
}

class SpaceShipDelegation{

  private String name;
  private SpaceShipControls controls = new SpaceShipControls();
  public SpaceShipDelegation(String name){
    this.name=name;
  }

  public void back(int velocity){
     controls.back(velocity);
  }
  public void down(int velocity){
     controls.down(velocity);
  }
  public void forward(int velocity){
     controls.forward(velocity);
  }
  public void left(int velocity){
     controls.left(velocity);
  }
  public void right(int velocity){
     controls.right(velocity);
  }
  public void turboBoost(int velocity){
     controls.turboBoost(velocity);
  }
  public void up(int velocity){
     controls.up(velocity);  
  }
}
//
class SpaceShip extends SpaceShipControls{
    private String name;
	public SpaceShip(String name){this.name = name;}
    public String toString(){
	   return name;
	}
    public static void main(String[] args){
	   SpaceShip protector = new SpaceShip("NSEA Protector");
	   protector.forward(100);
	}
} 

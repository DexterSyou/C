class P6EC_D{

}

interface CanFight {
    void fight();
}

interface CanSwim{
    void swim();
}

interface CanFly{
    void fly();
}
//EC
interface CanClimb{
  // void climb();
}
//ED
interface ED1 extends CanClimb{

}
interface ED2 extends CanClimb{

}
class ED implements ED1, ED2{}
//
class ActionCharacter {
    public void fight(){}
}

class Hero extends ActionCharacter 
   implements CanFight,CanSwim,CanFly
{ 
    public void swim(){}
    public void fly(){}
}

class Adventure {
   public static void t(CanFight x) { x.fight(); }
   public static void u(CanSwim x) { x.swim(); }
   public static void v(CanFly x) { x.fly(); }
   public static void w(ActionCharacter x) { x.fight(); }
   
   public static void main(String[] args){
      Hero h = new Hero();
      t(h);
      u(h);
      v(h);
      w(h);
   }
}

public class E5ToA{
    //
    public static void main(String[] args){
    //E8
    Sandwich sw = new Sandwich();
    sw.withDrink();
    }
}

//********************************************
//E5
/*code略 
  import 后调用
  接口如果没有public，则它只具有包访问权限
*/

//********************************************
//E6
interface E6{
   void method();
}

class E6Cls implements E6{
    @Override
    public void method(){}
    // void method(){}
    //! Compile E6Cls中的method()无法实现E6中的method()
    //! 正在尝试分配更低的访问权限; 以前为public
}

//********************************************
//E7
interface Rodent{
	//...
}

//********************************************
//E8
interface FastFood{
  void withDrink();
}

class Sandwich implements FastFood {
   public void withDrink(){
       System.out.println("With a Cola ...");
   } 

} 

//********************************************
//E9
/*
abstract class Instrument{
    abstract public void play();
    //...
}
*/
//********************************************
//EA
interface Playable {
    void play();
}
interface Instrument{
	void adjust();  //
}
class Wind implements Instrument,Playable{
	public String toString(){return "Wind";}
	public void adjust(){System.out.println("Wind.pladjustay() ");}
	public void play(){System.out.println("Wind.play() ");}
}

class Music5{
  static void tune(Playable p){
     p.play();
  }
  static void tuneAll(Playable[] e){
     for(Playable p : e){
         tune(p);
     }  
  }
  public static void main(String[] args){
     Playable[] orchestra = {
         new Wind()
     };
     tuneAll(orchestra);   
  }

}



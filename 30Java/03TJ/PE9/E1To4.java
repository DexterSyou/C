public class E1To4{

    //
    static void getshow(E4 e4){
      ((E4Cls)e4).show();
    }

    static void getshow(E4HasMth e4){
       e4.show();
    }

    public static void main(String[] args){
        //  E2 e2 = new E2(); //!E2是抽象的; 无法实例化
        //
        //E3
        E3P e3 = new E3Cls();
        e3.print();
        //E4
        E4 e4 = new E4Cls();
        getshow(e4);
        E4HasMth e4hasMth = new E4Cls1();
        getshow(e4hasMth);
    }
}

//E1
abstract class Rodent{
	abstract public void what();
}

//E2
abstract class E2{}

//E3
abstract class E3P{
   public E3P(){
       System.out.println("E3 Base Class");
       print();
   }
   abstract public void print();
}

class E3Cls extends E3P{ 
  private int i=99;
  public E3Cls(){
       System.out.println("E3Cls Class");
  }

  public void print(){
    System.out.println(this.i);
  }
}

//E4
abstract class E4{}

abstract class E4HasMth{
    abstract void show();
}

class E4Cls extends E4{
    void show(){System.out.println("E4Cls show");}
}

class E4Cls1 extends E4HasMth {
    @Override 
    void show(){ System.out.println("E4Cls 1 show"); }
}

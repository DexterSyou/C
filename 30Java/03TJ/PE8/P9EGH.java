public class //P9EGH{

    public static void main(String[] args){

    }
}

class Actor{
   public void act(){}
}

class HappyActor extends Actor{
   public void act(){System.out.println("HappyActor");}
}

class SadActor extends Actor{
   public void act(){System.out.println("SadActor");}  
}

class Stage {//继承是在编译时期决定继承不同的对象
             //组合在运行时获得了动态灵活性
   private Actor actor = new HappyActor();
   public void change(){ actor = new SadActor();}
   public void performPlay(){ actor.act();}
}

//E16
class AlertStatus{
    protected String warning = "Warning!";
    private String error   = "Error!";//getter setter 
    protected String ok      = "OK";
}

class Starship {
     private static AlertStatus as = new AlertStatus();

     static void showStatus(){
         //
         System.out.println(as.warning);
     } 
}


//继承表达行为之间的差异，用字段表达状态上的变化
//
class Tansmogrify{

    public static void main(String[] args){
         Stage stage = new Stage();
         stage.performPlay();
         stage.change(); 
         stage.performPlay();
         //16 
         Starship.showStatus();
    }
}


// 基类引用不能访问导出类扩展部分的接口
/*Useful  f() g()
MoreUseful f() g()  u() v() w()
java中所有转型都会得到检查，即运行时类型识别RTTI
ClassCastException
*/
class Useful{
   public void f(){}
   public void g(){}
}

class MoreUseful extends Useful{
   public void f(){}
   public void g(){}
   public void u(){}
   public void v(){}
   public void w(){}
}

class RTTI {
    public static void main(String[] args){
       Useful[] x = {
          new Useful(),
          new MoreUseful()
       };

       //E17 略
       x[0].f();
       x[1].g();
       //!x[1].u();
       ((MoreUseful)x[1]).u();
       ((MoreUseful)x[0]).u(); //! java.lang.ClassCastException
    }
}

public class P2Extends{
    public static void main(String[] args){
 /*
  Object
  自动得到基类的所有域 和 方法

*/       

    }
}

class Cleanser{
    private String s = "Cleanser ";
    public void append(String a) { s+=a;}
    public void dilute() { append("dilute() ");}
    public void apply() { append("apply() ");}
    public void scrub() { append("scrub() ");}
    public String toString(){
        return s;
    }

    public static void main(String[] args){
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        System.out.println(x);
    }
}

class Detergent extends Cleanser{
   
   public void scrub(){
      append("Detergent.scrub() ");
      super.scrub();//super 代表基类
   }

   public void foam(){append("foam() ");}

   public static void main(String[] args){
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Testing base class: ");
        Cleanser.main(args);
   }
}

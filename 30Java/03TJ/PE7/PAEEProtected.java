public class PAEEProtected{

    public static void main(String[] args){
      Orc orc = new Orc("Limburger",12);
      System.out.println(orc);
      orc.change("Bob",19);
      System.out.println(orc);
    }
}

class Villain{
   private String name;
   //E15
   //protected 提供了包的访问权限 
   //继承类或位于同一包内的类可以访问
   protected void set(String nm){ name = nm; }
   public Villain(String name){this.name=name;}
   public String toString(){
       return "I'm a Villain and my name is " + name;
   }
}

class Orc extends Villain{
    private int orcNumber;
    public Orc(String name, int orcNumber){
        super(name);
        this.orcNumber = orcNumber;
    }
    public void change(String name, int orcNumber){
       set(name);
       this.orcNumber = orcNumber;
    }
    public String toString(){
       return "Orc " + orcNumber + ": " + super.toString();  
    }
}

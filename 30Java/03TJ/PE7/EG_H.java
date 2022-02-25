public class EG_H{

 public static void main(String[] args){  
    Frog f = new Frog();
    Amphibian.excute(f);
  }
}

class Amphibian{
  
  void jump(){
      System.out.println("Amphibian Jump....");
  }

  void swim(){
      System.out.println("Amphibian Swim....");
  }

  static void excute(Amphibian a){
      a.jump();
      a.swim();
  }

}

class Frog extends Amphibian{
  //E17
  @Override
  void swim(){
      System.out.println("Frog Swim....");
  }
}

public class E5_7{
   public static void main(String[] args){
      new C();
      new C(90);
   }
}

class A{
  A(){
      System.out.println("A(); ");
  }
  A(int i){
     System.out.println("A(); "+i);
  }
}

class B{

  B(){
        System.out.println("B(); ");
  }
  B(int i){
        System.out.println("B(); " +i);
  }
}

class C extends A{
    B b=new B();
    B b90=new B(90);
    C(){
        System.out.println("C(); ");
    }
   
    C(int i){
        super(i);
        System.out.println("C(); "+i);
    }
}

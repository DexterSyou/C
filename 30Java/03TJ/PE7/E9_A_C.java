public class E9_A_C {

    public static void main(String []args){
      new Stem();
       //注意清理的顺序
	   /*Stem
		*Root
		*Com3～Com1
		*/
    }

}

class Root{
   Component1 c1 = new Component1();
   Component2 c2 = new Component2();
   Component3 c3 = new Component3();
   Root(){
     System.out.println("Root() ");
   }
   //dispose
}

class Component1{

   Component1(){ 
     System.out.println("Component1() ");
   }
   //EC
   //dipose..
}

class Component2{
  Component2(){
     System.out.println("Component2() "); 
  }
  //dispose..
}

class Component3{
   Component3(){
     System.out.println("Component3() ");
   }

   //dispose
}

class Stem extends Root{
   Stem(){
      System.out.println("Stem()  ");
   }
   //dispose
}


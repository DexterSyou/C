import java.util.*;

public class E3To7 {
    //E3
    E3To7(){
	  System.out.println("Default Construct..."); 
	} 
	//E4
	E3To7(String msg){
	  System.out.println("Msg:"+msg);	
	}
    //
    public static void main(String []args){

		 //E3
         E3To7 e3 = new E3To7();
		 //E4
		 E3To7 e4 = new E3To7("Hello!!!!!");
		 //E5
         Dog   e5 = new Dog();
         char  c=5;
		 byte  b=6;
		 short s=7;
         e5.bark(c);
		 e5.bark(b);
         e5.bark(s);
		 e5.bark(8);
		 //E6
		 e5.bark(8,9.9);//浮点型数据默认double
		 e5.bark(9.9,8);
    }
}

//E5
class Dog{
   //E7
   //Dog(){}
   //	   
   void bark(int i){
      System.out.println("Int Barking...");
   }

   void bark(short s){
      System.out.println("Short howling...");
   }
   /*
   void bark(char c){
      System.out.println("Char Woh...");
   }
   */
   void bark(byte b){
      System.out.println("Byte baho baho...");
   }
   //E6
   void bark(int i, double j){
     System.out.println(i+" "+j);
   } 
   void bark(double j,int i){
     System.out.println(j+" "+i);
   } 
}




import java.util.*;

public class E1To8{
   //E1
   int  i;
   char c;

   //driver
   public static void main(String[] args){
      
	   //E1_6 
       E1To8 e1to8 = new E1To8();
	   System.out.println(e1to8.i);
	   System.out.println(e1to8.c); 
	   System.out.println(e1to8.storage("Hello"));
	   //E2
	   System.out.println("Hello World!");
       //E3
       ATypeName a=new ATypeName();
       //4_5
	   DataOnly d = new DataOnly();
	   d.i=10;
	   System.out.println(d.i);
	   //E7_8
	   Incrementable e7_8obj1 = new Incrementable();
	   Incrementable e7_8obj2 = new Incrementable();
       e7_8obj1.increment();
	   e7_8obj2.increment();
	   System.out.println(StaticTest.i);
   }

   //********************************************
   //E6
   int storage(String s){
      return s.length()*2;
   }
}
//---------------------------------------------
//E4_5
class DataOnly{
    int     i;
	double  d;
	boolean b;
	/*
	 * ...
	 */
}
//E6
class ATypeName{
   /* */
}

//E7_8
class StaticTest{
   static int i = 47;
}

class Incrementable{
   static void increment(){
     StaticTest.i++;
   }
}

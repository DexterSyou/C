import java.util.*;

public class E1_2 {

    String str1;  
    String str2="Hello";
	String str3;
    E1_2(){
	
	}

	E1_2(String str){
	   str3=str;
	}

    public static void main(String []args){
       E1_2 e1 = new E1_2();
	   E1_2 e2 = new E1_2("World");
       //E1
	   System.out.println(e1.str1);
       //E2
	   System.out.println(e2.str2);
	   System.out.println(e2.str3);

    }




}

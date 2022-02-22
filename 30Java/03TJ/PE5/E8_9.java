import java.util.*;

public class E8_9 {



    public static void main(String []args){

        TMThis tmthis = new TMThis();
        tmthis.method1();
    }
}

class TMThis{

	TMThis(){
	  this("This is a test for This");
	}

	TMThis(String str){
	  System.out.println("MSG : " + str);
	}

	void method1(){
	  System.out.println("Method1 ... ");
	  method2();
	  this.method2();
	}

	void method2(){
	  System.out.println("Method2 ... ");
	}

}



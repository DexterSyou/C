public class EE {

	static String str1 = "hello world.";
	static String str2;
	static {
	  str2 = "How are you.";
	}

	static void printValue(){
	  System.out.println(str1 + str2);
	}
    public static void main(String []args){
         System.out.println(EE.str1);
		 new EE(); 
		 EE.printValue();
	}

}

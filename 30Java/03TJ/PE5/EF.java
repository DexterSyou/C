public class EF {

	static int count=0; 
    String str;
    {
	  str="HelloWorld";
	  count++;
	}

	EF(){
	
	}

    public static void main(String []args){

      new EF();
	  new EF();
	  System.out.println("Instance Init Count: "+EF.count);
    }

}

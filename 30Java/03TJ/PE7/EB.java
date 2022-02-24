public class EB {

    private Cleanser cleanser = new Cleanser();

	private void append(String str){
	   cleanser.append(str);
	}
	
	public String toString(){
	  return cleanser.toString();
	}
	public static void main(String []args){
        EB eb = new EB();
		eb.append("world");
		System.out.println(eb);



    }
}




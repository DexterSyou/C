public class EGToIDriver {

    public static void main(String []args){

		//EG 
        new E16().printStr();

		//EH EI
		E17_18[] ary1 = new E17_18[10];
		System.out.println("After init...");
  
		for(int i=0;i<ary1.length;i++){
		   ary1[i] = new E17_18("hello"+i);
		} 
    }


}
//EG
class E16{
   String [] str = new String[]{"hello","world","how are you"};

   void printStr(){
     for(int i=0;i<str.length;i++){
	   System.out.println(str[i]);
	 }
   }
}
//EH EI
class E17_18{
  
	E17_18(String str){
	  System.out.println(str);
	}

}

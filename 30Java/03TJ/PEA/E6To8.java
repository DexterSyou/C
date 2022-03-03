public class E6To8 {

    public static void main(String []args){
         E7 e7 = new E7();
		 System.out.println(e7);
		 e7.e7ChaningStr();
		 System.out.println(e7);
		 //
		 E8 e8 = new E8();
		 e8.printStr();
    }
}

//*******************************************
/*package 1
 * interface E6I{} 
 *
 *package 2
 * class E6{
 *   
 *    protected Inner implements E6I
 * }
 *
 *package 3
 * class E6Cls extends E6{
 *   
 *   public E6I getinner(){ return Inner(); }
 * } 
 *
 */

class E7 {

   private String str = "abc.";
   private void changeStr(String str){
     this.str = str;
   }

   class E7Inner {
     
	 public void change(String str){
	   System.out.println("Change String : " +str);
	   changeStr(str);
	 }
   }

   public void e7ChaningStr(){
     new E7Inner().change("hello world.!");
   }
   //
   public String toString(){
     return str;
   }
}
//
class E8 {
  class E8Inner {
    private String str="hello world.";
  }

  public void printStr(){
//    System.out.println(str); //!cannot find symbol
  }
}










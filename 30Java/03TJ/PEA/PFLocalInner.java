public class PFLocalInner {

    public static void main(String []args){

    }

}

//*******************************************
interface Counter {
  int next();
}

class LocalInnerClass {
 private int count = 0;

 Counter getCounter(final String name){
   class LocalCounter implements Counter {
     public LocalCounter(){System.out.println("LocalCounter()");}
     
	 public int next(){
	   System.out.println(name);
	   return count++;
	 }
   }
   return new LocalCounter();
 }

 Counter getCounter2(final String name){
   return new Counter(){
      { System.out.println("Counter()");}

	  public int next(){
	    System.out.println(name);
		return count++;
	  }
   };
 }
  //
 //
 public static void main(String[] args){
   LocalInnerClass lic = new LocalInnerClass();
   Counter
	    c1 = lic.getCounter("Local inner "),
        c2 = lic.getCounter2("Anonymous inner "); 
   for(int i=0;i<5;i++)
	   System.out.println(c1.next());
   for(int i=0;i<5;i++)
	   System.out.println(c2.next());
 }
}

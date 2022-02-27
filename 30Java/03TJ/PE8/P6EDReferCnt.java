public class P6EDReferCount {

    public static void main(String []args){

		Shared shared = new Shared();
		Composing[] composing = {
		  new Composing(shared),
		  new Composing(shared),
		  new Composing(shared),
		  new Composing(shared),
		  new Composing(shared)
		};

		for(Composing c : composing){
		  System.out.println(c); 
		  c.dispose();
		}

		new Shared();
		new Shared();
		new Shared();
		System.gc();
    }

}

//*******************************************
class Shared {
  
	private int refcount = 0;
	private static long counter = 0;
	private final long id = counter++;
	public Shared(){
	  System.out.println("Creating  " + this);
	}

	public void addRef(){ refcount++; }
    protected void dispose(){
	  if(--refcount == 0){
	     System.out.println("Disposing " + this);
	  }
	}
    //E13
	protected void finalize(){
	  System.out.println("Clear Memory...");
	  if(refcount==0){
	    System.out.println("Finalize Shared...");
	  }
	}

	public String toString(){
	  return "Shared " + id;
	}
}

class Composing {

   private Shared shared;
   private static long counter = 0;
   private final long id = counter++;

   public Composing(Shared shared){
     System.out.println("Creating  " + this);
     this.shared = shared;
     this.shared.addRef();
   }

   protected void dispose(){
     System.out.println("disposing " + this);
	 shared.dispose();
   }
   
   public String toString(){ return "Composing " + id; }
}


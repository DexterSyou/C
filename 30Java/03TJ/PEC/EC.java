import java.util.*;

interface Selector {
   boolean end();
   Object current();
   void next();
}

public class EC {
   private Object[] items;
   private int next = 0;

   public EC(int size){
     items = new Object[size];
   }
   
   public void add(Object x) throws Exception {
     if(next <= items.length)
		 items[next++] = x;
	 if(next > items.length){
	    throw new Exception();
	 }
   }

   private class SequenceSelector implements Selector {
      private int i = 0;
	  public boolean end(){
	    return i == items.length;
	  }
      public Object current(){
	    return items[i];
	  }
      public void next(){
	     if(i<items.length){
		   i++;
		 }
	  }
   }

   public Selector selector(){
     return new SequenceSelector();
   }

   public static void main(String []args){
      try{
	     EC sequence = new EC(10);
		 for(int i=0;i<11;i++){
		   sequence.add(i); 
		 }
         Selector selector = sequence.selector();
         while(!selector.end()){
		    System.out.print(selector.current() + " ");
			selector.next();
		 } 
	  }catch(Exception e){
	     e.printStackTrace();  
	  }
   }
}

//*******************************************

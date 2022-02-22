import java.util.*;

public class P4Book {

	boolean checkedOut = false;
	P4Book(boolean checkOut){
	   checkedOut = checkOut;
	}

	void checkIn(){
	   checkedOut = false;
	}

	protected void finalize(){
	 
		if(checkedOut){
		  System.out.println("Error: checked out");
		}
		//super.finalize();
	}
    public static void main(String []args){

       P4Book novel = new P4Book(true);
       novel.checkIn();
	   new P4Book(true);
       System.gc();
    }

}

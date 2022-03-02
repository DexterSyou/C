import java.util.*;
import java.nio.*;

public class EGRandWords implements Readable{

	private static Random rand = new Random(47);
    private static final char[] captitals = 
		"ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

	private int count;
	public EGRandWords(int count){
	  this.count = count;
	}

	public int read(CharBuffer cb){
	  if(count-- == 0){
	    return -1;
	  }
      for(int i=0;i<10;i++)
	    cb.append(captitals[rand.nextInt(captitals.length)]);
      cb.append(" ");
      return 10;
	}

    public static void main(String []args){
      Scanner sc = new Scanner(new EGRandWords(10));
	  while(sc.hasNext()){
	    System.out.println(sc.next());
	  }
    } 

}

//*******************************************

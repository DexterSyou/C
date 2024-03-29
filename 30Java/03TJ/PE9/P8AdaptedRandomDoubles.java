import java.nio.*;
import java.util.*;

public class P8AdaptedRandomDoubles extends RandomDoubles implements Readable{


	private int count;
	public P8AdaptedRandomDoubles(int count){
	  this.count = count;
	}

	public int read(CharBuffer cb){
	  if(count-- == 0)
		  return -1;
	  String result = Double.toString(next())+" ";
	  cb.append(result);
	  return result.length();
	}

    public static void main(String []args){

		Scanner s = new Scanner(new P8AdaptedRandomDoubles(7));
		 while(s.hasNextDouble()){
		    System.out.println(s.nextDouble() + " ");
		 }

    }

}

//*******************************************
class RandomDoubles {
  private static Random rand = new Random(47);
  public double next() { return rand.nextDouble();}
}


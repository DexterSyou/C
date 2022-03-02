import java.util.*;

interface RandVals {
   Random RAND = new Random();
   int RAND_INT = RAND.nextInt(10);
}
public class EH {

    public static void main(String []args){
      System.out.println(RandVals.RAND_INT);
    }

}

//*******************************************

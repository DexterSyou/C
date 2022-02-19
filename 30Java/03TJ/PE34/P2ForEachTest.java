import java.util.*;

public class P2ForEachTest {


    public static void main(String []args){
       
		Random rand = new Random(47);
		float f[] = new float[10];
		for(int i=0;i<10;i++)
			f[i]=rand.nextFloat();
		for(float x: f)
			System.out.print(x+" ");
		System.out.println();

		for(char c: "An African Swallow".toCharArray()){
		   System.out.print(c + " ");
		}



    }




}

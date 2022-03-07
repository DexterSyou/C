import java.util.*;

public class P7EGSet { }
//*******************************************
class SetOfInteger {
/*
 *Set最常用测试归属行，HashSet专门对快速查找进行了优化
 */
  public static void main(String[] args){
    Random rand = new Random(47);
	Set<Integer> intset = new HashSet<Integer>();
	for(int i=0;i<10000;i++){
	  intset.add(rand.nextInt(30));
	}
	System.out.println(intset);
    //Sorted
	//TreeSet对结果排序  
  }
}

class  SetOperations {
  
	public static void main(String[] args){
	   Set<String> set1 = new HashSet<String>();
	   Collections.addAll(set1,"A B C D E F G H I J K L".split(" "));
	   set1.add("M");
	   System.out.println("H: "+set1.contains("H"));
	   System.out.println("N: "+set1.contains("N"));
	   Set<String> set2 = new HashSet<String>();
	   Collections.addAll(set2,"H I J K L".split(" "));
	   System.out.println("set2 in set1: " + set1.containsAll(set2));
	   set1.remove("H");   
	   System.out.println("set1: "+set1);
	   System.out.println("set2 in set1: " + set1.containsAll(set2));
	   set1.removeAll(set2);
	   System.out.println("set2 remove from set1: "+set1);
       Collections.addAll(set1,"X Y Z".split(" "));
	   System.out.println("'X Y Z' added to set1: " +set1);
	}
}


//E16 EG

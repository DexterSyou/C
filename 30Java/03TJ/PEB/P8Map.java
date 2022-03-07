import java.util.*;
public class P8Map {

    public static void main(String []args){

    }

}

//*******************************************
class Statistics {

  public static void main(String[] args){
    Random rand = new Random(47);
	Map<Integer,Integer> m = new HashMap<Integer,Integer>();
	for(int i=0;i<10000;i++){
	  int r = rand.nextInt(20);
	  Integer freq = m.get(r);
      //自动包装，拆包
	  m.put(r, freq==null?1:freq+1);
	}
	System.out.println(m);
  }
}

class PetMap {
   public static void main(String[] args){
     Map<String,String> petMap = new HashMap<String,String>();
	 petMap.put("MyCat","Cat Molly");
	 petMap.put("MyDog","Dog Ginhger");
     petMap.put("MyHamster","Hamster Bosco");
     System.out.println(petMap);
	 String dog = petMap.get("MyDog");
	 System.out.println(dog);
     System.out.println(petMap.containsKey("MyDog"));
	 System.out.println(petMap.containsValue(dog));
   }
}
//
/* Map<Person, List<Pet>>
 * keySet 返回键的Set
 */

//*************************************************


import java.util.*;
//
public class P2E2To4Collection {
    public static void main(String []args){

	}
}
/* 容器类库：保存对象
 * Collection : 一个独立元素的序列
 * Map        : 一组键值对，允许使用键查找值
 *              通过键对象查找值对象  
 */
//*******************************************
// Collection : 一种存放一组对象的方式
class SimpleCollection {
  public static void main(String[] args){
    Collection<Integer> c = new ArrayList<Integer>();
	for(int i=0;i<10;i++)
		c.add(i);

	for(Integer i : c){
	  System.out.print(i + ", ");
	}

	//E1
	Collection<Integer> ss = new HashSet<Integer>();
    for(int i=0;i<10;i++)
		ss.add(i);
	for(Integer s : ss){
	  System.out.print(s + ", ");
	}
	System.out.println();
  }
}
//E2
// use Collection ArrayList 
//*********************************************
class AddingGroups {
   public static void main(String[] args){
	  //Arrays.asList将一个数组 或 逗号分隔的元素列表 转换成List对象
	  //Array.asList底层是数组实现的，尺寸受到限制
      Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
	  Integer[] moreInts = {6,7,8,9,10};
	  //接受一个collection对象，以及一个数组或逗号分隔的列表
	  collection.addAll(Arrays.asList(moreInts));
	  //
	  //构建一个不包含元素的Collection，然后用Collections.addAll()初始化
      Collections.addAll(collection,11,12,13,14,15);
	  Collections.addAll(collection,moreInts);
      List<Integer> list = Arrays.asList(16,17,18,19,20);
      list.set(1,99);
	  //list.add(21)
   }
}
//*********************************************
class Snow {}
class Powder extends Snow   {}
class Light  extends Powder {}
class Heavy  extends Powder {}
class Crusty extends Powder {}
class Slush  extends Snow   {}

class AsListInference {
  public static void main(String[] args){
    List<Snow> snow1 = Arrays.asList(new Crusty(),new Slush(),new Powder());
    //won't compile
    //List<Snow> snow2 = Arrays.asList(new Light(),new Heavy());
    List<Snow> snow3 = new ArrayList<Snow>();
    Collections.addAll(snow3, new Light(), new Heavy());
    List<Snow> snow4 = Arrays.<Snow>asList(new Light(),new Heavy());
  }
}

//**********************************************
class PrintingContainers {
  static Collection fill(Collection<String>collection){
    collection.add("rat");
	collection.add("cat");
	collection.add("dog");
	collection.add("dog");
	return collection;
  }

  static Map fill(Map<String,String> map){
    map.put("rat","Fuzzy");
	map.put("cat","Rags");
    map.put("dog","Bosco");
    map.put("dog","Spot");
	return map;
  }

  public static void main(String[] args){
	 //List 有序 
     System.out.println(fill(new ArrayList<String>())); 
     System.out.println(fill(new LinkedList<String>()));
     //Set  无重复
	 System.out.println(fill(new HashSet<String>()));
     System.out.println(fill(new TreeSet<String>()));
     System.out.println(fill(new LinkedHashSet<String>())); 
     //Map
	 System.out.println(fill(new HashMap<String,String>()));
     System.out.println(fill(new TreeMap<String,String>()));
     System.out.println(fill(new LinkedHashMap<String,String>()));  
  }
}

//*********************************************
class MovieNameGenerator {
  String[] movies = {"Snow White","Star Wars","White Princple","Dream","The Forest"};
  int next;
  public String next(){
    String movie = movies[next++];
	next = (next+1) % movies.length;
	return movie;
  }
}

class E4 {
  MovieNameGenerator movieNameGenerator = new MovieNameGenerator();
  public String[] fill(String[] arr){
      for(int i=0;i<arr.length;i++){
	    arr[i] = movieNameGenerator.next();
	  }
	  return arr;
  }

  public Collection fill(Collection col){
     for(int i=0;i<5;i++){
	   col.add(movieNameGenerator.next());
	 }
	 return col;
  }

  public static void main(String[] args){
     E4 e4 = new E4();
	 
     System.out.println(Arrays.toString(e4.fill(new String[5]))); 
     System.out.println(e4.fill(new LinkedList<String>()));
     System.out.println(e4.fill(new ArrayList<String>())); 
     System.out.println(e4.fill(new HashSet<String>())); 
     System.out.println(e4.fill(new LinkedHashSet<String>())); 
     System.out.println(e4.fill(new TreeSet<String>()));
  }
}




















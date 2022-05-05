import java.util.*;
public class P3E9ToGenericMth {
    public static void main(String []args){

    }
}
//*******************************************
//原则：优先考虑范型方法
class GenericMethods {
  //E9
  public <T,U> void f(T x , U y) {
    System.out.println(x.getClass().getName());
    System.out.println(y.getClass().getName());
  }

  //EA
  public <T> void f1(T x, int i){  
    System.out.println(i + ":" + x.getClass().getName());
  }
  public static void main(String[] args){
    GenericMethods gm = new GenericMethods();
	gm.f("",gm);
    gm.f(1,1.0);
	gm.f1(1.0F,2);
	//gm.f(1.0);
	//gm.f(1.0F);
	//gm.f('c');
	//gm.f(gm);
  }
}


//*******************************************
class New {
  public static <K,V> Map<K,V> map(){
    return new HashMap<K,V>();
  }

  public static <T> List<T> list(){
    return new ArrayList<T>();
  }

  public static <T> LinkedList<T> lList(){
    return new LinkedList<T>();
  }

  public static <T> Set<T> set(){
    return new HashSet<T>();
  }
  
  public static <T> Queue<T> queue(){
    return new LinkedList<T>();
  }
  //EB11EC12
  public static void main(String[] args){
    Map<String,List<String>> sls = New.map();
	//....
  }
  /* func(New.<Person,List<Pet>>map())
   */
}
class GenericVarargs {
  public static <T> List<T> makeList(T...args){
     List<T> result = new ArrayList<T>();
	 for(T item : args){
	   result.add(item);
	 }
	 return result;
  }

  public static void main(String[] args){
    List<String> ls = makeList("A");
	System.out.println(ls);
	ls = makeList("A","B","C");
	System.out.println(ls);
	ls = makeList("ABCDEFGHIJKLMNOPQRSTUVWXVZ".split(""));
	System.out.println(ls);
  }
}

//**************************************
interface Generator<T>{ T next(); }
class Generators {
   public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n){
      for(int i=0;i<n;i++){
	    coll.add(gen.next());
	  }
	  return coll;
   }

   public static void main(String[] args){
   // ED13	   
   // Collection<Integer> nums = fill(new ArrayList<Integer>(),new Fibonacci(),12);
   }
}

class BasicGenerator<T> implements Generator<T> {
   
   private Class<T> type;
   public BasicGenerator(Class<T> type) { this.type = type;}
   public T next() {
     try{
	   return type.newInstance();
	 }catch(Exception e){
	   throw new RuntimeException(e);
	 }
   }

   public static <T> Generator<T> create(Class<T> type){
     return new BasicGenerator<T>(type);
   }
}

class CountedObject {
  
 private static long counter = 0;
 private final long id = counter++;
 public long id() { return id;}
 public String toString() { return "CountedObject " + id; }
}

class BasicGeneratorDemo {
  public static void main(String[] args){
    Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
	for(int i=0;i<5;i++){
	  System.out.println(gen.next());
	}

	//EE14
	Generator<CountedObject> gen1 = new BasicGenerator(CountedObject.class);
	for(int i=0;i<5;i++){
	  System.out.println(gen1.next());
	}
  }
}

//******************************************************
class Tuple {
  //EFEG1516	
  /*
  public static <A,B> TwoTuple<A,B> tuple(A a, B b){
    return new TwoTuple<A,B>(a,b);
  }
  
  public static <A,B,C> ThreeTuple<A,B,C> tuple(A a, B b ,C c){
    return new ThreeTuple<A,B,C>(a,b,c);
  }
  */
}

//































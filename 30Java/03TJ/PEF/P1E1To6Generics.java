import java.util.*;
public class P1E1To6Generics {
    public static void main(String []args){

    }
}
//*******************************************
class Automobile {}
class Holder1 {
  private Automobile a;
  public Holder1(Automobile a){this.a = a;}
  Automobile get() { return a;}
}
class Holder2 {
  private Object a;
  public Holder2(Object a) { this.a = a;}
  public void set(Object a){ this.a = a;}
  public Object get(){ return a;}

  public static void main(String[] args){
    Holder2 h2 = new Holder2(new Automobile());
	Automobile a = (Automobile)h2.get();
	h2.set("Not an Automobile");
	String s =(String)h2.get();
	h2.set(1);
	Integer x = (Integer)h2.get();
  }
}
/*
 *泛型主要目的之一就是用来指定容器要持有什么类型对象，而且由编译器来保证类型的正确性
 ***告诉编译器想 使用什么类型，然后编译器帮你处理一切
 */ 
class Holder3<T> {
  //T 类型参数，使用时用实际的类型替换此类型参数	
  private T a;
  public Holder3(T a) { this.a = a;}
  public void set(T a) { this.a = a;}
  public T get(){ return a;}
  public static void main(String[] args){
    Holder3<Automobile>h3 =new Holder3<Automobile>(new Automobile());
	Automobile a = h3.get();
    //
	Holder3<E1B> e1 = new Holder3<E1B>(new E1B());
    e1.set(new E1());
  }
}
//E1
class E1B {}
class E1 extends E1B{}
//E2
class E2Holder<T> {
  private List<T> l = new ArrayList<T>();
  public E2Holder(T a,T b,T c) {
	  l.add(a);
      l.add(b);
	  l.add(c);
  }
  //set ...
  public List<T> get(){return l;}

  public static void main(String[] args){
     E2Holder<String> e2 = new E2Holder<String>("helloworld","how are you","ok");	 
     List<String> e2l = e2.get();
	 System.out.println(e2l);
  }
}
//*******************************************
class TwoTuple<A,B>{
  public final A first;
  public final B second;
  public TwoTuple(A a,B b){ first=a;second=b;}
  public String toString(){
    return "(" + first +", " + second+")";
  }
}
class ThreeTuple<A,B,C> extends TwoTuple<A,B>{
  public final C third; 
  public ThreeTuple(A a, B b, C c){
    super(a,b);
	third = c;
  }

  public String toString(){
    return "(" + first +", " + second+"," + third + ")";
  }
}
//class FourTuple<A,B,C,D>
//class FiveTuple<A,B,C,D,E>

class Amphibian {}
class Vehicle {}

class TupleTest {
  static TwoTuple<String , Integer> f(){
    return new TwoTuple<String,Integer>("hi",47);
  }

  static ThreeTuple<Amphibian,Vehicle,String> g() {
    return new ThreeTuple<Amphibian,Vehicle,String>(new Amphibian(),new Vehicle(),"hello");
  }

  //FourTuple
  //FiveTuple

  public static void main(String[] args){
   System.out.println(f());
   System.out.println(g());
  }
}
//E3
//E4
//*******************************************
class LinkedStack<T> {
  private  class Node {
    T item;
	//E5
	Node next;
	Node(){ item=null;next=null;}
    Node(T item, Node next){
	   this.item = item;
	   this.next = next;
	}
	boolean end() { return item == null && next == null;}
  } 
  
  private Node top = new Node(); 
  public void push(T item){
    top = new Node(item, top);
  }
  public T pop(){
    T result = top.item;
	if(!top.end())
		top=top.next;
	return result;
  }

  public static void main(String[] args){
     LinkedStack<String> lss = new LinkedStack<String>();
	 for(String s : "Phasers on stun!".split(" "))
		 lss.push(s);
     String s;
	 while((s=lss.pop())!=null)
	  System.out.println(s);
  }
}
//*******************************************
class RandomList<T> {
  private ArrayList<T> storage = new ArrayList<T>();
  private Random rand = new Random(47);
  public void add(T item) { storage.add(item); }
  public T select(){
   return storage.get(rand.nextInt(storage.size()));
  }

  public static void main(String[] args){
     RandomList<String> rs = new RandomList<String>();
	 for(String s: "The quick brown fox jumped over the lazy brown dog".split(" "))
		 rs.add(s);

     for(int i=0;i<11;i++){
	   System.out.print(rs.select()+" ");
	 }
     //E6
	 RandomList<Integer> ri = new RandomList<Integer>();
	 for(int i=0;i<5;i++)
		 ri.add(i);
	 for(int i=0;i<5;i++){
	   System.out.print(ri.select()+" ");
	 }
  }
}


//*******************************************
//*******************************************

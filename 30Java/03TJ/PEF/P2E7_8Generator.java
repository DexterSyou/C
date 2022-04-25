import java.util.*;
public class P2Generator {
    public static void main(String []args){

    }
}
//*******************************************
interface Generator<T> {
 T next();
}
//E8 StoryCharacters
class Coffee {
  private static long counter = 0;
  private final long id = counter++;
  public String toString(){
    return getClass().getSimpleName() + " " + id;
  }
}
//E8 GoodGuys BadGuys
class Latte extends Coffee {}
class Mocha extends Coffee {}
class Cappuccino extends Coffee {}
class Americano extends Coffee {}
class Breve extends Coffee {}
//E8
class CoffeeGenerator implements Generator<Coffee>,Iterable<Coffee>{
  private Class[] types = { Latte.class,Mocha.class,Cappuccino.class,Americano.class,Breve.class};
  private static Random rand = new Random(47);
  public CoffeeGenerator() {}

  private int size = 0;
  public CoffeeGenerator(int sz) { size = sz; }
  public Coffee next(){
    try{ 
	  return (Coffee)types[rand.nextInt(types.length)].newInstance(); 
	}catch(Exception e){
	  throw new RuntimeException(e);
	}
  }

  class CoffeeIterator implements Iterator<Coffee>{
     int count = size;
	 public boolean hasNext() { return count > 0;}
	 public Coffee next(){
	   count--;
	   //CoffeeGenerator.this指明外部类的方法引用
	   return CoffeeGenerator.this.next();
	 }
	 public void remove(){
	   throw new UnsupportedOperationException();
	 }
  };

  public Iterator<Coffee> iterator(){
	//主要是这个方法
    return new CoffeeIterator();
  }

  public static void main(String[] args){
    CoffeeGenerator gen = new CoffeeGenerator();
	for(int i=0;i<5;i++){
	  System.out.println(gen.next());
	}
	for(Coffee c : new CoffeeGenerator(5)){
	  System.out.println(c);
	}
  }
}
//*******************************************
class Fibonacci implements Generator<Integer>{
  private int count = 0;
  public Integer next() { return fib(count++);}
  private int fib(int n){
    if(n<2) return 1;
	return fib(n-2) + fib(n-1);
  }
  public static void main(String[] args){
    Fibonacci gen = new Fibonacci();
	for(int i=0;i<18;i++){
	  System.out.println(gen.next() + " ");
	}
  }
}

//*******************************************
class IterableFibonacci extends Fibonacci implements Iterable<Integer>{

  private int n;
  public IterableFibonacci(int count) { n = count;}
  public Iterator<Integer> iterator(){
    return new Iterator<Integer>(){
	  public boolean hasNext() { return n>0;}
	  public Integer next(){ 
	    n--;
		return IterableFibonacci.this.next();
	  }
	  public void remove(){
	    throw new UnsupportedOperationException();
	  }
	};
  }

  public static void main(String[] args){
    for(int i : new IterableFibonacci(18)){
	  System.out.println( i + " ");
	}
  }
}
//*******************************************
class E7 implements Iterable<Integer>{
  private int size;
  public E7(int size){
    this.size = size;
  }	
  public Iterator<Integer> iterator(){
	return new Iterator<Integer>() {
	  Fibonacci fib = new Fibonacci(); 	
	  public boolean hasNext(){return size > 0;} 
	  public Integer next(){
	    size--;
		return fib.next();
	  }
	  public void remove(){
	    throw new UnsupportedOperationException();
	  }
	};
  }

  public static void main(String[] args){
    for(int i : new E7(18)){
     System.out.print(i+" ");
    }
	System.out.println();
  }
}
//*******************************************
/*
 ***Iterable
 * Java集合类的基本接口是Collection接口。而Collection接口必须继承java.lang.Iterable接口。
 * 必须重写Iterable接口的iterator()方法，而iterator()方法必须返回一个迭代器对象
 ***Iterator
 * 迭代器对象就是实现了Iterator接口的迭代器类的实例，
 *   而迭代器类必须要重写Iterator接口的hasNext() 和 next() 方法，remove方法虽然default
 */






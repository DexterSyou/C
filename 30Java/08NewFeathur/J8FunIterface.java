import java.util.function.*;
import java.util.*;
class J8FunIterface{}
//default 可以在接口内部提供一些默认的实现方法，子类实现时不需要提供实现方法，自己重写也可以。
/*default、static方法必须有具体的实现，否则编译错误：This method requires a body instead of a semicolon
  可以拥有多个default方法,可以拥有多个static方法(与类中的一样)
  使用接口中类型时，仅仅需要实现抽象方法，default、static方法不需要强制自己新实现
   
*/
/*
Consumer接口是消费性接口，有参数T，无返回值void
@FunctionalInterface
public interface Consumer<T>{
  void accept(T t);
  default Consumer<T> andThen(Consumer<? super T> after){ 
       Objects.requireNonNull(after);
       return (T t) -> { accept(t); after.accept(t); }; 
   }
}

Supplier接口是供给型接口，有返回值T，无参数
@FunctionalInterface
public interface Supplier<T>{
  T get();
}

Function接口是函数型接口，有参数T,有返回值R
@FunctionalInterface
public interface Function<T, R> { 
   R apply(T t);
   //定义默认的行为
   default <V> Function<V, R> compose(Function<? super V, ? extends T> before){ 
       Objects.requireNonNull(before);
       return (V v) -> apply(before.apply(v));
   }
   default <V> Function<T, V> andThen(Function<? super R, ? extends V> after){ 
       Objects.requireNonNull(after);
       return (T t) -> after.apply(apply(t)); 
   }

   //静态方法的实现 
   static <T> Function<T, T> identity(){return t -> t; }
}

Predicate接口是断言型接口，有参数T,返回值类型为boolean
@FunctionalInterface
public interface Predicate<T> { 
    boolean test(T t);
    default Predicate<T> and(Predicate<? super T> other){ 
        Objects.requireNonNull(other);
        return (t) -> test(t) && other.test(t); 
    }
    default Predicate<T> negate(){return (t) -> !test(t); }
    default Predicate<T> or(Predicate<? super T> other){ 
        Objects.requireNonNull(other);
        return (t) -> test(t) || other.test(t); 
    }
    static <T> Predicate<T> isEqual(Object targetRef){
        return (null == targetRef) ? Objects::isNull : object -> targetRef.equals(object); 
    }
}
*/
class TestFunIterface{
   //
   public void handlerConsumer(Integer number, Consumer<Integer> consumer){
       consumer.accept(number);
   }
   //
   public List<Integer> getNumberList(int num,Supplier<Integer>supplier){
       List<Integer> list = new ArrayList<>();
       for(int i=0;i<num;i++){
           list.add(supplier.get());
       }
       return list;
   } 
   //
   public String handlerString(String str, Function<String, String> func){
       return func.apply(str);
   }
   //
   public List<String> filterString(List<String> list, Predicate<String> predicate){ 
       List<String> strList = new ArrayList<>();
       for(String str : list){ 
           if(predicate.test(str)){ 
               strList.add(str); 
           } 
       }
       return strList;
    }
   //TestMethod
   public void test1(){
       this.handlerConsumer(10,(i)->System.out.println(i));
   }
   public void test2(){
      List<Integer> numberList = this.getNumberList(10,()->new Random().nextInt(100));
      numberList.stream().forEach(System.out::println);
   }
   public void test3(){
     String str = this.handlerString("hello", (s) -> s.toUpperCase()); 
     System.out.println(str);
   }
   public void test4(){ 
       List<String> list = Arrays.asList("Hello", "Lambda", "binghe", "lyz", "World"); 
       List<String> strList = this.filterString(list, (s) -> s.length() >= 5); 
       strList.stream().forEach(System.out::println);
   }
}

class DriverFunIterface{
    public static void main(String[] args){
        TestFunIterface test = new TestFunIterface();
       // test.test1();
       // test.test2();
       //  test.test3();
         test.test4();
    }
}

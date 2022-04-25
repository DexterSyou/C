import java.util.*;
import java.util.Collection.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.function.Function;
class J8Stream{}
//***************************** */
/*
流，是一系列数据项，它不是一种数据结构。
Java 8 中的 Stream 是对集合（Collection）对象功能的增强，它专注于对集合对象进行各种非常便利、高效的聚合操作（aggregate operation），或者大批量数据操作 (bulk data operation)。

###Stream的操作可以分为两大类：中间操作、终结操作
中间操作:
    无状态（Stateless）操作：指元素的处理不受之前元素的影响
    有状态（Stateful）操作：指该操作只有拿到所有元素之后才能继续下去
终结操作:
    短路（Short-circuiting）操作：指遇到某些符合条件的元素就可以得到最终结果
    非短路（Unshort-circuiting）操作：指必须处理完所有元素才能得到最终结果

######流的构成
     获取一个数据源（source）→ 数据转换 → 执行操作获取想要的结果，
     每次转换原有Stream对象不改变，返回一个新的Stream 对象（可以有多次转换），
     
     对其操作可以像链条一样排列，变成一个管道。 
*/

class TestStream {
 //#####  无状态（Stateless）操作 
  //1
  //Stream<T> filter(Predicate<? super T> predicate);
  /*映射(map、flatMap、peek)
  //2map 将集合中的元素A转换成想要得到的B
    一个元素类型为 T 的流转换成元素类型为 R 的流,方法传入一个Function的函数式接口，接收一个泛型T，返回泛型R
    map函数的定义，返回的流，表示的泛型是R对象
    <R> Stream<R> map(Function<? super T, ? extends R> mapper);  
    map...

  //3接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
    与Map功能类似，区别在于将结合A的流转换成B流
    <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
     flatMapAAA....
  
  //4peek 操作接收的是一个 Consumer<T> 函数。
    peek 操作会按照Consumer<T>函数提供的逻辑去消费流中的每一个元素，同时有可能改变元素内部的一些属性。
    
    Stream<T> peek(Consumer<? super T action);
          //消费T类型元素 （T 本身的 void 方法，把 T 交给其它接口（类）的 void 方法进行处理）   

    peek 操作 一般用于不想改变流中元素本身的类型或者只想元素的内部状态时     
    而 map 则用于改变流中元素本身类型，即从元素中派生出另一种类型的操作。

  //5 无序化（unordered）
      操作不会执行任何操作来显式地对流进行排序。它的作用是消除了流必须保持有序的约束
      对于顺序流，顺序的存在与否不会影响性能，只影响确定性。如果流是顺序的，则在相同的源上重复执行相同的流管道将产生相同的结果;
      如果是非顺序流，重复执行可能会产生不同的结果。 对于并行流，放宽排序约束有时可以实现更高效的执行。
      在流有序时, 但用户不特别关心该顺序的情况下，使用 unordered 明确地对流进行去除有序约束可以改善某些有状态或终端操作的并行性能。

  */
  public void test1(){
    List<Integer> list = Arrays.asList(6,7,3,8,1,2);
    //通过 java.util.Collection.stream() 方法用集合创建流
    Stream<Integer> stream = list.stream();
    stream.filter(x->x>5).forEach(System.out::println);
  } 
  //
  public void test2(){
      //Stream的静态方法：of()、iterate()、generate()
      Stream.of("Andy:18","Henry:20").map(new Function<String,People>(){
           @Override
           public People apply(String s){
               String[] str = s.split(":");
               People people = new People(str[0],Integer.valueOf(str[1]));
               return people;      
           }
      }).forEach(people->System.out.println(people));
    /*list.stream().map(String::toUpperCase).collect(Collectors.toList());*/
  } 
  //
  public void test3(){
     List<String> l1 = Arrays.asList("m,k,l,a","1,3,5,7");
     List<String> l2 = l1.stream().flatMap(s->{
         String[] split = s.split(",");
         //使用java.util.Arrays.stream(T[] array)方法用数组创建流
         Stream<String> s2 = Arrays.stream(split);
         return s2;  
     }).collect(Collectors.toList());
      
     System.out.println(l1);
     System.out.println(l2); 
  }
  //
  public void test4(){
     Stream<String> stream = Stream.of("hello","world");
     stream.peek(System.out::println).collect(Collectors.toList());
     /*
     流的生命周期有三个阶段:
         起始生成阶段。
         中间操作会逐一获取元素并进行处理。可有可无。（所有中间操作都是惰性的，因此，流在管道中流动之前，任何操作都不会产生任何影响。）
         终端操作( 终端操作启动了流在管道中的流动 )
           通常分为 最终的消费 （foreach 之类的）和 归纳 （collect）两类。
     */
  }
//#####  无状态（Stateless）操作 
/*
 //6 distinct :  去重
 返回由该流的不同元素组成的流（根据 Object.equals(Object)）
 distinct（）使用hashCode（）和equals（）方法来获取不同的元素。
 类必须实现hashCode（）和equals（）方法。
 Stream<T> distinct();
 //7 sorted： 返回由该流的元素组成的流，并根据自然顺序排序
 Stream<T> sorted();
 Stream<T> sorted(Comparator<? super T> comparator);
 //8 limit：获取流中n个元素返回的流 
 Stream<T> limit(long maxSize);
 //9 skip：在丢弃流的第一个n元素之后，返回由该流的其余元素组成的流
 Stream<T> skip(long n);
*/
  public void test9(){
     Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9,0);
     stream.skip(3).forEach(System.out::println);
     /*
     流的生命周期有三个阶段:
         起始生成阶段。
         中间操作会逐一获取元素并进行处理。可有可无。（所有中间操作都是惰性的，因此，流在管道中流动之前，任何操作都不会产生任何影响。）
         终端操作( 终端操作启动了流在管道中的流动 )
           通常分为 最终的消费 （foreach 之类的）和 归纳 （collect）两类。
     */
  }

//##### 短路（Short-circuiting）操作
/*
//10 anyMatch：Stream 中只要有一个元素符合传入的 predicate，返回 true;
  boolean anyMatch(Predicate<? super T> predicate);
  ...
//#####非短路（Unshort-circuiting）操作
//11 forEach：该方法接收一个Lambda表达式，然后在Stream的每一个元素上执行该表达式
  void forEach(Consumer<? super T> action);
//12
  forEachOrdered：该方法接收一个Lambda表达式，然后按顺序在Stream的每一个元素上执行该表达式 
  void forEachOrdered(Consumer<? super T> action);
...
//13 collect：称为收集器，是一个终端操作,它接收的参数是将流中的元素累积到汇总结果的各种方式 

*/
}

class DriverStream {
    public static void main(String[] args){
     TestStream test = new TestStream();
     //test.test1();
     //test.test2();
     //test.test3();
     //test.test4();
     test.test9();
   
    }
}
//****************************************** */
//DataCls
class People {
    private String name;
    private int age;
    public People(String name, int age){
       this.name = name;
       this.age = age;
    }
    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return name + "-" + age ;
    }
}

//*************************************************************************************** */

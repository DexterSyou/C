import java.util.*;
import java.util.stream.*;

public class J8Stream2 {
    public static void main(String[] args){
        StreamTest st = new StreamTest();
        //st.test1();
        //st.test2();
        //st.test3();
        //st.test4();
        //st.test5();
        //st.test6();
        //st.test7();
        //st.test8();
        //st.test9();
        //st.test10();
        //st.test11();
        st.test12();

    }
}

class StreamTest {
   // 
   List<Person> personList = new ArrayList<Person>();
   //
   private void initPerson() {
      personList.add(new Person("张三", 8, 3000));
      personList.add(new Person("李四", 18, 5000));
      personList.add(new Person("王五", 28, 7000));
      personList.add(new Person("孙六", 38, 9000));
   }

   private void initPerson1() {
      personList.add(new Person("zhangsan",25, 3000, "male", "tieling"));
      personList.add(new Person("lisi",27, 5000, "male", "tieling"));
      personList.add(new Person("wangwu",29, 7000, "female", "tieling"));
      personList.add(new Person("sunliu",26, 3000, "female", "dalian"));
      personList.add(new Person("yinqi",27, 5000, "male", "dalian"));
      personList.add(new Person("guba",21, 7000, "female", "dalian"));
   }

//
   public void test1(){
      //1
      List<String> list = Arrays.asList("a", "b", "c");
      Stream<String> stream1 = list.stream();
      Stream<String> parallelStream = list.parallelStream();
      //2 
      int[] array={1,3,5,6,8};  
      IntStream stream2 = Arrays.stream(array);
      //3 
      Stream<Integer> stream31 = Stream.of(1, 2, 3, 4, 5, 6); 
      Stream<Integer> stream32 = Stream.iterate(0,(x)->x+3).limit(4);
      stream32.forEach(System.out::println);

      Stream<Double> stream33 = Stream.generate(Math::random).limit(3);
      stream33.forEach(System.out::println);
   }
//
   public void test2(){
    //  Stream中的元素是以 Optional类型存在的
     List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
     //
     System.out.println("--遍历输出符合条件的元素----------");
     list.stream().filter(x -> x > 6).forEach(System.out::print);
     Optional<Integer> findFirst = list.stream().filter(x -> x>6).findFirst();
     System.out.println("匹配第一个值：" + findFirst.get());
     Optional<Integer> findAny = list.parallelStream().filter(x -> x > 6).findAny();
     System.out.println("匹配任意一个值：" + findAny.get());
     boolean anyMatch = list.stream().anyMatch(x -> x < 6);
     System.out.println("是否存在大于6的值：" + anyMatch);
   }
//
   public void test3(){
       //
       initPerson();
       //java8 之前
       List<Person> list = new ArrayList<Person>();
       for(Person p : personList ){
           if(p.getAge() > 18){
               list.add(p);
           }
       }
       System.out.println("java8 之前" + list);
       //java8
       List<Person> j8collect =  personList.stream().filter(x->x.getAge()>18).collect(Collectors.toList());
       System.out.println("java8 " + j8collect);
   }
//
   public void test4(){
       List<String> list = Arrays.asList("zhangsan", "lisi", "wangwu", "sunliu");
       /*
       String max = "";
       int length = 0;
       int tempLength = 0;
       for(String str : list) {
          tempLength = str.length();
          if(tempLength > length) {
              length  = str.length();
              max = str;
          }
       } */
       //  
       Comparator<? super String> comparator = Comparator.comparing(String::length);
       Optional<String> max1 = list.stream().max(comparator);
       System.out.println(max1 + " " + max1.get());
        
       List<Integer> list1 = Arrays.asList(1, 17, 27, 7); 
       Optional<Integer> max2 = list1.stream().max(Integer::compareTo);
       Optional<Integer> max3 = list1.stream().max(new Comparator<Integer>() {
              @Override
              public int compare(Integer o1, Integer o2) {
                  return o1.compareTo(o2);
              }
       });
       System.out.println(max2); 

       //
       initPerson();
       Comparator<? super Person> comparatorAge  = Comparator.comparingInt(Person::getAge);
       Optional<Person> maxP = personList.stream().max(comparatorAge);
       System.out.println(maxP);
       System.out.println(maxP.get().getAge());
   }
//
   public void test5(){
       List<Integer> list = Arrays.asList(1, 17, 27, 7); 
       long count = list.stream().filter(x -> x>10).count();
       System.out.println(count);
   }
//
   public void test6(){
       // map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
       // flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
       List<String> list = Arrays.asList("zhangsan", "lisi", "wangwu", "sunliu");
       list.stream().forEach(t->t.toUpperCase());
       List<String> collect1 = list.stream().map(t->t.toUpperCase()).collect(Collectors.toList());
       List<String> collect2 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
       System.out.println(collect1);
       System.out.println(collect2);

       //
       List<Integer> list3 = Arrays.asList(1, 17, 27, 7);
       List<Integer> collect3 = list3.stream().map(x -> x + 3).collect(Collectors.toList());
       System.out.println(collect3);
       //
       initPerson();
       List<Person> collectP = personList.stream()
                                         .map(x -> { x.setSalary(x.getSalary()+2000); return x; } )
                                         .collect(Collectors.toList());
       System.out.println(collectP);
       // 将两个字符数组合并成一个新的字符数组
       String[] arr = {"z, h, a, n, g", "s, a, n"};
       List<String> listArr = Arrays.asList(arr);
       System.out.println(listArr);
       List<String> collectArr = listArr.stream().flatMap(x -> {
             String[] array = x.split(",");
             Stream<String> stream = Arrays.stream(array);
             return stream;
             }).collect(Collectors.toList());
       System.out.println(collectArr);
   }
   public void test7(){
       List<Integer> list = Arrays.asList(1, 2, 3, 4);
       Optional<Integer> reduce = list.stream().reduce((x,y) -> x + y);
       System.out.println("求和:"+reduce);
       Optional<Integer> reduce2 = list.stream().reduce((x,y) -> x * y);
       System.out.println("求积:"+reduce2);
       Optional<Integer> reduce3 = list.stream().reduce((x,y) -> x>y?x:y);
       System.out.println("求最大值:"+reduce3); 
       //
       initPerson();
       Optional<Integer> reduceP1 = personList.stream().map(Person :: getSalary).reduce(Integer::sum);
       Optional<Integer> reduceP2 = personList.stream().map(Person :: getSalary).reduce(Integer::max);
       System.out.println("工资之和:"+reduceP1);
       System.out.println("最高工资:"+reduce2);
   }

   public void test8(){
        // 收集（toList、toSet、toMap）
        initPerson();
        Map<String, Person> collectM = personList.stream()
                                      .filter(x -> x.getAge() > 18)
                                      .collect(Collectors.toMap(Person::getName, y -> y));
        System.out.println(collectM);
   }  


   public void test9(){
     // Collectors提供了一系列用于数据统计的静态方法：
     initPerson();
     //统计员工人数
     Long count = personList.stream().collect(Collectors.counting());
     System.out.println("统计员工人数:"+count);
     //求平均工资
     Double average = personList.stream().collect(Collectors.averagingInt(Person::getSalary));
     System.out.println("求平均工资:"+average);
     //求最高工资
     Optional<Integer> max = personList.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compare));
     System.out.println("求最高工资:"+max);
     //求工资之和
     Integer sum = personList.stream().collect(Collectors.summingInt(Person::getSalary));
     System.out.println("求工资之和:"+sum); 
     //一次性统计所有信息
     IntSummaryStatistics collect = personList.stream().collect(Collectors.summarizingInt(Person::getSalary));
     System.out.println("一次性统计所有信息:"+collect);
   }

   public void test10(){
        // 分区：将stream按条件分为两个 Map，比如员工按薪资是否高于8000分为两部分。
        // 分组：将集合分为多个Map，比如员工按性别分组。有单级分组和多级分组。
        initPerson1();
        Map<Boolean, List<Person>> part = personList.stream()
                                                    .collect(Collectors.partitioningBy(x -> x.getSalary() > 8000)); 
        System.out.println("员工按薪资是否大于8000分组情况：" + part);
        System.out.println("-->" + part.keySet());
        System.out.println("-->" + part.get(Boolean.FALSE));
        //
        Map<String, List<Person>> group = personList.stream()
                                                    .collect(Collectors.groupingBy(Person::getSex));
        System.out.println("员工按性别分组情况：" + group);
        Map<String, Map<String, List<Person>>> group2 = personList.stream()
              .collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
        System.out.println("员工按性别、地区：" + group2);

   }
   //
   public void test11(){
       initPerson();
       //
       String names = personList.stream().map(p->p.getName())
                                         .collect(Collectors.joining(","));
       System.out.println("NAME：" + names);                                    
   }

   public void test12(){
    //排序sorted
    initPerson();
    // 按工资升序排序（自然排序）
    List<String> newList = personList.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName)
            .collect(Collectors.toList());
    // 按工资倒序排序
    List<String> newList2 = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed())
            .map(Person::getName).collect(Collectors.toList());
    // 先按工资再按年龄升序排序
    List<String> newList3 = personList.stream()
            .sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge)).map(Person::getName)
            .collect(Collectors.toList());
    // 先按工资再按年龄自定义排序（降序）
    List<String> newList4 = personList.stream().sorted((p1, p2) -> {
        if (p1.getSalary() == p2.getSalary()) {
            return p2.getAge() - p1.getAge();
        } else {
            return p2.getSalary() - p1.getSalary();
        }
    }).map(Person::getName).collect(Collectors.toList());
 
    System.out.println("按工资升序排序：" + newList);
    System.out.println("按工资降序排序：" + newList2);
    System.out.println("先按工资再按年龄升序排序：" + newList3);
    System.out.println("先按工资再按年龄自定义降序排序：" + newList4);
   
   
   
      String[] arr1 = { "a", "b", "c", "d" };
      String[] arr2 = { "d", "e", "f", "g" };
      Stream<String> stream1 = Stream.of(arr1);
      Stream<String> stream2 = Stream.of(arr2);
      // concat:合并两个流 distinct：去重
      List<String> c1 = Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());
      // limit：限制从流中获得前n个数据
      List<Integer> c2 = Stream.iterate(1, x -> x + 2).limit(10).collect(Collectors.toList());
      // skip：跳过前n个数据
      List<Integer> c3 = Stream.iterate(1, x -> x + 2).skip(1).limit(5).collect(Collectors.toList());
      System.out.println("流合并：" + c1);
      System.out.println("limit：" + c2);
      System.out.println("skip：" + c3);
   }   
}
//*********************************************************** */
class Person {
    private String  name;
    private Integer age;
    private Integer salary;
    private String  sex;
    private String  area;

    public Person(String name, Integer age, Integer salary ){
        this.name   = name;
        this.age    = age;
        this.salary = salary;
    }

    public Person(String name, Integer age, Integer salary ,String sex,String area){
        this.name   = name;
        this.age    = age;
        this.salary = salary;
        this.sex    = sex;
        this.area  = area;
    }

    public String getName(){
        return name;
    }
    public Integer getAge(){
        return age;
    }
    public Integer getSalary(){
        return salary;
    }
    public String getSex(){
        return sex;
    }
    public String getArea(){
        return area;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(Integer age){
        this.age = age;
    }
    public void setSalary(Integer salary){
        this.salary = salary;
    }
    //
    public String toString(){
        return " {" + " NAME:"  + name 
                   + ", AGE:"  + age
                   + ", SAL:"  + salary 
                   + "} ";
    }
}


//*********************************************************** */
   /*
    Stream 
     从支持数据处理操作的源生成元素序列.数据源可以是集合,数组或IO资源
     从操作角度来看,流与集合是不同的. 流不存储数据值; 流的目的是处理数据
   
     Stream可以由数组或集合创建，对流的操作分为两种：
          中间操作，每次返回一个新的流
          终端操作，每个流只能进行一次终端操作，终端操作结束后流无法再次使用。终端操作会产生一个新的集合或值。

     特性：
        不是数据结构，不会保存数据。 
        不会修改原来的数据源，它会将操作后的数据保存到另外一个对象中。（peek方法可以修改流中元素）
        惰性求值，流在中间处理过程中，只是对操作进行了记录，并不会立即执行，需要等到执行终止操作的时候才会进行实际的计算。    

     无状态：指元素的处理不受之前元素的影响
     有状态：指该操作只有拿到所有元素之后才能继续下去
     非短路操作：指必须处理所有元素才能得到最终结果
     短路操作：指遇到某些符合条件的元素就可以得到最终结果，如 A || B，只要A为true，则无需判断B的结果。  
   */ 

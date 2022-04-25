import java.util.function.*;
import java.util.*;
public class J8MthRef{}
//*************************************
class TestMthRef{
  //方法引用，lambda表达式运用到已有的其他实例方法
  //
  //#抽象式接口中抽象方法的函数参数类型，返回值类型与 lambda体表达式的函数参数类型，返回值类型一致
  public void test1(){
     /* 对象::实例方法*/
     Consumer<String> con = (x)->System.out.println(x);
	 Consumer<String> con1 = System.out::println;
	 con1.accept("abcdef");
     
	 Employee emp = new Employee();
	 Supplier<Integer> sup = ()-> emp.getAge();
	 Supplier<Integer> sup1 = emp::getAge;
	 System.out.println(sup1.get());
  }
  //
  public void test2(){
	/* 类::静态方法名*/  
    Comparator<Integer> com = (x,y)->Integer.compare(x,y);
	Comparator<Integer> com1 = Integer::compare;
  }
  //
  public void test3(){
    /* 类::实例方法名*/
	BiPredicate<String,String> bo = (x,y)->x.equals(y);
	//lambda的第一个参数是调用者，第二个参数为第一个参数的的调用参数
    BiPredicate<String,String> bp2 = String::equals;
  }

  //构造器引用
  //ClassName::new
  public void testContRef(){

     Supplier<Employee> sup = ()-> new Employee();
	 Supplier<Employee> sup2 = Employee::new;
	 Employee emp = sup2.get();
	 System.out.println(emp);

     Function<Integer,Employee> fun = (x)->new Employee(x);
	 Function<Integer,Employee> fun1 = Employee::new;
	 System.out.println(fun1);

	 BiFunction<Integer,Integer,Employee> bifun = Employee::new;
	 System.out.println(bifun);
  }
  //数组引用
  //Type[]::new
  public void testAryRef(){
     Function<Integer,String[]> fun = (x)->new String[x];
     String[] strs = fun.apply(10);
     System.out.println(strs.length);
   
	 Function<Integer,String[]> fun1 = String[]::new; 
     System.out.println(fun1.apply(20).length);
  }
}
//************************************************************
class DriverMthRef{
  public static void main(String[] args){
	  TestMthRef test = new TestMthRef();
	  test.test1();
	  test.test2();
	  test.test3();
	  test.testContRef();
	  test.testAryRef();
  }
}
//************************************************************
class Employee {
     private String name;
	 private int id;
     private int age;
     public Employee(){}
	 public Employee(int id){ this.id = id;}
	 public Employee(int id,int age){
	   this.id = id;
	   this.age = age;
	 }
	 public Employee(String name, int age){
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
         return id + "_"+name + "_" + age ;
     }
}


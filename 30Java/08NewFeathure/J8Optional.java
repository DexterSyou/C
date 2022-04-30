import java.util.Optional;
class J8Optional{}
//************************************************************ */
class TestOptional {
  /*Optional是一个容器类，代表一个值存在 或 不存在
    of()             创建一个Optional实例
    empty()          创建一个空的Optional实例
    ofNullable(T t)  T不为null，创建Optional实例，否则创建空Optional实例
    ifPresent()      判断是否有值
    orElse(T t)      如果对象包含值返回该值，否则返回t  */
  public void test1(){
    //1  
      Optional<Employee> op1 = Optional.of(new Employee());
      Employee emp1 = op1.get();
      System.out.println(emp1);
    //2
      Optional<String> str = Optional.empty();
      if(str.isPresent()){
         //Exception in thread "main" java.util.NoSuchElementException: No value present
         System.out.println(str.get()); 
      }else{
         System.out.println("NoSuchElemen");
      }
    //3   
      Optional<Employee> op2 = Optional.ofNullable(null);
      Employee emp3 = op2.orElse(new Employee(1));
      System.out.println(emp3);
  }
  /*Optional是一个容器类，代表一个值存在 或 不存在
    orElseGet(Supplier s)  函数式接口的orElse
    map(Function f) 如果有值，返回处理后的Optional，否则返回Optional.empty()
    flatMap(Fucntion mapper) 与map一样，返回值必须是Optional   */
  public void test2(){
     //1
     Optional<Employee> op1 = Optional.ofNullable(new Employee("Andy",13));
     Optional<String> str1 = op1.map((e)->e.getName());
     System.out.println(str1);
     //2
     Optional<Employee> op2 = Optional.ofNullable(new Employee("Hacky",23));
     Optional<String> str2 = op2.flatMap((e)->Optional.of(e.getName()));
     System.out.println(str2);
  }
  //
  public void testApply(){
      Employee e = new Employee();
      //e.getGogogo().show(); //java.lang.NullPointerException
      Optional<Target> t = Optional.ofNullable(e.getGogogo());
      Target tt = t.orElse(new Target());
      tt.show();
  }
}
//
class DriverOptional {
  public static void main(String[] args){
     TestOptional test = new TestOptional();
     test.test1();
     test.test2();
     test.testApply();
  }
}
//*******************************************************************
class Employee {
    private String name;
	private int id;
    private int age;
    private Target gogogo=null;
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
    public Target getGogogo(){
         return gogogo;
    }
    public String toString(){
         return id + "_"+name + "_" + age ;
    }
}

class Target {
   void show(){
       System.out.println("Cls Target : Show.....");
   }
}

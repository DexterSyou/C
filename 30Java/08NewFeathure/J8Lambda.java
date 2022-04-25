import java.util.*;
public class J8Lambda {}
//********************************* */
/*函数式接口
    只包含一个抽象方法的接口，称为函数式接口。*/
//
@FunctionalInterface
interface MyFunc<T> {
    public T getValue(T t);
}

@FunctionalInterface
interface MyFuncTwoG<T,R> {
    public R getValue(T t1,T t2);
}
//
@FunctionalInterface
interface MyFunction {
    public String getValue(String str);
}
//
class TestLambda {   
    //
    protected List<Employee> employees = Arrays.asList(
        new Employee("张三", 18, 9999.99),
        new Employee("李四", 38, 5555.55),
        new Employee("王五", 60, 6666.66),
        new Employee("赵六", 8, 7777.77),
        new Employee("田七", 58, 3333.33)
    );
    //一个操作字符串的方法，其中参数为MyFunc接口实例和需要转换的字符串
     public String handlerString(MyFunc<String> myFunc,String str){
        return myFunc.getValue(str);
     }
    //待处理的字符串和函数式接口的实例，方法中的逻辑就是调用函数式接口的方法来处理字符串 
     public String stringHandler2(String str, MyFunction myFunction){
          return myFunction.getValue(str);
     }
    //
     public void operate(Long num1, Long num2, MyFuncTwoG<Long,Long> myFuncTwoG){
         System.out.println(myFuncTwoG.getValue(num1,num2));
     } 
    //Test1 
     public void test1(){
        //作为参数传递 Lambda 表达式
        //为了将 Lambda 表达式作为参数传递，接收Lambda表达式的参数类型必须是与该Lambda 表达式兼容的函数式接口的类型 
        String str = handlerString((s)->s.toUpperCase(),"helloworld");
        System.out.println(str);
        
        str = handlerString((s)->s.substring(0,4),"helloworld");
        System.out.println(str);

    }
    //Test2
     public void test2(){
        Collections.sort(employees,(e1,e2)->{
            if(e1.getAge()==e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }
            return Integer.compare(e1.getAge(),e2.getAge()); 
        });
        employees.stream().forEach(System.out::println);
    }
    //Test3
     public void test3(){
       String value = stringHandler2("handler",(s) -> s.toUpperCase());
       System.out.println(value);
       value = stringHandler2("handler", (s) -> s.substring(1, 3)); 
       System.out.println(value);
    }
    //Test4
     public void test4(){
       operate(100L,200L,(x,y)->x+y);
       operate(100L,200L,(x,y)->x*y);
    }

}

class DriverLambda{
    public static void main(String[] args){
        TestLambda test = new TestLambda();
        test.test1();
        test.test2();
        test.test3();
        test.test4();

    }
}

//************************************************* */
class Employee{
    private String name;
    private int age;
    private double saraly;
    
    public Employee(String name,int age, double saraly){
        this.name = name;
        this.age = age;
        this.saraly = saraly;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public double getSaraly(){
        return saraly;
    }
}

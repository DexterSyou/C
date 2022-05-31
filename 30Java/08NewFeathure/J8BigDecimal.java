
import java.math.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
//
public class J8BigDecimal {

   public static void main(String[] args){

        TestBigDecimal tbd = new TestBigDecimal();
       // tbd.test1();
       // tbd.test2();
       // tbd.test3();
       // tbd.test4();
          tbd.test5();
  
   }
  

}
//********************************* */
class TestBigDecimal {
  
   public void test1(){
      BigDecimal a =new BigDecimal(0.1); // 参数类型为double的构造方法的结果有一定的不可预知性
                                         // 先使用Double.toString(double)方法，
                                         // 然后使用BigDecimal(String)构造方法，将double转换为String。
      System.out.println("a values is:"+a);
      System.out.println("=====================");
      BigDecimal b =new BigDecimal("0.1"); //BigDecimal(String) 构造方法是完全可预知的
      System.out.println("b values is:"+b);
   }

   public void test2(){
        NumberFormat currency = NumberFormat.getCurrencyInstance(); //建立货币格式化引用 
        NumberFormat percent = NumberFormat.getPercentInstance();  //建立百分比格式化引用 
        percent.setMaximumFractionDigits(3); //百分比小数点最多3位 
        BigDecimal loanAmount = new BigDecimal("15000.48"); //贷款金额
        BigDecimal interestRate = new BigDecimal("0.008"); //利率   
        BigDecimal interest = loanAmount.multiply(interestRate); //相乘
        System.out.println("贷款金额:\t" + currency.format(loanAmount)); 
        System.out.println("利率:\t" + percent.format(interestRate)); 
        System.out.println("利息:\t" + currency.format(interest));
   }

   public void test3(){
        Person p1 = new Person("55", new BigDecimal("45.23"),new BigDecimal("1.23"));
		Person p2 = new Person("55", new BigDecimal("55.43"),new BigDecimal("5.23"));
		Person p3 = new Person("56", new BigDecimal("65.21"),new BigDecimal("3.23"));
		Person p4 = new Person("57", new BigDecimal("35.73"),new BigDecimal("1.23"));
		List<Person> list = Arrays.asList(p1, p2, p3, p4);
		
        BigDecimal sum = list.stream().map(Person::getNm)
		                     .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("BigDecimal sum> :"+sum);
        BigDecimal sum1 = list.stream().filter(p->p.getEdicd().equals("55")).map(Person::getNm)
		                     .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("BigDecimal 55>  :"+sum1);
        BigDecimal sum2 = list.stream().filter(p->p.getEdicd().equals("56")).map(Person::getZe)
		                     .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("BigDecimal 56>  :"+sum2);
   }

   public void test4(){
     List<String> list = Arrays.asList("12345", "12345234", "82319", "12321","23561");
     BigDecimal sum = list.stream()
     .map(s->s.substring(1,2)).peek(e->System.out.println(e))
     .map(BigDecimal::new).reduce(BigDecimal.ZERO, BigDecimal::add);
     System.out.println(sum);
   }

   public void test5(){
       BigDecimal bdNum1 = new BigDecimal("23.3693"); 
       resVal1 = bdNum1.setScale(0, BigDecimal.ROUND_UP); //ROUND_UP 向上取整（
       System.out.println(resVal1);

       BigDecimal bdNum2 = new BigDecimal("-23.3693"); 
       resVal2 = bdNum2.setScale(0, BigDecimal.ROUND_UP);
       System.out.println(resVal2);
       //ROUND_DOWN 向下取整
       //ROUND_CEILING 向大取整（比原数值大的方向） ROUND_FLOOR 向小取整
       
       //ROUND_HALF_UP (四舍五入) 向“最接近的”数字舍入
       BigDecimal bdNum3 = new BigDecimal("23.3693");
       resVal3 = bdNum3.setScale(0, BigDecimal.ROUND_HALF_UP);
       System.out.println(resVal3);
       BigDecimal bdNum4 = new BigDecimal("23.5");
       resVal4 = bdNum4.setScale(0, BigDecimal.ROUND_HALF_UP);
       System.out.println(resVal4);
       //ROUND_HALF_EVEN ROUND_UNNECESSARY 
   }
 
}
//********************************* */
class Person {
	private String edicd;
	private BigDecimal nm; // String soshinData;
    private BigDecimal ze; // String soshinData;

	public Person(String edicd, BigDecimal nm, BigDecimal ze) {
		this.edicd = edicd;
		this.nm = nm;
        this.ze = ze;
	}
	public String getEdicd() {
		return edicd;
	}
	public BigDecimal getNm() {
		return nm;
	}
    public BigDecimal getZe() {
		return ze;
	}
} 

/****



*/





public class P4Constructor {

    public static void main(String []args){
       //
       new Sandwich();
/* 调用基类构造器，反复递归下去
 * 按声明顺序调用成员的初始化方法
 * 调用到处类构造器的主体
 */
	}

}

//*******************************************

class Meal{
  Meal(){ System.out.println("Meal()");}
}

class Bread{
  Bread(){System.out.println("Bread()");}
}

class Cheese{
  Cheese(){System.out.println("Cheese()");}
}

class Lettuce{
  Lettuce(){System.out.println("Lettuce()");}
}

class Lunch extends Meal{
  Lunch(){System.out.println("Lunch()");}
}

class PortableLunch extends Lunch{
  PortableLunch(){System.out.println("PortableLunch()");}
}

class Sandwich extends PortableLunch{
    private Bread   b = new Bread();
    private Cheese  c = new Cheese();
	private Lettuce l = new Lettuce();
    public Sandwich(){
	  System.out.println("Sandwich()"); 
	}
}
//EB
class Pickle{}





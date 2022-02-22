import java.util.*;

public class P3This {


  public static void main(String []args){
    Banana a = new Banana();
	Banana b = new Banana();
    a.peel(1); //Banana.peel(a,1);
	b.peel(2); //Banana.pell(b,2);
   /*
	* this：
	*   只能在方法内部使用
	*   表示 调用方法的那个对象 的引用
	*   当前方法中的this引用会自动应用于同一类中的其他方法
	*/
    //
    Leaf x = new Leaf();
	x.increment().increment().increment().print();
    //PassingThis
	new Person().eat(new Apple());
	//Construct This
	Flower f = new Flower();
	f.printPetalCount();
  }

}

class Banana{
   void peel(int i){
     /** */
   }
}

class Apricot{
   void pick(){}
   void pit(){ pick();}//编译器自动添加this
}

class Leaf{
   int i=0;
   
   Leaf increment(){
      i++;
	  return this; //返回当前对象
   }

   void print(){
      System.out.println("i = " + i);
   }
}

class Person{
   public void eat(Apple apple){
     Apple peeled = apple.getPeeled();
	 System.out.println("Yummy");
   }
}

class Peeler{
   static Apple peel(Apple apple){
      return apple;
   }
}

class Apple{
  
	Apple getPeeled(){
	  return Peeler.peel(this);
	}
}

//Construct This
class Flower{
  
	int petalCount = 0;
	String s = "initial value";
 
	Flower(int petals){
	   petalCount = petals;
	   System.out.println("Construct w/ int arg only, petalCount= "+petalCount);
	}
	Flower(String ss){
	   System.out.println("Construct w/ String arg only, s= " + ss);
	   s=ss;
	}

    Flower(String s, int petals){
	   this(petals);
	   //! this(s); 禁止调用两遍
	   this.s = s;
	   System.out.println("String & int args");
	}

	Flower(){
	   this("hi",47);
       System.out.println("Default constructor (no args)");
	}
     
    void printPetalCount(){
	   //!this(11); 编译器禁止其他地方调用构造器，只能在构造器中
	   System.out.println("petalCount = "+ petalCount + " s= "+ s);
	}  
}










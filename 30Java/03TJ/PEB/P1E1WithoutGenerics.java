import java.util.*;

/*Java SE5之前的容器的一个主要问题就是编译器允许你向容器中插入不正确的类型*/
public class P1E1WithoutGenerics {

    @SuppressWarnings("unchecked")
    public static void main(String []args){

		ArrayList apples = new ArrayList();
		for(int i=0;i<3;i++)
			apples.add(new Apple());
		apples.add(new Orange());
		for(int i=0;i<apples.size();i++)
			((Apple)apples.get(i)).id();
		//Orange is detected only at run time
        //Orange cannot be cast to Apple
	}

}
//*******************************************
class WithGenerics {
  
    public static void main(String []args){
        //<类型参数>
		//编译时期，阻止你加入错误类型
		ArrayList<Apple> apples = new ArrayList<Apple>();
		for(int i=0;i<3;i++)
			apples.add(new Apple());
		for(int i=0;i<apples.size();i++)
		   //List知道保存的类型，不需要转换
		   System.out.print(apples.get(i).id());
	    for(Apple c : apples){
		   System.out.print(c.id());
		}
	}
}
//*******************************************
class GenericsAndUpcasting {

	public static void main(String[] atgs){
	   ArrayList<Apple> apples = new ArrayList<Apple>();
	   apples.add(new GrannySmith());
	   apples.add(new Gala());
	   apples.add(new Fuji());
	   apples.add(new Braeburn());
	   for(Apple c : apples){
	     System.out.println(c);
	   }
	}
}

//*******************************************
class Apple {
  private static long counter;
  private final long id = counter++;
  public long id(){ return id;}
}

class Orange{}

class GrannySmith extends Apple{}
class Gala extends Apple{}
class Fuji extends Apple{}
class Braeburn extends Apple{}

//********************************************
//E1
class E1 {
  public static void main(String[] args){
     ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
	 for(int i=0;i<5;i++){
	   gerbils.add(new Gerbil());
	 }

	 for(Gerbil g : gerbils){
	   g.hop();
	 }
  }
} 
class Gerbil {
  private int gerbilNumber;
  public Gerbil(){
    gerbilNumber = 100;
  }
  public void hop(){
    System.out.println("gerbilNumber: "+gerbilNumber+" is jumpping");
  }
}




import java.util.*;

public class P1WithoutGenerics {

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
/*Java SE5之前的容器的一个主要问题就是编译器允许你向容器中插入不正确的类型
 *
 */
//*******************************************
class Apple {
  private static long counter;
  private final long id = counter++;
  public long id(){ return id;}
}

class Orange{}


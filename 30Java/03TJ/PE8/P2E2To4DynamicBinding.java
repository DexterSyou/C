import java.util.*;
public class P2E2To4DynamicBinding {

    public static void main(String []args){

    }

}

//******************************************
//java 除了static，final方法外，其他所有方法都是后期绑定（自动发生）
//方法调用机制能找到正确的方法体

class Shape{
  //E3
  public void show(){
    System.out.println("Shape.show().");
  }
  public void draw(){}
  public void erase(){}
}

class Circle extends Shape{
  //E3
  public void show(){
    System.out.println("Circle.show().");
  }
  //E2
  @Override
  public void draw(){System.out.println("Circle.draw().");}
  @Override
  public void erase(){System.out.println("Circle.erase().");}
}

class Square extends Shape{
  //!E3	
  @Override
  public void draw(){System.out.println("Square.draw().");}
  @Override
  public void erase(){System.out.println("Square.erase().");}
}

class Triangle extends Shape{
  //!E3
  @Override
  public void draw(){System.out.println("Square.draw().");}
  @Override
  public void erase(){System.out.println("Square.erase().");}
}

//E4
class Line extends Shape{
  
  @Override
  public void draw(){System.out.println("Line.draw().");}
  @Override
  public void erase(){System.out.println("Line.erase().");}
}

class RandomShapeGenerator {
   private Random rand = new Random(47);
   public Shape next(){
      switch(rand.nextInt(3)){
	    default:
		case 0: return new Circle();
		case 1: return new Square();
		case 2: return new Triangle();
	  }
   }
}

class Shapes{

  private static RandomShapeGenerator gen = new RandomShapeGenerator();
  public static void main(String[] args){
    Shape[] s = new Shape[9];
	for(int i=0;i<s.length;i++){
	  s[i] = gen.next();
	}

	for(Shape shp : s){
	   //E3
	   shp.show();
	   shp.draw();//动态绑定编译器不需要知道任何特殊信息
	}

	Shape s1 = new Line();
	s1.draw();
	s1.erase();
  }
}



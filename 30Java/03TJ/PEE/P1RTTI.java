
import java.util.*;
public class P1RTTI {}
//************************************************************************ */
/*RTTI : 运行时，识别一个对象的类型      
   当从数组中取出元素时，这种容器，实际上将所有的事物都当作Object持有，会自动将结果转型回Shape
   这是RTTI最基本的使用形式：
        java，所有的类型转换都是在运行时进行正确检查的  
*/
//************************************************************************ */
abstract class Shape {
    void draw() { System.out.println(this + ".draw()"); }
    abstract public String toString();
} 
class Circle extends Shape {
    public String toString() { return "Circle";  }
}
class Square extends Shape {
    public String toString() { return "Square";  }
}
class Triangle extends Shape {
    public String toString() {return "Triangle"; }
}
class Shapes {
    public static void main(String[] args){
        List<Shape> shapeList = Arrays.asList(new Circle(),new Square(),new Triangle());
        /*
         编译时： 容器与泛型来强制确保这一点
         运行时： 由类型转换操作来确保这一点
        */
        //Object --> Shape
        for(Shape shape : shapeList){
            shape.draw();
        } 
    }
}
//************************************************************************ */

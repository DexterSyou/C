public class P7DBConstructor {

    public static void main(String []args){
       new RoundGlyph(5);
    }

}

//*******************************************
class Glyph{

	void draw(){System.out.println("Glyph.draw()");}

	Glyph(){
	  System.out.println("Glyph() before draw()");
	  draw();
	  System.out.println("Glyph() after draw()");
	}
}

class RoundGlyph extends Glyph{
   private int radius = 1;
   RoundGlyph(int r){
      radius = r;
      System.out.println("RoundGlyph.RoundGlyph(), radius=" + radius);	
   }
   void draw(){
     System.out.println("RoundGlyph.draw(), radius = " + radius);
   }
}
//E15
/*
 * 初始化：
 *     1.在其他任何事物发生之前，将分配给对象的存储空间初始化成二进制的零
 *     2.调用基类构造器，调用导出类的draw方法（由于1，radius的值为0）
 *     3.按照声明的顺序调用成员的初始化方法
 *     4.调用导出类的构造主体
 *
 *
 *
 */

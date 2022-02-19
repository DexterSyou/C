import java.util.*;
public class P1CastingNumbers {

    public static void main(String []args){

       double above = 0.7,   below = 0.4;
	   float fabove = 0.7f, fbelow = 0.4f;
	   System.out.println("(int)above"+(int)above);
	   System.out.println("(int)below"+(int)below);
//	   System.out.println("float fabove"+fabove);
//	   System.out.println("float below"+fbelow);
	   System.out.println("(int)fabove"+(int)fabove);
	   System.out.println("(int)fbelow"+(int)fbelow);

	   //强转型是执行截尾
	   //byte char short运算时，只要比int小，会自动提升int型
	}

}

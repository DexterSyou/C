import java.util.*;

public class P7AryInit {


    public static void main(String []args){
     //ArraysOfPrimitives
	 int[] a1={1,2,3,4,5};//等价于new，由编译器负责
	 int[] a2;
	 a2=a1;
	 for(int i=0;i<a2.length;i++)
		 a2[i]=a2[i]+1;
	 for(int i=0;i<a1.length;i++)
         System.out.println("a1["+i+"] =" +a1[i]);

	 //newArray
	 int[] a3;
	 Random rand = new Random(47);
     a3 = new int[rand.nextInt(20)];//运行时创建数组
	 System.out.println("Length of a = " + a3.length);
	 //数组元素中的基本数据类型值会自动初始化成空值
	 System.out.println(Arrays.toString(a3));

	 //初始化
	 /*
	  Integer[] a = new Integer[rand.nextInt(20)]; #一个引用数组而已
	  for(int i=0;i<a.length;i++){
	    a[i]=rand.nextInt(500);  //创建引用对象，并把对象赋值给引用，初始化进程才结束
	  }


      Integer[] a = new Integer[]{
	     1,
		 2,
		 3,
	  };
	  */
	}
}

//数组初始化
/*数组创建相应空间，必须初始化
 *编译器不允许指定数组的大小 
 *int[] a； a为一个引用
 */








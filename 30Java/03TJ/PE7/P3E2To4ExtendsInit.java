 public class P3E2To4ExtendsInit{

   public static void main(String[] args){
       Cartoon x = new Cartoon();
   }

}

 class Art{
    Art(){
        System.out.println("Art Constructor");
    }
}

class Drawing extends Art{

    Drawing(){
        System.out.println("Drawing Constructor");
    }
}

class Cartoon extends Drawing {
//E2To4
// 编译器默认合成构造器，并调用基类构造器
// 总是会被调用且在导出类之前调用
//基类先初始化好
/* public Cartoon(){
        System.out.println("Cartoon Constructor");
    }
*/

}
/*
在构造器中调用基类构造器来执行初始化，基类构造器具有执行基类初始化所需要的所有知识和能力
java自动的在导出类的构造器中插入对基类构造器的调用

*/

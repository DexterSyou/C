public class PDInherInnerCls {

    public static void main(String []args){

    }

}

//*******************************************
class WithInner {
  class Inner{}
}
/* 内部类的构造器必须链接到指向其外围类对象的引用
 * 使用特殊语法来说明它们之间的关联，指向外围类的引用必须初始化
 */
class InherirInner extends WithInner.Inner {
  //！InherirInner(){}
  InherirInner(WithInner wi){
     wi.super();//必须的
  }

  public static void main(String[] args){
     WithInner    wi = new WithInner();
	 InherirInner ii = new InherirInner(wi);
  }
}

//E26
class EQ {
  class EQInner { 
    EQInner(int i){
	  System.out.println(i);
	}
  }
}

class EQAnotherCls {
  class EQAnotherClsInner extends EQ.EQInner{
    EQAnotherClsInner(EQ eq){
	  // eq.super();
	  //constructor EQInner in class EQ.EQInner cannot be applied to given
	  eq.super(10);
	}
  } 
}






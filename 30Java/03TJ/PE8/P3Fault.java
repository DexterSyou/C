public class P3Fault {
}

//*******************************************
class PrivateOverride{
  //只有非private方法才能被覆盖
  private void f(){ System.out.println("private f()");}

    public static void main(String []args){
        PrivateOverride po = new Derived();
		po.f();
    }
}

class Derived extends PrivateOverride{
  public void f(){ System.out.println("public f().");}
}

//只有普通方法是可以多态（动态绑定）
//任何域访问操作都将由编译器解析的
class Super{
  public int field = 0;
  public int getField(){ return field;}
}

class Sub extends Super{
  public int field = 1;
  public int getField(){return field;}
  public int getSuperField(){return super.field;}
}

class FieldAccess {
    public static void main(String[] args){
	  Super sup = new Sub();
	  System.out.println("sup.field = " + sup.field + ", sup.getField() = " + sup.getField());
	  Sub sub = new Sub();
	  System.out.println("sub.field = " +
			  sub.field +", sub.getField() = " + 
			  sub.getField() + ", sub.getSuperField() = " +
			  sub.getSuperField());
	} 
}

//
class StaticSuper {
   public static String staticGet(){
      return "Base staticGet()";
   }
   public String dynamicGet(){
     return "Base dynamicGet()";
   }
}

class StaticSub extends StaticSuper{
   public static String staticGet(){
     return "Derived staticGet()";
   }
   public String dynamicGet(){
     return "Derived dynamicGet()";
   }
}

class StaticPolymorphism{
   // 静态方法是类的，不具有多态性
   public static void main(String[] args){
       StaticSuper sup = new StaticSub();
	   System.out.println(sup.staticGet());
	   System.out.println(sup.dynamicGet());
   }
}






















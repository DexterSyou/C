public class P3E4_5ThisNew {
   
   public static void main(String[] args){
     //
     DotThis dt = new DotThis();
     DotThis.Inner dti = dt.inner();
     dti.outer().f();
     //E5
     DotNew dn = new DotNew();
     DotNew.Inner dni = dn.new Inner(); //创建内部类 //！dn.new DotNew.Inner()
     //Must use instance of outer class to create an instance of the inner class
     Parcel3 p = new Parcel3();
     Parcel3.Contents c = p.new Contents();
     Parcel3.Destination d = p.new Destination("Tasmania");
   }
}

//**********************
class DotThis {
    void f() { System.out.println("DotThis.f()");}

    public class Inner {
        public DotThis outer() {
            return DotThis.this;//编译时期，对外部类的引用
        }
    }

    public Inner inner(){
        return new Inner();
    }
}

//**********************
class DotNew{
  class Inner{ } 
}

//**********************
class Parcel3 {
     class Contents {
        private int i = 11;
        public int value(){ return i; }
     }

     class Destination{
        private String label;
        Destination(String whereTo){ label = whereTo; }
        String readLabel(){ return label; }
     }
}

//E4
class Sequence {

   private class SequenceSelector {
      public Sequence DoSequence(){
          return Sequence.this;
      }
   }

}

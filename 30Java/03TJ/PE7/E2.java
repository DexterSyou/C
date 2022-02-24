//E2 
class E2 extends Detergent{
   //
   public void scrub(){
      append("E2.scrub() ");
      super.scrub();//super 代表基类
   }
   //
   public void sterilize(){
      append("sterilize() ");
   }

   public static void main(String[] args){
      E2 e2 = new E2();
      e2.dilute();
      e2.apply();
      e2.scrub();
      e2.foam();
      e2.sterilize();
      System.out.println(e2);
   }
 }
 

public class E1To6 {

    public static void main(String []args){
/* E1.
 * E2.
 * E3. package debug
 *     package debugoff
 * E4.
 * E6.
 */
		E5 e5 = new E5();
//		e5.printd(); //
		e5.printI();
		e5.printF();
		e5.printC();
		e5.i=10;
//		e5.d=9.0;   //has private access
        e5.f=10.0f;
		e5.c='b';
    }
}

class E5{

  public int  i=0;
  private double d=10;
  float f=10F;
  protected  char c='a';

  public void printI(){
    System.out.println(i);
  }

  private void printd(){
    System.out.println(d);
  }

  void printF(){
    System.out.println(f);
  }

  protected void printC(){
    System.out.println(c);
  }
}

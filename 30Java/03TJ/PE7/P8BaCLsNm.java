public class P8BaCLsNm {

    public static void main(String []args){

       Bart b = new Bart();
	   b.doh(1);
	   b.doh('x');
	   b.doh(1.0f);
	   b.doh(new Milhouse());

	   Lisa l = new Lisa();
	   l.doh('x');
	   l.doh(1.0f);
    }
}

class Homer {
  char doh(char c){
    System.out.println("doh(char)");
    return 'd';
  }
  float doh(float f){
    System.out.println("doh(float)");
	return 1.0f;
  }
}

class Milhouse{

}

class Bart extends Homer{
  //重载机制正常工作
  void doh(Milhouse m){
    System.out.println("doh(Milhouse)");
  }
}

class Lisa extends Homer{
  @Override    //复写机制
  //void doh(Milhouse m){
  //error: method does not override or implement a method from a supertype 
  float doh(float f){
     System.out.println("Lisa doh(float)");
     return 1.0f;
  }

}







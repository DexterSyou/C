public class P5MhdInner {

    public static void main(String []args){
      Parcel5 p5 = new Parcel5();
	  Destination d = p5.destination("Tasmania");
      // 
	  Parcel6 p6 = new Parcel6();
	  p6.track();
	  //
	  //
	
	
	}
}

//*******************************************
interface Destination {
  String readLabel();
}

interface Contents{
  int value();
}

class Parcel5 {
	
	public Destination destination(String s){
      //destination 外不能访问PDestination
	   class PDestination implements Destination{
	     private String label;
	     private PDestination(String whereTo){
	       label = whereTo;
	     }
	     public String readLabel() { return label;}
	   }
       //向上转型
       return new PDestination(s);
  }
}

class Parcel6 {
   
	private void internalTracking(boolean b){
	   if(b){
		   //TrackingSlip与别的类一起编译，在定义TrackingSlip类作用域之外
		   //它是不可用的，除此之外与普通类一样
           class TrackingSlip {
		      private String id;
			  TrackingSlip(String s){
			    id = s;
			  }
		      String getSlip() { return id;}
		   }	   
	       TrackingSlip ts = new TrackingSlip("slip");
	       String s = ts.getSlip();
	   }
	   //! Can't use it here! Out of scope;
	   //! TrackingSlip ts = new TrackingSlip("slip");
	}

    public void track() {
	  internalTracking(true);
	}
}

//*******************************************
















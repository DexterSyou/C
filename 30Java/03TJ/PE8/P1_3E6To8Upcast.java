import java.util.*;

public class P1_3E6To8Upcast {
    public static void main(String []args){

    }
}

//**********************************
enum Note{ MIDDLE_C,C_SHARP,B_FLAT }

class Instrument{
	//P3
	String what(){return "Instrument";}
	void adjust(){System.out.println("Adjusting Instrument.");}
	//P1
  	public void play(Note n){System.out.println("Instrumet.play()"+ n);}
    
	//E6
	public String toString(){
	   return what();
	}
}

class Wind extends Instrument{
    //P3 
	String what(){return "Wind";}
	void adjust(){System.out.println("Adjusting Wind.");}
	//P1
	public void play(Note n){System.out.println("Wind.play() " + n);}
}

class Percussion extends Instrument{

	//P3
	String what(){return "Percussion";}
	void adjust(){System.out.println("Adjusting Percussion.");}
	//P1
	public void play(Note n){System.out.println("Percussion.play()"+n);}
}

class Stringed extends Instrument{
   
	//P3
	String what(){return "Stringed";}
	void adjust(){System.out.println("Adjusting Stringed.");}
	//P1
	public void play(Note n){System.out.println("Stringed.play()"+n);}
}

class Brass extends Wind{
	void adjust(){System.out.println("Adjusting Brass.");}
	public void play(Note n){System.out.println("Brass.play() " + n);}
}
//E7
class Woodwind extends Wind{
	public void play(Note n){System.out.println("Woodwind.play() " + n);}
	String what(){ return "Woodwind";}
}

class Music {
  public static void tune(Instrument i){
     i.play(Note.MIDDLE_C);
  }
  /*!Music2
   *!  public static void tune(Wind w){}
   *!  public static void tune(Other o){}
   */
  public static void main(String[] args){
     Wind flute = new Wind();
	 tune(flute); //Upcasting
  }
}

//************************************
class RandomInstrumentGen{
   private Random rand = new Random();
   public Instrument next(){
      switch(rand.nextInt(3)){
	  default:	  
	  case 0:return new Wind();
	  case 1:return new Brass();
	  case 2:return new Woodwind();
	 }
   }
}

class Music3{

	private static RandomInstrumentGen gen = new RandomInstrumentGen();
    public static void tune(Instrument i){
	   i.play(Note.MIDDLE_C);
	   //
	}

	public static void tuneAll(Instrument[] e){
	   for(Instrument i : e){
	      tune(i);   
	   }
	}
    //E7
	public static void main(String[] args){
       Instrument[] orchestra = {
	     new Wind(),
		 new Percussion(),
		 new Stringed(),
		 new Brass(),
		 new Woodwind()
	   };
	   tuneAll(orchestra);
       //

	   //E6
	   Instrument i1 = new Wind();
	   System.out.println(i1);
	   Instrument i2 = new Percussion();	
       System.out.println(i2);

	   //E8
	   Instrument[] ins = new Instrument[3];
	   for(int i=0;i<ins.length;i++){
	      ins[i]=gen.next();
	   }
	   tuneAll(ins);
	} 
}



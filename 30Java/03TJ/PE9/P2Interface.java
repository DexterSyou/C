enum Note{ MIDDLE_C,C_SHARP,B_FLAT }

public class P2Interface{}

interface Instrument{
    int VALUE = 5; // 隐式为static final域
    void play(Note n); //  Automatically public
	void adjust();  //
}

class Wind implements Instrument{
	public String toString(){return "Wind";}
	public void adjust(){}
	public void play(Note n){System.out.println("Wind.play() " + n);}
}

class Percussion implements Instrument{
	public String toString(){return "Percussion";}
	public void adjust(){System.out.println("Adjusting Percussion.");}
	public void play(Note n){System.out.println("Percussion.play()"+n);}
}

class Stringed implements Instrument{
   	public String toString(){return "Stringed";}
	public void adjust(){System.out.println("Adjusting Stringed.");}
	public void play(Note n){System.out.println("Stringed.play()"+n);}
}

class Brass extends Wind{
	public String toString(){return "Brass";}
}

class Woodwind extends Wind{
	public String toString(){return "Woodwind";}
}

class Music5{

  static void tune(Instrument i){
     i.play(Note.MIDDLE_C);
  }
  
  static void tuneAll(Instrument[] e){
     for(Instrument i : e){
         tune(i);
     }  
  }
  
  public static void main(String[] args){
     Instrument[] orchestra = {
         new Wind(),
         new Percussion(),
         new Stringed(),
         new Brass(),
         new Woodwind()
     };
     tuneAll(orchestra);   
  }

}

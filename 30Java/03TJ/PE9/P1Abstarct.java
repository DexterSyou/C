enum Note{ MIDDLE_C,C_SHARP,B_FLAT }

public class P1Abstarct{}

abstract class Instrument{
    private int i;
    public abstract void play(Note n);
    public String what(){return "Instrument";}
	public abstract void adjust();
}

class Wind extends Instrument{
	public String what(){return "Wind";}
	public void adjust(){}
	public void play(Note n){System.out.println("Wind.play() " + n);}
}

class Percussion extends Instrument{

	public String what(){return "Percussion";}
	public void adjust(){System.out.println("Adjusting Percussion.");}
	public void play(Note n){System.out.println("Percussion.play()"+n);}
}

class Stringed extends Instrument{
   
	//P3
	public String what(){return "Stringed";}
	public void adjust(){System.out.println("Adjusting Stringed.");}
	//P1
	public void play(Note n){System.out.println("Stringed.play()"+n);}
}

class Brass extends Wind{
	public void adjust(){System.out.println("Adjusting Brass.");}
	public void play(Note n){System.out.println("Brass.play() " + n);}
}
//E7
class Woodwind extends Wind{
	public void play(Note n){System.out.println("Woodwind.play() " + n);}
	public String what(){ return "Woodwind";}
}

class Music4 {

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




































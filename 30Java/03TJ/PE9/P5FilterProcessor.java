public class P5FilterProcessor {

    public static void main(String []args){

		Waveform w = new Waveform();
		Apply.process(new FilterAdapter(new LowPass(1.0)),w);
		Apply.process(new FilterAdapter(new HighPass(2.0)),w);
        Apply.process(new FilterAdapter(new BandPass(3.0,4.0)),w);
	}
}

interface Proccesser{
  String name();
  Object process(Object input);
}

class Apply{
  public static void process(Proccesser p , Object s){
    System.out.println("Proccesser " + p.name());
	System.out.println(p.process(s));
  }
}

class FilterAdapter implements Proccesser{
   Filter filter;
   public FilterAdapter(Filter filter){
     this.filter = filter;
   }

   public String name(){
     return filter.name();
   }

   public Waveform process(Object input){
     return filter.process((Waveform)input);
   }
}
//*******************************************
class Waveform {

  private static long counter;
  private final long id = counter++;
  public String toString() {
     return "Waveform " + id;
  }
}

class Filter{
  public String name(){
    return getClass().getSimpleName();
  } 

  public Waveform process(Waveform input){ return input; }
}

class LowPass extends Filter {
  double cutoff;
  public LowPass(double cutoff){ this.cutoff = cutoff;}
  public Waveform process(Waveform input){ return input;}
}

class HighPass extends Filter{
  double cutoff;
  public HighPass(double cutoff){ this.cutoff = cutoff; }
  public Waveform process(Waveform input){ return input; }
}

class BandPass extends Filter{
  double lowCutoff, highCutoff;
  public BandPass(double lowCut, double highCut){
    lowCutoff = lowCut;
	highCutoff = highCut;
  }
  public Waveform process(Waveform input) { return input; }
}








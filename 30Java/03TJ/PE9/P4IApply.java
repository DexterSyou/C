import java.util.*;

interface Processor{
 
	String name();
	Object process(Object input);
}

public class P4IApply {

   public static void process(Processor p, Object s){
       System.out.println("Using Processor " + p.name());
       System.out.println(p.process(s)); 
   }
}

//*******************************************
abstract class StringProcesser implements Processor{
  
	public String name(){ 
	  return getClass().getSimpleName();
	}

	public abstract String process(Object input);
	public static String s = "If she weights the same as a duck, she's made of wood";
    
	public static void main(String[] args){
	  P4IApply.process(new Upcase(),s);
	  P4IApply.process(new Downcase(),s);
	  P4IApply.process(new Splitter(),s);
	}
}

class Upcase extends StringProcesser{
   public String process(Object input){
     return ((String)input).toUpperCase();
   }
}

class Downcase extends StringProcesser{
  public String process(Object input){
     return ((String)input).toLowerCase();
  }
}

class Splitter extends StringProcesser{
  public String process(Object input){
     return Arrays.toString(((String)input).split(" "));
  }
}













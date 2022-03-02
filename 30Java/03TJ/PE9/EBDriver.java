interface Processor {
   String name();
   Object process(Object input);
}

class Apply {
    public static void process(Processor p, Object s){
      System.out.println("Using Processor " + p.name());
      System.out.println(p.process(s));
    }
}

class StringAdapter implements Processor{
    EB eb;
    public StringAdapter(EB eb){
      this.eb = eb;
    }
    public String name(){
        return eb.name();
    }
    public String process(Object input){
        return eb.process((String)input);
    }
}

class EB {
    public String name(){
        return getClass().getSimpleName();
    }
    public String process(String input){
        return input.concat("假装反转了。。。");
    } 
}

class Reverse extends EB {

}
public class EBDriver{
    public static void main(String[] args){
         String s = "hello world how are you.";
         Apply.process(new StringAdapter(new Reverse()),s);
    }
}

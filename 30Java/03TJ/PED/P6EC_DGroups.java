import java.util.regex.*;
public class P6EC_DGroups{}
//************************************************************************** */
class Groups {
   static public final String POEM = 
     "Twas brillig, and the slithy toves\n" +
     "Did gyre and gimble in the wabe.\n" +
     "All mimsy were the borogoves,\n" +
     "And the mome raths outgrabe.\n\n" +
     "Beware the Jabberwok, my som,\n" +
     "The jaws that bite, the claws that catch.\n" +
     "Beware the Jubjub bird, and shun\n" +
     "The frumoius Bandersnatch.\n";
   
   public static void main(String[] args){

       Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);
       //
       while(m.find()){
           //groupCount() 返回分组数目，第0组不匹配
           for(int j=0;j<=m.groupCount();j++){
               System.out.print("["+m.group(j)+"]");
           }
           System.out.println();
       }
       System.out.println();
       ///////EC 
       m = Pattern.compile("((^[a-z])|\\s+)([a-z]\\w+)").matcher(POEM);
       while(m.find()){
           System.out.println("["+m.group()+"]");
       } 
   }
}
//************************************************************************** */
class StartEnd {
   
   public static String input = 
      "As long as there is injustice, whenever a\n" +
      "Targathian baby cries out, whenever a distress\n" +
      "signal sounds among the stars ... We'll be there.\n"+
      "This fine ship, and this fine crew...\n" +
      "Never give up! Never surrender!";

   private static class Display {
       private boolean regexPrinted = false;
       private String  regex;
       Display(String  regex) { this.regex = regex; }
       void display(String message){
           if(!regexPrinted){
               System.out.println(regex);
               regexPrinted = true;
           }
           System.out.println(message);
       }
   }

   static void examine(String s, String regex){
       Display d = new Display(regex);
       Pattern p = Pattern.compile(regex);
       Matcher m = p.matcher(s);
       while(m.find()){
           d.display("find() '"+m.group()+" 'start = " + m.start() + " end = " +m.end());
       }    
       if(m.lookingAt()){
           d.display("lookingAt() start="+m.start() + " end = " +m.end());
       }
       if(m.matches()){
           d.display("matches start="+m.start() + " end = " +m.end());
       }
       /*
        *
//find        可以在输入的任何位置定位正则表达式
input ： As long as there is injustice, whenever a
\w*ere\w*
find() 'there 'start = 11 end = 16
\w*ever
find() 'whenever 'start = 31 end = 39

input ： Targathian baby cries out, whenever a distress
\w*ever
find() 'whenever 'start = 27 end = 35
T\w+
find() 'Targathian 'start = 0 end = 10
lookingAt() start=0 end = 10
input ： signal sounds among the stars ... We'll be there.
\w*ere\w*
find() 'there 'start = 43 end = 48
input ： This fine ship, and this fine crew...
T\w+
find() 'This 'start = 0 end = 4
//lookingAt    在输入的最开始处就开始匹配时才会成功
lookingAt() start=0 end = 4
input ： Never give up! Never surrender!
\w*ever
find() 'Never 'start = 0 end = 5
find() 'Never 'start = 15 end = 20
lookingAt() start=0 end = 5
Never.*?!
find() 'Never give up! 'start = 0 end = 14
find() 'Never surrender! 'start = 15 end = 31
lookingAt() start=0 end = 14
//matches    在整个输入都匹配的情况下
matches start=0 end = 31
       */
   } 

   public static void main(String[] args){
       for(String in : input.split("\n")){
           System.out.println("input ： " + in);
           for(String regex : new String[]{"\\w*ere\\w*","\\w*ever","T\\w+","Never.*?!"}){
               examine(in,regex);
           }
       }

       //E13 ED
       for(String in : Groups.POEM.split("\n")){
           System.out.println("input ： " + in);
           for(String regex : new String[]{"\\w*ere\\w*","\\w*ever","T\\w+","Never.*?!"}){
               examine(in,regex);
           }
       }
   }
}
//**************************************************************************
/* Pattern Pattern.compile(String regex, int flag) */
class ReFlags {
    public static void main(String[] args){
      Pattern p = Pattern.compile("^java",Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
      Matcher m = p.matcher(
        "java has regex\nJava has regex\n" +
        "JAVA has pretty good regular expression\n" +
        "Regular expression are in java");
      while(m.find()){
          System.out.println(m.group());
      } 
    }
}



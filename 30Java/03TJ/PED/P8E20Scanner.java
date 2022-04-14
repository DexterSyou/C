import java.util.regex.*;
import java.util.*;
import java.io.*;
public class P8E20Scanner {}
//************************************************************************ */
class JGrep {
     public static void main(String[] args) throws Exception {
        if(args.length > 2){
            System.out.println("Usage: java JGrep file regex ");
            System.exit(0);
        } 
        Pattern p = Pattern.compile(args[1]);
        int index = 0;
        Matcher m = p.matcher("");
        /* 
          for(String line : new TextFile(args[0])){
             m.reset(line);
             while(m.find())
              System.out.println(index++ + ": " + m.group() + ": " +m.start());
          }
        */  
     } 
}
//E15 ~ E19

//************************************************************************ */
class SimpleRead {
    public static BufferedReader input = new BufferedReader(new StringReader("Sir Robin of Camelot\n22 1.61803"));
    public static void main(String[] args){
        try{
           System.out.println("What is your name?");
           String name = input.readLine();
           System.out.println(name);
           System.out.println("How old are you? What is your favorite double?");
           System.out.println("(input: <age> <double>)");
           String numbers = input.readLine();
           System.out.println(numbers);
           String[] numArray = numbers.split(" ");
           int age = Integer.parseInt(numArray[0]);
           double favorite = Double.parseDouble(numArray[1]);
           System.out.format("Hi %s.\n",name);
           System.out.format("In 5 years you will be %d.\n",age+5);
           System.out.format("My favorite double is %f.",favorite/2);
        }catch(IOException e){
           System.err.println("I/O Exception");  
        }
    }
}

class BetterRead {

        public static void main(String[] args){
           Scanner stdin = new Scanner(SimpleRead.input);
           //
           //String  nextLine()
           //int     nextInt()
           //double  nextDouble()
           //
        }
}
//E20
class E20 {

    /***************************
       nextInt()
       nextLong()
       nextFloat()
       nextDouble()
       next()
     */
}

//************************************************************************ */
class ScannerDelimiter {
    
     public static void main(String[] args){
         Scanner scanner = new Scanner("12,42,78,99,42");
         scanner.useDelimiter("\\s*.\\s*");
         while(scanner.hasNextInt()){
             System.out.println(scanner.nextInt());
         }
     }
}

class ThreatAnalyzer {

    static String threatData = 
     "58.27.82.161@02/10/2005\n" +
     "58.37.82.161@02/10/2005\n" +
     "59.27.82.161@02/10/2005\n" +
     "58.39.82.161@02/10/2005\n" + 
     "58.27.82.123@02/10/2005\n" + 
     "[Next log section with different data format]";

    public static void main(String[] args){
       Scanner scanner = new Scanner(threatData);
       String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@" +
        "(\\d{2}/\\d{2}/\\d{4})";

        while(scanner.hasNext(pattern)){
            scanner.next(pattern);
            MatchResult match = scanner.match();
            String ip = match.group(1);
            String date = match.group(2);
            System.out.format("Threat on %s from %s\n",date,ip);
        }  

    }
}

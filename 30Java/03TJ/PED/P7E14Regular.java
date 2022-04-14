import java.util.regex.*;
import java.util.*;

public class P7E14Regular {}
//********************************************************** */

class SplitDemo {

    public static void main(String[] args){

        String input = 
          "This!!unusual use!!of exclamation!!points";
        System.out.println(Arrays.toString(Pattern.compile("!!").split(input)));
        System.out.println(Arrays.toString(Pattern.compile("!!").split(input,3)));
        
    }
}

//E14 EE
class EE {

    public static void main(String[] args){

        String input = 
          "This!!unusual use!!of exclamation!!points";
        String[] str1 = input.split("!!");
        System.out.println(Arrays.toString(str1));    
    }

}

//
class TheReplacements {
    
    public static void main(String[] args) throws Exception{
     //************************************************* /
     String s = 
      "/*！    Here                         's a block of text to use as input to" +
      "the regular expression matcher. Note that we 'll " +
      "first extract the block of text by looking for "  + 
      "the special delimiters, then processs the extracted block. !*/";
     // 匹配/*！ 和 ！*/
     // 
     Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/",Pattern.DOTALL).matcher(s); 
     if(mInput.find()){
         s = mInput.group(1);
     }  
     System.out.println(s);
     System.out.println("1*********************************************");

     s = s.replaceAll(" {2,}"," ");      // 单空格替换两个以上的空格
     s = s.replaceFirst("(?m)^ +"," ");  // 替换开头空格（删除） MULTILINE mode  
     System.out.println(s);
     System.out.println("2*********************************************");


     s = s.replaceFirst("[aeiou]","(VOWEL1)");
     System.out.println(s);
     System.out.println("3*********************************************");
    
     StringBuffer sbuf = new StringBuffer();
     Pattern p = Pattern.compile("[aeiou]");
     Matcher m = p.matcher(s);
     while(m.find()){
         //渐进式替换
         m.appendReplacement(sbuf,m.group().toUpperCase());
     } 
     m.appendTail(sbuf);
     System.out.println(sbuf);
     System.out.println("4*********************************************");
    }
}

class Resetting {

    public static void main(String[] args) throws Exception {
        //*************************************** */
         Matcher m = Pattern.compile("[frb][aiu][gx]").matcher("fix the rug with bags");
         while(m.find()){
             System.out.println(m.group() + " ");
         }
         System.out.println();
        
         m.reset("fix the rig with rags");
         while(m.find()){
             System.out.println(m.group() + " ");
         }
        //*************************************** */   
    }
}

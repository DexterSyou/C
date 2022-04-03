import java.util.regex.*;
public class P5EA_BRegular {
    public static void main(String []args){
    }
}
//*******************************************
/*
 * CharSequence 从CharBuffer，String，StringBuffer，StringBuilder
 * interface CharSequence{
 *    charAt(i);
 *    length();
 *    subSequence(int start, int end);
 *    toString();
 * }
 * 多数正则表达式都接受CharSequence类型操作
 */
class Rudolph {
 
	public static void main(String[] args){
	  for(String pattern : new String[]{"Rudolph","[rR]udolph","[rR][aeiuo][a-z]ol.*","R.*"})
	    System.out.println("Rudolph".matches(pattern));
	}
}

//********************************************
/* java.util.regex */
class TestRegularExpression {
  public static void main(String[] args){
    if(args.length < 2){
	  System.out.println("Usage:\n java TestRegularExpression characterSequence regularExpression" );
	  System.exit(0);
	}
    System.out.println("Input: \"" + args[0]+"\"");
    for(String arg : args){
	  System.out.println("Regular expression: \""+arg+"\"");
      Pattern p = Pattern.compile(arg);// 编译正则表达式
	  Matcher m = p.matcher(args[0]);  // 产生Matcher对象
	  while(m.find()){
	    System.out.println("Match \"" + m.group()+"\" at positions " + m.start() + "-" +(m.end()-1));
	  }
	}
  }
}
/*Pattern:
 *   matches() 该方法用以检查regex是否匹配整个CharSequence类型的input参数
 *   split()   从匹配了regex的地方分割输入字符串，返回分隔后的子字符串String数组
 *Matcher：
 *   matches()      判断整个输入字符串是否匹配正则表达式
 *   lookingAt()    
 *   find()
 *   find(int start)
 */

// EA
class EA{
  public static void main(String[] args){
    String s = "Java now has regular expression";
    for(String pattern : new String[]{"^java","\\Breg.*","n.w\\s+h(a|i)s","s?","s*","s+","s{4}","s{1}.","s{0,3}"})
	{
	  System.out.println("*********Regular : " + pattern +"*************");
	  Pattern p = Pattern.compile(pattern);
	  Matcher m = p.matcher(s);
	  while(m.find()){ 
	     System.out.println("Match \""+m.group()+"\"at positions" + m.start()+"-" +(m.end()-1));
	  }
	} 
  }
}

//EB
class EB {
  public static void main(String[] args){
     String s = "Arline ate eight apples and one orange while Anita hadn't any";
     Pattern p = Pattern.compile("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b");
	 Matcher m = p.matcher(s);
	 while(m.find()){
	   System.out.println(m.group());
	 }
  }
}

//*****************************************
class Finding {  
  public static void main(String[] args){
     Matcher m = Pattern.compile("\\w+")
		 .matcher("Evening is full of the linnet's wings");
     while(m.find()){
	    System.out.print(m.group()+" ");
	 }
	 System.out.println();
     int i = 0;
	 while(m.find(i)){
	   System.out.print(m.group()+" ");
	   i++;
	 }
	 System.out.println();
  } 
}








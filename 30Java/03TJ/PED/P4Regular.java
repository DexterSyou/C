import java.util.*;
public class P4Regular {
    public static void main(String []args){
    }
}
//*******************************************
class IntegerMatch {
  public static void main(String[] args){
    // 检查是否匹配正则表达式
	System.out.println("-1234".matches("-?\\d+"));
    System.out.println("5678".matches("-?\\d+"));
    System.out.println("+911".matches("-?\\d+"));
    System.out.println("+911".matches("(-|\\+)?\\d+"));
  }
}

//split 将字符串从正则表达式匹配的地方切开
class Splitting {
  public static String knights = 
	  "Then, when you have found the shrubbery, you must " + 
	  "cut down the mightiest tree int the forest..." +
	  "with...a herring!";

  public static void split(String regex){
    System.out.println(Arrays.toString(knights.split(regex)));
  }
 
  public static void main(String[] args){
    split(" ");
	split("\\W+");
	split("n\\W+");
  }
}

class Replacing {
   static String s = Splitting.knights ;
   public static void main(String[] args){
     System.out.println(s.replaceFirst("f\\w+","located")); 
     System.out.println(s.replaceAll("shrubbery|tree|herring","banana"));
   }
}
//*******************************************
//E7 s.matchex("^[A-Z].*\\.")

//E8 s.replaceAll("you|the",",");
class E8 {
   public static void main(String[] args){
	  String s = "the you hello world how are you!!!";
      System.out.println(Arrays.toString(s.split("you|the")));
   }
}
//E9 s.replaceAll("a|e|i|o|u","_")









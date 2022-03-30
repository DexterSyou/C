class P1E1String{}
//**************************************************************** */
//不变的String
class Immutable {

    public static String upcase(String s){
        return s.toUpperCase();
    }
    public static void main(String[] args){
        String q = "howdy";
        System.out.println(q);
        String qq = upcase(q);
        System.out.println(qq);
        System.out.println(q);
    }
}
//**************************************************************** */
class Concatenation {
    public static void main(String[] args){
         String mango = "mango";
         String s = "abc" + mango + "def" + 47;
         System.out.println(s);
         /////
         /*
         class Concatenation {
  Concatenation();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: ldc           #2                  // String mango
       2: astore_1
           //# 编译器自动引入了StringBuidler
       3: new           #3                  // class java/lang/StringBuilder 
       6: dup
       7: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
      10: ldc           #5                  // String abc
      12: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      15: aload_1
      16: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      19: ldc           #7                  // String def
      21: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;

      24: bipush        47
      26: invokevirtual #8                  // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
          //# toString()
      29: invokevirtual #9                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
          //# 存储为s
      32: astore_2

      33: getstatic     #10                 // Field java/lang/System.out:Ljava/io/PrintStream;
      36: aload_2
      37: invokevirtual #11                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      40: return
}*/
    }
}
//
class WhitherStringBuilder {
    public String implicit(String[] fields){
        String result = "";
        for(int i=0;i<fields.length;i++){
            result += fields[i];
        }
        return result;
    }

    public String explicit(String[] fields){
        StringBuilder result = new StringBuilder();
        for(int i=0;i<fields.length;i++){
            result.append(fields[i]);
        } 
        return result.toString(); 
    }
    ///////
    /*
class WhitherStringBuilder {
  WhitherStringBuilder();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public java.lang.String implicit(java.lang.String[]);
    Code:
       0: ldc           #2                  // String
       2: astore_2
       3: iconst_0
       4: istore_3
       5: iload_3
       6: aload_1
       7: arraylength
          //# 循环到38
          //# StringBuilder 在循环体内
       8: if_icmpge     38
      11: new           #3                  // class java/lang/StringBuilder
      14: dup
      15: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
      18: aload_2
      19: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      22: aload_1
      23: iload_3
      24: aaload
      25: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      28: invokevirtual #6                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      31: astore_2
      32: iinc          3, 1
      35: goto          5
      38: aload_2

      39: areturn

  public java.lang.String explicit(java.lang.String[]);
    Code:
       0: new           #3                  // class java/lang/StringBuilder
       3: dup
       4: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
       7: astore_2
       8: iconst_0
       9: istore_3
      10: iload_3
      11: aload_1
      12: arraylength
      13: if_icmpge     30
      16: aload_2
      17: aload_1
      18: iload_3
      19: aaload
      20: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      23: pop
      24: iinc          3, 1
      27: goto          10
      30: aload_2
      31: invokevirtual #6                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      34: areturn
}
    */
}
//**************************************************************** */
class UsingStringBuilder {
    public static Random rand = new Random(47);
    public String toString(){
        StringBuilder result = new StringBuilder("[");
        for(int i=0;i<25;i++){
            result.append(rand.nextInt(100));
            result.append(", ");
        }
        result.delete(result.length()-2,result.length());
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args){
       UsingStringBuilder usb = new UsingStringBuilder();
       System.out.println(usb);
    }
}

//E1
//运用javap -c 进行分析

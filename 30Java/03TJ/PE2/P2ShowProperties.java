import java.util.*;//import 指示编译器

class P2ShowProperties{
  
  public static void main(String []args){

      System.getProperties().list(System.out);
      System.out.println(System.getProperty("user.name"));
      System.out.println(System.getProperty("java.library.path"));
  }
   
}

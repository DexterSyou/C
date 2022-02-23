import java.util.*;
public class P8VarArgs{

    //VarArgs
    static void printArray(Object[] args){
        for(Object obj : args){
          System.out.print(obj+" ");
        }
        System.out.println();
    }
    //NewVarArgs JSE5
    static void printNewArray(Object... args){
        for(Object obj : args){
          System.out.print(obj+" ");
        }
        System.out.println();
    }   
    //OptionalTrailingArgumrnts
    static void f1(int required, String...trailing){
      System.out.print(" required : " + required +" " );
      for(String s: trailing){
         System.out.print(s + " ");
      }
      System.out.println();
    }
    //VarargeType
    static void f2(Character... args){
        System.out.print(args.getClass());
        System.out.println(" length "+args.length);
    }

    static void g2(int... args){
         System.out.print(args.getClass());
         System.out.println(" length "+args.length);
    }
    //AutoboxingVarargs
    static void f3(Integer... args){
        for(Integer i : args)
            System.out.print(i + " ");
        System.out.println();  
    }
    //OverloadingVarargs
    static void ovf(Character... args){
        System.out.print("first");
        for(Character c : args){
           System.out.print(" " + c);
        }
        System.out.println();
    }
    static void ovf(Integer... args){
        System.out.print("second");
        for(Integer i : args){
           System.out.print(" " + i);
        }
        System.out.println();
    }
    static void ovf(Long... args){
        System.out.println("third");
    }
    //ovf()
    /*
    static void ovf(float i, Character... args){

    } 
    static void ovf(char i, Character... args){

    } 
   */
    //
    public static void main(String[] args){
    //
      System.out.println("\n//VarArgs************************************");
      printArray(new Object[]{new Integer(47),new Float(3.14),new Double(11.11)});
      printArray(new Object[]{"one","two","three"});
      printArray(new Object[]{new A(),new A(),new A()});

      printNewArray(47,3.14F,11.11); //编译器会为你填充数组
      printNewArray("one","two","three");
      printNewArray(new A(),new A(),new A());
      printNewArray((Object[])new Integer[]{1,2,3,4});
      printNewArray();
    //  
      System.out.println("\n//OptionalTrailingArgumrnts************************************");
      f1(1,"one");
      f1(2,"two","three");
      f1(0);
    // 
      System.out.println("\n//VarargeType**********************************************");
      f2('a');
      f2();
      g2(1);
      g2();
      System.out.println("int[]: " + new int[0].getClass());
    // 
      System.out.println("\n//AutoboxingVarargs************************************");
      f3(new Integer(1),new Integer(2));
      f3(4,5,6,7,8,9);
      f3(10,new Integer(11),12);
    //
      System.out.println("\n//OverloadingVarargs************************************");
      ovf('a','b','c');
      ovf(1);
      ovf(2,1);
      ovf(0);
      ovf(0L); 
    //



    }
}

class A{

}

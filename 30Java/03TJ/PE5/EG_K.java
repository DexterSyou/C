public class EG_K {


    //EK (E20)
    public static void main(String... args){
       for(String str : args)
         System.out.print(" "+str);
       System.out.println(); 

       E19.printAry(args);
       E19.printAry("hello","world","how are you");
       E19.printAry(new String[]{"hello","world","how are you"});
    }
}

//EG
class E19{

    static void printAry(String... strs){
       for(String str : strs)
         System.out.print(" "+str);
       System.out.println(); 
    }
}

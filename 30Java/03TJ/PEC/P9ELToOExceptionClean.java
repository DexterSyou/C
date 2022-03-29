import java.io.*;
class P8ELToOExceptionClean {}
//******************** */
class InputFile {
    private BufferedReader in;
    public InputFile(String fname) throws Exception{
        try{
            in = new BufferedReader(new FileReader(fname));
        }catch(FileNotFoundException e){
            throw e;
        }catch(Exception e){
            try{
                in.close();
            }catch(IOException e2){
                System.out.println("in.close() unsuccessful");
            }
            throw e;
        }finally{

        }    
    }

    public String getLine(){
        String s;
        try{
           s = in.readLine();
        }catch(IOException e){
            throw new RuntimeException("readLine() failed");
        }
        return s;
    } 

    public void dispose(){
        try{
            in.close();
            System.out.println("dispose successful");
        }catch(IOException e2){
            throw new RuntimeException("in.close() failed");
        }
    }
}
//E24//EO
class EO{
    public static void main(String[] args){
        try{
            InputFile in = new InputFile("Cleanup.java");
            try{
                while((in.getLine())!=null){
                    System.out.println(1);
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                in.dispose();
            }
        }catch(Exception e){
             System.out.println("InputFile Construction failed");
        }
    }
}
//******************** */
//EL
class E21E1 extends Exception {}
class E21FCls {
     E21FCls() throws E21E1 {
        throw new E21E1();
     }
     E21FCls(String s){
     }
}
class E21SCls extends E21FCls {
     E21SCls() throws E21E1{
       try{  
          try{
              throw new Exception();
           }catch(Exception e){
              System.out.println("1");
              e.printStackTrace(System.out);
           }
           E21FCls f = new E21FCls();
         }catch(Exception e){
           System.out.println("2");
           e.printStackTrace(System.out);
         }  
     }
     E21SCls(String s) throws E21E1{
       super(s);
 
          try{
              throw new Exception();
           }catch(Exception e){
              System.out.println("1");
              e.printStackTrace(System.out);
           }

     }
     public static void main(String[] args){
         try{
            E21SCls  e21scls = new E21SCls();
         }catch(E21E1 e){
            System.out.println("3");
            e.printStackTrace(System.out); 
         }

        try{     
           E21SCls  e21scls1 = new E21SCls("Test");
         }catch(E21E1 e){
            System.out.println("4");
            e.printStackTrace(System.out); 
         }
     }
}
//EM//EN
//E22//E23
class FailingConstructor {
    //E23
    private String E23;

    FailingConstructor() throws Exception {
        //create E23 ???????    
        throw new Exception(); 
    }
}

class EMToO {
    public static void main(String[] args){
        try{
            FailingConstructor fc = new FailingConstructor();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


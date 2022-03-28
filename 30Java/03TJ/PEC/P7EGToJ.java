class P7EGToJ {}
//****************************************** */
//EG  EH 
//E16 E17
class MultipleReturns {
   public static void f(int i){
     System.out.println("Initialization that requires cleanup");
     try{
           System.out.println("Point 1");
           if(i == 1 ) return ;
           System.out.println("Point 2");
           if(i == 2 ) return ;
           System.out.println("Point 3");
           if(i == 3 ) return ;
           System.out.println("End");
           return ;           
     }finally{
           System.out.println("Performing cleanup");
     }
   }

   public static void main(String[] args){
       for(int i = 1; i<=4; i++){
           f(i);
       }
   }
}  

//****************************************** */
class VeryImportantException extends Exception {
    public String toString(){
          return "A very important exception";
    }
}
class HoHumException extends Exception {
    public String toString(){
          return "A trivial exception";
    }
}
class LostMessage {
   void f() throws VeryImportantException {
       throw new VeryImportantException();
   }

   void dispose() throws HoHumException {
       throw new HoHumException();
   }

   public static void main(String[] args){
       try{
         LostMessage lm = new LostMessage();
         try{
           lm.f();
         }finally{
           try{  
              lm.dispose();
           }finally{
              throw new Exception();
           }  
         }   
       }catch(Exception e){
         System.out.println(e); 
       }
   }
}
//E19 EG
/*
  try{
  }catch(){
      catch the first Exception
  }finally{
     try{

     }catch(){
        catch the second Exception
     }
  }
*/




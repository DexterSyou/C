public class EAToCTank{

    boolean empty = false;
      
    void makefull(){
        empty = true;
    }

    protected void finalize(){

        if(empty){
           System.out.println("The tank is empty.");  
        }
    }

    public static void main(String []args){
        new EAToCTank().makefull();
        new EAToCTank();  
        System.gc();   
    }
}

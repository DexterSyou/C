public class P4Tank{

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
        new Tank().makefull();
        new Tank();  
        System.gc();   
    }
}

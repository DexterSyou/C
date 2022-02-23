import java.util.*;
public class E8 {
//
////E8=ConnectionManager
//
//
    static private ConnectionE8[] conn = new ConnectionE8[10];
    static private int count = 0;
	static {
	  for(int i=0;i<conn.length;i++){
	    conn[i]=new ConnectionE8();
	  }
	}
	static ConnectionE8 getConnectionE8(){
        if(count < conn.length)
			return conn[count++]; 
		return null;
	} 
    public static void main(String []args){
     for(int i=0;i<12;i++){
		ConnectionE8 conn =  E8.getConnectionE8();
		if(conn != null){
		  System.out.println("Get a connection...");
		}else{
		  System.out.println("NULL...");
		}
	 }
    }

}

class ConnectionE8{
   ConnectionE8(){
   
   }
}

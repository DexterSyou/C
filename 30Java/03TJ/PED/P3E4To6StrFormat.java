import java.io.*;
import java.util.*;
class P3E4StrFormat{}
//**************************************************************** */
class SimplerFormat {    
    public static void main(String[] args){
       int x = 5;
       double y = 5.332542;
       System.out.println("Row 1: [" + x + " " + y + "]");
       System.out.format("Row 1: [%d %f]\n",x,y);//C printf
       System.out.printf("Row 1: [%d %f]\n",x,y);
    }
}
//**************************************************************** */
//Formatter 
/* 将格式化字符串与数据翻译成需要的结果 */
class Turtle {
    private String name;
    private Formatter f;
    public Turtle(String name, Formatter f){
        this.name = name;
        this.f = f;
    }

    public void move(int x, int y){
        f.format("%s The Turtle is at(%d, %d)\n",name,x,y);
    }

    public static void main(String[] args){
         // PrintStream outAlias = System.out;
         //E3
          PrintStream outAlias = System.err;
          Turtle tommy = new Turtle("Tommy",new Formatter(System.out));
          Turtle terry = new Turtle("Terry",new Formatter(outAlias));
          tommy.move(0,0);
          terry.move(4,8);
          tommy.move(3,4);
          terry.move(2,5);
          tommy.move(3,3);
          terry.move(3,3);
    }
}
//**************************************************************** */
/* %argument_index flags width .precision conversion */
class Receipt {
   //E4
   final int width = 5;
   private String sf = "%-15.15s  %"+width+"d %10.2f\n";
   //
   private double total = 0;
   private Formatter f = new Formatter(System.out);
   public void printTitle(){
       f.format("%-15s %5s %10s\n","Item","Qty","Price");
       f.format("%-15s %5s %10s\n","----","---","-----");
   }

   public void print(String name, int qty, double price){
        f.format(sf,name,qty,price);
        total += price;
   }

   public void printTotal(){
       f.format("%-15s %5s %10.2f\n","Tax","",total*0.06);
       f.format("%-15s %5s %10s\n","","","-----");
       f.format("%-15s %5s %10.2f\n","Total","",total*1.06);
   }
   
   public static void main(String[] args){
      Receipt receipt = new Receipt();
      receipt.printTitle(); 
      receipt.print("Jack's Magic Beans",4, 4.25); 
      receipt.print("Princess Peas",3,5.1); 
      receipt.print("Three Bears Porridge",1,14.29); 
      receipt.printTotal(); 
   }
}

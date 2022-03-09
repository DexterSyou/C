import java.util.*;
class P9ERQueue {}
//**************************************** */
//队列常被当作一种可靠的将对象从程序的某个区域传输到另一个区域的途径
class QueueDemo {
   public static void printQ(Queue queue){
       while(queue.peek()!=null){
          System.out.print(queue.remove() + " ");
          //peek element poll remove
       }
       System.out.println();
   }

   public static void main(String[] args){
       //LinkedList作为Queue的一种实现
       Queue<Integer> queue = new LinkedList<Integer>();
       Random rand = new Random(47);
       for(int i=0;i<10;i++){
           queue.offer(rand.nextInt(i+10));//插入队尾
       }
       printQ(queue);
       Queue<Character> qc = new LinkedList<Character>();
       for(char c: "Brontosaurus".toCharArray())
         qc.offer(c);
       printQ(qc);   
   }

}
//E27 ER
class Command {
    private String str;
    public Command(String str){
       this.str = str;
    }
    public void operation(){
        System.out.println(str);
    } 
}

class E27Queue{
   private Queue<Command> queue;
   public E27Queue(Queue<Command> queue){
       this.queue = queue;
   } 
   public E27Queue makeQueue(Command cmd){
      queue.offer(cmd);
      return this;
   }   
}

class E27{

    public static void printQ(Queue queue){
       while(queue.peek()!=null){
          Command cmd = (Command)queue.remove();
          cmd.operation();
          //peek element poll remove
       }
    }

    public static void main(String[] args){
        Queue<Command> queue = new LinkedList<Command>();
        E27Queue e27queue = new E27Queue(queue); 
        e27queue.makeQueue(new Command("LS")).
                 makeQueue(new Command("CAT")).
                 makeQueue(new Command("CD")).
                 makeQueue(new Command("MKDIR"));
        printQ(queue);
    }
}


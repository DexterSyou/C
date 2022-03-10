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

//
/*优先级队列声明了一个弹出元素最需要的元素*/
class PriorityQueueDemo {

    public static void main(String[] args){
        //1
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        Random rand = new Random(47);
        for(int i=0;i<10;i++){
            E28
            // rand.nextDouble(i+10.0)....
            priorityQueue.offer(rand.nextInt(i+10));
        }  
        QueueDemo.printQ(priorityQueue);
        //2
        List<Integer> ints = Arrays.asList(25,22,20,18,14,9,3,1,1,2,3,9,14,18,21,23,25);
        priorityQueue = new PriorityQueue<Integer>(ints);
        QueueDemo.printQ(priorityQueue);
        //3 Collections.reverseOrder()反序
        priorityQueue = new PriorityQueue<Integer>(ints.size(),Collections.reverseOrder());
        priorityQueue.addAll(ints);
        QueueDemo.printQ(priorityQueue);
        //4
        // E29 class Str{}
        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPQ = new PriorityQueue<String>(strings);
        QueueDemo.printQ(priorityQueue);
        //5
        stringPQ = new PriorityQueue<String>(strings.size(),Collections.reverseOrder());
        stringPQ.addAll(strings);
        QueueDemo.printQ(stringPQ);
        //6
        Set<Character> charSet = new HashSet<Character>();
        for(char c : fact.toCharArray()){
            charSet.add(c);
        } 
        PriorityQueue<Character> characterPQ = new PriorityQueue<Character>(charSet);
        QueueDemo.printQ(characterPQ);

    }
}
/*
 Integer String Character 自然排序
 */

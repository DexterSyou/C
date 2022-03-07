import java.util.*;

public class P5ED_ELinkedList{}
//*************************************** */
class LinkedListFeatures {

  public static void main(String[] args){
    //LinkedList独有的List没有的操作
    LinkedList<String> pets = new LinkedList<String>(Arrays.asList("Rat","Manx","Cymric","Mutt","Pug","Cymric","Pug"));
    System.out.println(pets);
    // 返回头元素，List为空时peek返回NULL，getFirst element抛出NoSuchElementException
    System.out.println("pets.getFirst() " + pets.getFirst() );
    System.out.println("pets.element() "+ pets.element() );
    System.out.println("pets.peek() "+ pets.peek() );
    //移除并返回头元素，List为空时poll返回NULL，remove removeFirst抛出NoSuchElementException
    System.out.println("pets.remove() "+ pets.remove() );
    System.out.println("pets.removeFirst() "+ pets.removeFirst() );
    System.out.println("pets.poll() "+ pets.poll() );
    System.out.println(pets);
    //
    pets.addFirst("Rat");
    System.out.println("After addFirst() "+ pets );
    pets.offer("rand");
    System.out.println("After offer() "+ pets );
    pets.add("Ratadd");
    System.out.println("After add() "+ pets );
    pets.addLast("Hamster");
    System.out.println("After addLast() "+ pets );
    System.out.println("pets.removeLast() "+ pets.removeLast() );
   }
}
//*************************************** */
//E13 ED
class Event{}
class EDController {
    private List<Event> eventList = new LinkedList<Event>();
    //addEvent()...

    public void run(){
        while(eventList.size()>0){
           Iterator it = eventList.iterator();
           while(it.hasNext()){
              Event e = (Event)it.next();
              //if(e.ready()){
                //sop(e)
                //e.action()
                //eventList.remove(3)
             //}
          }
        }
    }
}
//E14 EE
class EE {
    public static void main(String[] args){
       LinkedList<Integer> list = new LinkedList<Integer>();
       System.out.println(list);
       ListIterator<Integer> it;
       for(int i = 0;i<6;i++){
          it = list.listIterator((list.size()/2));
          it.add(i); //
       }
       System.out.println(list);
    }

}

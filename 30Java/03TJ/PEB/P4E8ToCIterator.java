import java.util.*;
public class P4E8ToCIterator{}
//迭代器是一个对象，遍历并选择序列中的对象，而不必关心该序列的底层结构
/*
  java 的Iterator
  使用iterator 方法要求容器返回一个Iterator，Iterator准备好返回序列第一个元素
  next()       获得序列中的下一个元素
  hasNext()    检查序列中是否还有元素
  remove()     将迭代器新近返回的元素删除
 */
 class SimpleIteration {
    public static void main(String[] args){
      
      List<String> pets = new ArrayList(Arrays.asList(
          "Rat","Manx","Cymric","Mutt","Pug","Cymric","Pug","Manx"));
      Iterator<String> it = pets.iterator();
      while(it.hasNext()){
          String p = it.next();
          System.out.print(p+" ");
      }    
      System.out.println();
      for(String p : pets){
         System.out.print(p+" ");
      }
      System.out.println();
       
      it = pets.iterator();
      for(int i=0;i<6;i++){
         it.next();
         it.remove();
      }
      System.out.println(pets);
    }
 }
 
 //接受对象容器并传递它，从而在每个对象上都执行操作
 //遍历序列与序列的底层结构分离
class CrossContainerIteration {
  //E11 EB
  public static void display(Iterator<String> it){
       while(it.hasNext()){
           String p = it.next();
           System.out.print(p+" ");
       }
       System.out.println();
  }

  public static void main(String[] args){
     ArrayList<String> pets = new ArrayList(Arrays.asList(
          "Rat","Manx","Cymric","Mutt","Pug","Cymric","Pug","Manx"));
     LinkedList<String> petsLL = new LinkedList<String>(pets);
     HashSet<String> petsHS = new HashSet<String>(pets);
     TreeSet<String> petsTS = new TreeSet<String>(pets);
     display(pets.iterator());
     display(petsLL.iterator());
     display(petsHS.iterator());
     display(petsTS.iterator());
  }
}

//
//E8*********************************************/
class E8 {
  public static void main(String[] args){
     ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
	 for(int i=0;i<5;i++){
	   gerbils.add(new Gerbil());
	 }

     Iterator it = gerbils.iterator();
     while(it.hasNext()){
        Gerbil g=(Gerbil)it.next();
        g.hop();
     } 	   
  }
} 
class Gerbil {
  private int gerbilNumber;
  public Gerbil(){
    gerbilNumber = 100;
  }
  public void hop(){
    System.out.println("gerbilNumber: "+gerbilNumber+" is jumpping");
  }
}
//E9*********************************************/
class Sequence {
    //
    private List<String> items;
    public Sequence(){items=new ArrayList<String>();}
    public void add(String x){
        items.add(x);
    }
    //
    private class SequenceSelector {
        private Iterator<String> it;
        public SequenceSelector(Iterator<String> it){
            this.it = it;
        } 

        public void display(){
           while(it.hasNext()){
               String s = it.next();
               System.out.print(s+" ");
           }  
           System.out.println();
        }    
    }

    public SequenceSelector selector(){
        return new SequenceSelector(items.iterator());
    }

    public static void main(String[] args){
       Sequence sequence = new Sequence();
       for(int i=0;i<10;i++){
           sequence.add("str"+i);
       }   
       SequenceSelector selector = sequence.selector();
       selector.display();
    }
}
//E10 EA
class Rodent{ public String toString(){return "Rodent";}}
class Mouse extends Rodent{public String toString(){return "Mouse";}}
class E10Gerbil extends Rodent{public String toString(){return "Gerbil";}}
class Hamster extends Rodent{public String toString(){return "Hamster";}}

class E10 {
   public static void main(String[] args){
    List<Rodent> rodents = new ArrayList<Rodent>(Arrays.asList(
        new Mouse(),new E10Gerbil(),new Hamster()
    )); 
     Iterator it = rodents.iterator();
     while(it.hasNext()){
       Rodent r = (Rodent)it.next();
       System.out.println(r); 
     }
   } 
}
//***ListIterator*********************************************/
/*
ListIterator只能用于各种List，尽管Iterator只能向前移动，ListIterator可以双向运动
*/
class ListIteration {
  public static void main(String[] args){
    List<String> pets = new ArrayList<String>(Arrays.asList(
        "Rat","Manx","Cymric","Mutt","Pug","Rat1","Rat2","Rat3"
    ));

    ListIterator<String> it = pets.listIterator();
    while(it.hasNext()){
        System.out.print(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + "; ");
    }
    System.out.println();
    //Backwards
    while(it.hasPrevious()){
        System.out.print(it.previous() + " ");
    }
    System.out.println();
    System.out.println(pets);
    it = pets.listIterator(3);//指定索引开始位置
    while(it.hasNext()){
        it.next();
        it.set("hello");//set替换访问的最后一个元素
    } 
    System.out.println(pets);
  }
}
//E12 EC
class E12 {
    public static void main(String[] args){

       List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
       List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
       ListIterator<Integer> it = list1.listIterator(list1.size());
  
       while(it.hasPrevious()){
           list2.add(it.previous());
       }
       for(Integer i : list2){
           System.out.print(i + " ");
       }
       System.out.println();
    }
}

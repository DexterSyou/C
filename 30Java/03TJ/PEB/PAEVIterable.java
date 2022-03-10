import java.util.*;
//
public class PAEVIterable {}
//****************************** */

class ReversibleArrayList<T> extends ArrayList<T> {

    public ReversibleArrayList(Collection<T> c) {super(c);}
    public Iterable<T> reversed(){
       //public interface Iterable<T> 可以foreach循环
       /*  Iterator<T> 	iterator() */
       return new Iterable<T>(){
          //
          public Iterator<T> iterator(){
              //public interface Iterator<E>
              /*  boolean 	hasNext()
                  E 	    next()
                  void 	    remove()
              */
              return new Iterator<T>(){
                int current = size()-1;
                public boolean hasNext() { return current> -1;} 
                public T next() { return get(current--);}
                public void remove(){
                    throw new UnsupportedOperationException();
                } 
              }; 
          } 
       };    
    }
    //
}

class AdapterMethodIdiom {
        public static void main(String[] args){
            ReversibleArrayList<String> ral = new ReversibleArrayList<String>(Arrays.asList("To be or not to be".split(" ")));
            for(String s : ral)
              System.out.print(s + " ");
            System.out.println();
            for(String s: ral.reversed())
              System.out.print(s + " ");
            System.out.println();
        }
}
//****************************************** */
class IterableClass implements Iterable<String>{

    protected String[] words = ("And that is how " + 
     "we know the Earth to be banana-shaped.").split(" ");
   
    public Iterator<String> iterator(){
      //遍历数组words  
      return new Iterator<String>(){
            private int index = 0;
            public boolean hasNext(){
                return index < words.length;
            }
            public String next(){
                index++;//
                return words[1];//that that that that that that that that that that that
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }   
      };
    }
}
//E32 
class MultiIterableClass extends IterableClass {
    public Iterable<String> reversed(){
       return new Iterable<String>(){
          public Iterator<String> iterator(){
              return new Iterator<String>(){
                int current = words.length-1;
                public boolean hasNext() { return current> -1;} 
                public String next() { return words[current--];}
                public void remove(){
                    throw new UnsupportedOperationException();
                } 
              }; 
          } 
       };    
    }
    public Iterable<String> randomized(){
        return new Iterable<String>(){
            public Iterator<String> iterator(){
                List<String> shuffled = new ArrayList<String>(Arrays.asList(words));
                Collections.shuffle(shuffled,new Random(47)); 
                return shuffled.iterator();
            }
        };
    }

    public static void main(String[] args){
         MultiIterableClass mic = new MultiIterableClass();
         for(String s: mic.reversed())
            System.out.print(s + "  ");
         System.out.println();
         for(String s: mic.randomized())
            System.out.print(s + "  ");
         System.out.println();
         for(String s: mic)
            System.out.print(s + "  ");
         System.out.println();
    }
}

//
class ModifyArraysList {

    public static void main(String[] args){
       Random rand = new Random(47);
       Integer[] ia = {1,2,3,4,5,6,7,8,9,10};
       List<Integer> list1= new ArrayList<Integer>(Arrays.asList(ia));
       System.out.println("Before shuffling: " + list1);
       Collections.shuffle(list1,rand);
       System.out.println("After shuffling: " + list1);
       System.out.println("array: " +Arrays.toString(ia));

       List<Integer> list2= Arrays.asList(ia);
       System.out.println("Before shuffling: " + list2);
       Collections.shuffle(list2,rand);
       System.out.println("After shuffling: " + list2);
       System.out.println("array: " +Arrays.toString(ia));
    }
}


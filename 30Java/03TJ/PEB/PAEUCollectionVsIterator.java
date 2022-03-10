import java.util.*;
class PAEUCollectionVsIterator {}
//
/* Collection 描述所有序列容器的共性根接口即因为要表示其他若干接口的共性而出现的接口
   java.util.AbstractCollection提供了Collection的默认实现，可以创建AbstractCollection子类 
   迭代器赖表示容器之间的共性，实现Collection就意味着需要提供iterator()方法 */
class InterfaceVsIterator {
   public static void display(Iterator<String> it){
       while(it.hasNext()){
           String p = it.next();
           System.out.print(p + " ");
       }
       System.out.println();  
   }

   public static void display(Collection<String> pets){
       for(String p : pets){
           System.out.print(p + " ");
       }
       System.out.println();
   }

   public static void main(String[] args){
       List<String> petList = new ArrayList<String>(Arrays.asList("Cat","Dog","LIon","Cat","Cat","Cat","Cat","Bird"));
       Set<String> petSet = new HashSet<String>(petList);
       Map<String,String> petMap= new LinkedHashMap<String,String>();
       String[] names = ("Ralph,Eric,Robin,Lacey"+"Britney,Sam,Spot,Fluffy").split(",");
       for(int i=0;i<names.length;i++){
           petMap.put(names[i],petList.get(i));
       }  

       display(petList);
       display(petSet);
       display(petList.iterator());
       display(petList.iterator());
       System.out.println(petMap); 
       System.out.println(petMap.keySet()); 
       display(petMap.values());
       display(petMap.values().iterator());
   }
}

//
class CollectionSequence extends AbstractCollection<String> {
    private String[] pets = {"Cat","Dog","Lion","Tiger","Dog"};
    public int size(){ return pets.length;}
    public Iterator<String> iterator(){ //实现Collection接口就必须实现Iterator
    //CollectionSequence不是抽象的, 并且未覆盖AbstractCollection中的抽象方法iterator()
        return new Iterator<String>(){
            private int index = 0;
            public boolean hasNext(){
                return index <pets.length;
            }
            public String next(){
                return pets[index++];
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args){
        CollectionSequence  c = new CollectionSequence();
        InterfaceVsIterator.display(c);
        InterfaceVsIterator.display(c.iterator());
    }
}

//
class PetSequence {
    protected String[] pets = {"Cat","Dog","Lion","Tiger","Dog"};
}

class NonCollectionSequence extends PetSequence{

    public Iterator<String> iterator(){
        return new Iterator<String>(){
            private int index = 0;
            public boolean hasNext(){
                return index < pets.length;
            }
            public String next(){
                return pets[index++];
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args){
        NonCollectionSequence  c = new NonCollectionSequence();
        //InterfaceVsIterator.display(c.iterator());
    }
}
//E30
/*
class EU implements Collection{
    public Iterator<String> iterator(){
     //CollectionSequence不是抽象的, 并且未覆盖AbstractCollection中的抽象方法iterator()
        return new Iterator<String>(){
            public boolean hasNext(){ return true;}
            public String next(){ return "";}
            public void remove(){}
        };
    }
    
    // EU不是抽象的, 并且未覆盖Collection中的抽象方法clear()
    public void clear(){}
    //EU不是抽象的, 并且未覆盖Collection中的抽象方法retainAll(Collection)
    public boolean retainAll(Collection c){}
    //EU不是抽象的, 并且未覆盖Collection中的抽象方法removeAll(Collection)
    //....
}
*/

//Foreach
/*
  JavaSE5 引入了Itrable接口，public interface Iterator<E>
  该接口包含一个能产生Iterator的iterator()方法，Itrable接口被foreach用来在序列中移动
 */
class ForEachCollections {

    public static void main(String[] args){
        Collection<String> cs = new LinkedList<String>();
        Collections.addAll(cs,"Take the long way home".split(" "));
        //foreach应用到Collection上
        for(String s : cs){
            System.out.print("'"+s+"'");
        }
    }
}

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

    public static void main(String[] args){
        for(String s: new IterableClass()){
            System.out.print(s+" ");
        }
        System.out.println();
    }

}

//JavaSE5 大量类都是Iterable类型，主要Collection类，不包括Map
class EnvironmentVariables{
   public static void main(String[] args){
       //entrySet产生一个由Map.Entry元素构成的Set，并且这个Set是Iterable
       for(Map.Entry entry : System.getenv().entrySet()){
           System.out.println(entry.getKey() + ": " + entry.getValue());
       }  
   }
}

class ArraysIsNotIterable {
   
   static<T> void test(Iterable<T> ib){
       for(T t: ib){
           System.out.print(t + " ");
       }
       System.out.println();
   }

   public static void main(String[] args){
        test(Arrays.asList(1,2,3));
        String[] strings =  {"A","B","C"};
        test(Arrays.asList(strings));
        //！test(strings);
        //数组不会自动转化成Iterable，不是Iterable，自动包装也不会自动发生
        //无法将类 ArraysIsNotIterable中的方法 test应用到给定类型;
        // 需要: Iterable<T> 找到: String[]
   }
}

//************************** */
//E31
class Shape{}
class Circle extends Shape{}
class Square extends Shape{}
class Triangle extends Shape{}

class RandomShapeGenerator implements Iterable<Shape> {

    private Random rand = new Random(47);
    Shape[] shape;
    RandomShapeGenerator(int count){
        shape = new Shape[count];
        for(int i=0;i<shape.length;i++) shape[i] = next();
    }

    public Shape next(){
        switch(rand.nextInt(3)){
            default:
            case 0: return new Circle();
            case 1: return new Square();
            case 2: return new Triangle();
        }
    }

    public Iterator<Shape> iterator(){
        return new Iterator<Shape>(){
            private int index = 0;
            public boolean hasNext(){
                return index < shape.length;
            }
            public Shape next(){
                return shape[index++];
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
}

class E31 {
    public static void main(String[] args){
    
       RandomShapeGenerator rs = new RandomShapeGenerator(3);
       Iterator<Shape> it = rs.iterator();
       while(it.hasNext()){
           System.out.println(it.next());
           //it.remove();
       } 
    }
}

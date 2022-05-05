import java.util.*;
import java.lang.reflect.*;
//
public class P4EH_IGenericSets{}
//*************************************************** */
enum Watercolors {
    ZINC,LEMON_YELLOW,MEDIUM_YELLOW,DEEP_YELLOW,ORANGE,
    BRILLIANT_RED,CRIMSON,MAGENTA,ROSE_MADDER,VIOLET,
    CERULEAN_BLUE_HUE,PHTHALO_BLUE,ULTRAMARINE,
    COBALT_BLUE_HUE,PERMANENT_GREEN,VIRIDIAM_HUE,
    SAP_GREEN,YELLOW_OCHRE,BURNT_SIENNA,RAW_UMBER,
    BURNT_UMBER,PAYNMS_GRAY,IVORY_BLACK
}
//
class Sets {
    public static <T> Set<T> union(Set<T> a, Set<T> b){
        Set<T> result = new HashSet<T>(a);
        result.addAll(b);
        return result;   
    }

    public static <T> Set<T> intersection(Set<T> a, Set<T> b){
        Set<T> result = new HashSet<T>(a);
        result.retainAll(b);
        return result;  
    }

    public static <T> Set<T> difference(Set<T> superset, Set<T> subset){
        Set<T> result = new HashSet<T>(superset);
        result.removeAll(subset);
        return result;  
    }

    public static <T> Set<T> complement(Set<T> a, Set<T> b){
        return difference(union(a,b),intersection(a,b));
    }
}
//
class WatercolorSets {
    public static void main(String[] args){
        Set<Watercolors> set1 = EnumSet.range(Watercolors.BRILLIANT_RED,Watercolors.VIRIDIAM_HUE);
        Set<Watercolors> set2 = EnumSet.range(Watercolors.CERULEAN_BLUE_HUE,Watercolors.BURNT_UMBER);
        
        System.out.println("SET1 : " + set1);
        System.out.println("SET2 : " + set2);
        System.out.println("***************************************************");
        //
        System.out.println("union(set1,set2) : " + Sets.union(set1, set2));
        Set<Watercolors> subset = Sets.intersection(set1,set2);
        System.out.println("intersection(set1,set2) : " + Sets.intersection(set1,set2));
        System.out.println("difference(set1,subset) : " + Sets.difference(set1,subset));
        System.out.println("difference(set2,subset) : " + Sets.difference(set2,subset));
        System.out.println("complement(set1,set2) : " + Sets.complement(set1,set2));
    }
}
//
class ContainerMethodDifferences {
    static Set<String> methodSet(Class<?> type){
        Set<String> result = new TreeSet<String>();
        for(Method m : type.getMethods()){
            result.add(m.getName());
        }
        return result;
    }

    static void interfaces(Class<?> type){
        System.out.println("Interfaces in " + type.getSimpleName() + ": ");
        List<String> result = new ArrayList<String>();
        for(Class<?> c : type.getInterfaces()){
            result.add(c.getSimpleName());
        }
        System.out.println(result);
    }

    static Set<String> object = methodSet(Object.class);
    static { object.add("clone");}
    static void difference(Class<?> superset, Class<?> subset){
        System.out.println(superset.getSimpleName() +
          " extends " + subset.getSimpleName() + ", adds: ");
        Set<String> comp = Sets.difference(methodSet(superset),methodSet(subset));
        comp.removeAll(object);
        System.out.println(comp);
        interfaces(superset);
    }

    public static void main(String[] args){
        System.out.println("Collection: " + methodSet(Collection.class));
        interfaces(Collection.class); 
        difference(Set.class,Collection.class);
        difference(HashSet.class,Set.class);
        //...

    }
} 
//
//E17 ??
//*************************************************** */
/*
class Customer {
    private static long counter = 1;
    private final long id = counter++;
    private Customer() {}

    public String toString() { return "Customer" + id; }
    public static Generator<Customer> generator(){
        return new Generator<Customer>(){
            public Customer next() { return new Customer();}
        };
    }
}

class Teller {
   private static long counter = 1;
   private final long id = counter++;
   private Teller(){}
   public String toString(){
       return "Teller" + id;
   }
   //
   public static Generator<Teller> generator = new Generator<Teller>(){
       public Teller next() { return new Teller();}
   };
}

class BankTeller {
    public static void serve(Teller t, Customer c){
        System.out.println(t + " serve " + c);
    }
    public static void main(String[] args){
        Random rand = new Random(47);
        Queue<Customer> line = new LinkedList<Customer>();
        Generator.fill(line,Customer.generator(),15);
        List<Teller> tellers = new ArrayList<Teller>();
        Generators.fill(tellers,Teller.generator,4);
        for(Customer c: line){
            serve(teller.get(rand.nextInt(teller.size())),c);
        }
    }
}
*/
//E18



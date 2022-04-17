import java.util.*;
public class P4Generic {
    public static void main(String []args){
    }
}
//*******************************************
/* Class引用总是指向某个Class对象
 *   可以制造类的实例，并包含可作用于这些实例的所有方法代码。
 *   
 * Class引用表示的就是 它所指向的对象的确切类型，而该对象便是Class类的一个对象。
 */
class GenericClassReferences {
  public static void main(String[] args){
    Class intClass = int.class;
	Class<Integer> genericIntClass = int.class;
	genericIntClass = Integer.class;
	intClass = double.class;
//    genericIntClass = double.class;
//    incompatible types: Class<Double> cannot be converted to Class<Integer>
  }
}
//
class WildcardClassReferences {
  public static void main(String[] args){
     Class<?> intClass = int.class;
	 intClass = double.class;
  }
}
//
class BoundedClassReferences {
  public static void main(String[] args){
    Class<? extends Number> bounded = int.class;
	bounded = double.class;
	bounded = Number.class;
  }  
}
//***********************************************
class CountedInteger {
  private static long counter;
  private final long id = counter++;
  public String toString(){ return Long.toString(id); }
}

class FilledList<T> {
  private Class<T> type;
  private FilledList(Class<T> type) { this.type = type; }
  public List<T> create(int nElements){
     List<T> result = new ArrayList<T>();
	 try{
	   for(int i=0;i<nElements;i++){
	     result.add(type.newInstance());
	   }
	 }catch(Exception e){
	   throw new RuntimeException(e);
	 }

	 return result;
  }

  public static void main(String[] args){
    FilledList<CountedInteger> fl = new FilledList<CountedInteger>(CountedInteger.class);
	System.out.println(fl.create(15));
  }
}
//*************************************************
class FancyToy{}
class GenericToyTest {
  public static void main(String[] args) throws Exception {
     Class<FancyToy> ftClass = FancyToy.class;
	 FancyToy fancyToy = ftClass.newInstance();
	 //某个FancyToy的超类
	 Class<? super FancyToy> up = ftClass.getSuperclass();
     //Class<Toy> up2 = ftClass.getSuperclass();
	 //won't compile
	 
	 //返回Object
	 Object obj = up.newInstance();
  }
}
//*****************************************************
class Building {}
class House extends Building {}
class ClassCasts {
  public static void main(String[] args){
     Building b = new House();
	 Class<House> houseType = House.class;
	 House h = houseType.cast(b);
	// h = (House)b;
  }
}
//*****************************************************
//代表对象的类型的Class对象，通过查询Class对象可以获取运行时所需要的信息
class Individual {
    public Individual(){}
	public Individual(String name){ System.out.println("Individual:"+name);}
}
class Person extends Individual {
  public Person(String name) { super(name); }
}
class Pet extends Individual {
  public Pet(String name) { super(name); }
  public Pet() { super(); }
}
class Dog extends Pet {
  public Dog(String name) { super(name);}
  public Dog() { super();}
}
class Mutt extends Dog{
  public Mutt(String name){ super(name);}
  public Mutt() { super(); }
}
class Pug extends Dog {
  public Pug(String name){ super(name);}
  public Pug(){ super();}
}
class Cat extends Pet{
  public Cat(String name) { super(name);}
  public Cat() { super();}
}
class EgyptianMau extends Cat {
   public EgyptianMau(String name){super(name);}
   public EgyptianMau(){super();}
}
class Manx extends Cat{
  public Manx(String name) { super(name);}
  public Manx(){ super();}
}
class Cymric extends Manx {
  public Cymric(String name){ super(name); }
  public Cymric() { super();}
}
class Rodent extends Pet {
  public Rodent(String name) { super(name); }
  public Rodent(){ super(); }
} 
class Rat extends Rodent {
  public Rat(String name) { super(name);}	
  public Rat() { super();}
}
class Mouse extends Rodent {
  public Mouse(String name){ super(name);}
  public Mouse(){ super();}
}
class Hamster extends Rodent {
  public Hamster(String name) { super(name);}
  public Hamster() { super(); }
}
abstract class PetCreator {
  private Random rand = new Random(47);
  public abstract List<Class<? extends Pet>> types();
  public Pet randomPet(){
     int n = rand.nextInt(types().size());
	 try{
	   return types().get(n).newInstance();
	 }catch(InstantiationException e){
	   throw new RuntimeException(e);
	 }catch(IllegalAccessException e){
	   throw new RuntimeException(e);
	 }
  }
  public Pet[] createArray(int size){
    Pet[] result = new Pet[size];
	for(int i=0; i<size; i++){
	  result[i] = randomPet();
	}
	return result; 
  }
  public ArrayList<Pet> arrayList(int size){
    ArrayList<Pet> result = new ArrayList<Pet>();
	Collections.addAll(result,createArray(size));
	return result;
  }
}
class ForNameCreator extends PetCreator {
   private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
   private static String[] typeNames = {
     "Mutt",
	 "Pug",
	 "EgyptianMau",
	 "Manx",
	 "Cymric",
	 "Rat",
	 "Mouse",
	 "Hamster"
   };
   @SuppressWarnings("unchecked")
   private static void loader(){
     try{
	   for(String name: typeNames){
	     types.add((Class<? extends Pet>)Class.forName(name));
	   }
	 }catch(ClassNotFoundException e){
	   throw new RuntimeException(e);
	 }
   }
   static { loader(); }
   public List<Class<? extends Pet>> types() { return types;}
}
//*******************************************************
class PetCount {
  static class PetCounter extends HashMap<String,Integer>{
      public void count(String type){
          Integer quantity = get(type);
	      if(quantity == null)
		     put(type,1);
	      else
		     put(type,quantity + 1);
	  }
  }
  static void countPets(PetCreator creator){
    PetCounter counter = new PetCounter();
	for(Pet pet : creator.createArray(20)){
	  System.out.println(pet.getClass().getSimpleName() + " ");
	  if(pet instanceof Pet)     counter.count("Pet");
	  if(pet instanceof Dog)     counter.count("Dog");
	  if(pet instanceof Mutt)    counter.count("Mutt");
	  if(pet instanceof Pug)     counter.count("Pug");
	  if(pet instanceof Cat)     counter.count("Cat");
	  if(pet instanceof Manx)    counter.count("Manx");
	  if(pet instanceof EgyptianMau) counter.count("EgyptianMau");
	  if(pet instanceof Rodent)  counter.count("Rodent");
	  if(pet instanceof Rat)     counter.count("Rat");
	  if(pet instanceof Mouse)   counter.count("Mouse");
	  if(pet instanceof Hamster) counter.count("Hamster");	
	}
	System.out.println();
	System.out.println(counter);
  }
  public static void main(String[] args){
    countPets(new ForNameCreator());
  }
}














































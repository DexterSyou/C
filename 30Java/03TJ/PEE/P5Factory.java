import java.util.*;
public class P5Factory {
    public static void main(String []args){
    }
}
//*******************************************
interface IFactory<T>{ T create();}
class Part {
  public String toString(){
    return getClass().getSimpleName();
  }

  static List<IFactory<? extends Part>> partFactories = new ArrayList<IFactory<? extends Part>>();
  static {
     partFactories.add(new FuelFilter.Factory());
	 partFactories.add(new AirFilter.Factory());
	 partFactories.add(new CabinAirFilter.Factory());
     partFactories.add(new OilFilter.Factory());
	 partFactories.add(new FanBelt.Factory());
	 partFactories.add(new PowerSteeringBelt.Factory());
	 partFactories.add(new GeneratorBelt.Factory());
  }
  private static Random rand = new Random(47);
  public static Part createRandom() {
    int n = rand.nextInt(partFactories.size());
	return partFactories.get(n).create();
  }
}

class Filter extends Part{}
class FuelFilter extends Filter {
  public static class Factory implements IFactory<AirFilter>{
    public AirFilter create() { return new AirFilter(); }
  }
}
class AirFilter extends Filter {
  public static class Factory implements IFactory<AirFilter> {
    public AirFilter create() { return new AirFilter();}
  }
} 
class CabinAirFilter extends Filter {
 public static class Factory implements IFactory<CabinAirFilter>{ 
  public CabinAirFilter create(){
    return new CabinAirFilter();
  }
 }
} 
class OilFilter extends Filter {
  public static class Factory implements IFactory<OilFilter> {
    public OilFilter create() { return new OilFilter();}
  }
}
class Belt extends Part {}
class FanBelt extends Belt {
  public static class Factory implements IFactory<FanBelt> {
    public FanBelt create() { return new FanBelt();}
  }
}
class GeneratorBelt extends Belt {
  public static class Factory implements IFactory<GeneratorBelt>{
    public GeneratorBelt create(){
	  return new GeneratorBelt();
	}
  }
}
class PowerSteeringBelt extends Belt {
  public static class Factory implements IFactory<PowerSteeringBelt> {
     public PowerSteeringBelt create() {
	   return new PowerSteeringBelt();
	 }
  }
}

class RegisteredFactories {
  public static void main(String[] args){
    for(int i=0;i<10;i++){
	   System.out.println(Part.createRandom());
	}
  }
}

//******************************************
//EE14 EF15 EG16
class EE14 {
  public static void main(String[] args){
	List<Class<? extends Part>> partClasses = new ArrayList<Class<? extends Part>>(); 
	partClasses.add(FuelFilter.class);
	partClasses.add(AirFilter.class);
	partClasses.add(CabinAirFilter.class);
    partClasses.add(OilFilter.class);
	partClasses.add(FanBelt.class);
	partClasses.add(PowerSteeringBelt.class);
	partClasses.add(GeneratorBelt.class);
     
	for(int i=0;i<partClasses.size();i++){
  	   try{
		 System.out.println( partClasses.get(i).newInstance());
	   }catch(InstantiationException e){
	     throw new RuntimeException(e);
	   } catch(IllegalAccessException e){
	     throw new RuntimeException(e);
	   }
	}
  }
}


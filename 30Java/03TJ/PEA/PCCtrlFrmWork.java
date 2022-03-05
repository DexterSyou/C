import java.util.*;
public class PCCtrlFrmWork {}
//**************************************************
//The common methods for any control event.
abstract class Event {
	private long evenTime;
	protected final long delayTime;
	public Event(long delayTime){
	  this.delayTime = delayTime;
	  start();
	}

	public void start(){
	  evenTime = System.nanoTime() + delayTime;
	}
	public boolean ready(){
	  return System.nanoTime() >= evenTime;
	}
	public abstract void action();
}

class Controller {
  private List<Event> eventList = new ArrayList<Event>();
  public void addEvent(Event c){ eventList.add(c);}
  public void run(){
     while(eventList.size()>0){
	    for(Event e : new ArrayList<Event>(eventList)){
		   if(e.ready()){
		      System.out.println(e);
			  e.action();
			  eventList.remove(e);
		   }
		}
	 }
  }
  /*
   * 各种不同的Event对象所具有的不同行为，通过创建不同的Event子类来表现不同的行为
   */
}
//*****************************************
class GreenhouseControls extends Controller {
 /*控制框架的完整实现为单个类
  *实现的细节被封装
  *in a single class， Inner class different event
  */
  private boolean light = false;
  //
  public class LightOn extends Event{
     public LightOn(long delayTime){
	   super(delayTime);
	 }
     //
	 public void action(){
	   light = true;
	 }
	 //
	 public String toString(){
	   return "Light is on";
	 }
  }
  //
  public class LightOff extends Event {
     public LightOff(long delayTime){
	    super(delayTime);
	 }

	 public void action(){
	   light = false;
	 }

	 public String toString(){
	   return "Light is off";
	 }
  }
  //
  private boolean water = false;
  public class WaterOn extends Event{
     public WaterOn(long delayTime){ super(delayTime);}
    
	 public void action(){
	   water = true;
	 }

	 public String toString(){
	   return "Greenhouse water is on";
	 }
  } 
  //
  public class WaterOff extends Event{
     public WaterOff(long delayTime){ super(delayTime);}
    
	 public void action(){
	   water = false;
	 }

	 public String toString(){
	   return "Greenhouse water is off";
	 }
  }
 //
 private String thermostat = "Day";  
 public class ThermostatNight extends Event{
     public ThermostatNight(long delayTime){ super(delayTime);}
    
	 public void action(){
	   thermostat = "Night";
	 }

	 public String toString(){
	   return "Thermostat on night setting";
	 }
  }
 //
 public class ThermostatDay extends Event{
   public ThermostatDay(long delayTime){
     super(delayTime);
   }

   public void action(){
     thermostat = "Night";
   }

   public String toString(){
     return "Thermostat on day setting";
   }
 }
 //
 public class Bell extends Event{
   public Bell(long delayTime){
     super(delayTime);
   }
   public void action(){
     addEvent(new Bell(delayTime));
   }
   public String toString() { return "Bing!";}
 }
 //
 public class Restart extends Event{
    private Event[] eventList;
	public Restart(long delayTime,Event[] eventList){
	   super(delayTime);
	   this.eventList = eventList;
       for(Event e : eventList){
	     addEvent(e);
	   }
	}

	public void action(){
	  for(Event e: eventList){
	     e.start();
		 addEvent(e);
	  }
	  start();
	  addEvent(this);
	}

    public String toString(){
	  return "Restarting system";
	}
 }
 //
 public static class Terminate extends Event{
    public Terminate(long delayTime){ super(delayTime);}
	public void action(){ System.exit(0);}
	public String toString() { return "Terminating";}
 }
 //Fan
 //E24 public class Fan extends Event{}
 //
 //
}
//E25
class EP extends  GreenhouseControls{

  public class PlaneOn extends Event{
	  public PlaneOn(long delayTime){
        super(delayTime);
      }
      public void action(){
        System.out.println("PlaneOn Action..");
	  }
      public String toString(){
         return "plane on setting";
      }
  }
	//
  public class PlaneOff extends Event{
	
	  public PlaneOff(long delayTime){
        super(delayTime);
      }
      public void action(){
        System.out.println("PlaneOff Action..");
	  }
      public String toString(){
         return "plane off setting";
      }
  }
} 
//
class GreenhouseController{
   public static void main(String[] args){
      GreenhouseControls gc = new GreenhouseControls(); 
      //E25
	  EP ep = new EP();
	  gc.addEvent(gc.new Bell(900));
	  Event[] eventList = {
	    gc.new ThermostatNight(0),
		gc.new LightOn(200),
		gc.new LightOff(400),
        gc.new WaterOn(600),
		gc.new WaterOff(800),
		gc.new ThermostatDay(1400),
		ep.new PlaneOn(200),
		ep.new PlaneOff(200)
	  };
	  gc.addEvent(gc.new Restart(2000,eventList));
      if(args.length == 1){
	    gc.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
	  }
	  gc.run();
   }
}







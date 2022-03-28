class P8EKExceptionRestrict{}
//
//异常限制，覆盖方法只能抛出在基类方法的异常说明的异常
class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}
//E20 EK
class UmpireArgument extends BaseballException {}
//
abstract class Inning {
     public Inning() throws BaseballException{}
     public void event() throws BaseballException{} //声明将抛出异常
     public abstract void atBat() throws Strike, Foul;
     public void walk(){}
//
     public abstract void f() throws UmpireArgument;
}

class StromException extends Exception {}
class RainedOut      extends StromException {}
class PopFoul        extends Foul {}
interface Storm {
    public void event() throws RainedOut;//声明将抛出新的异常
    public void rainHard() throws RainedOut;
}

class StormyInning extends Inning implements Storm {
    //异常限制对构造器不起作用，派生类异常说明必须包含基类构造器的异常说明（基类被调用）
    public StormyInning() throws RainedOut, BaseballException{};
    public StormyInning(String s) throws Foul, BaseballException{};
 //! void walk() throws PopFoul {} // StormyInning中的walk()无法覆盖Inning中的walk()
   
 //! public void event() throws RainedOut {} //StormyInning中的event()无法覆盖Inning中的event()
    public void rainHard() throws RainedOut{}
    public void event(){}
    public void atBat() throws PopFoul {}
 //
    public void f() throws UmpireArgument {}
    public static void main(String[] args){
        try{
           StormyInning si = new  StormyInning();
           si.atBat();
        }catch(PopFoul e){
           System.out.println("Pop foul");  
        }catch(RainedOut e){
           System.out.println("Rained out");
        }catch(BaseballException e){            
           System.out.println("Generic baseball exception");
        }
        //***************************************** */
        try{
           Inning i = new StormyInning();
           i.atBat();
        }
        catch(Strike e){
           System.out.println("Strike");  
        }
        catch(Foul e){
           System.out.println("Foul"); 
        }
        catch(RainedOut e){
           System.out.println("Rained out");
        } //! 未报告的异常错误RainedOut; 必须对其进行捕获或声明以便抛出
        catch(BaseballException e){   //!未报告的异常错误BaseballException; 必须对其进行捕获或声明以便抛出         
           System.out.println("Generic baseball exception");
        }
    
    }
}

import java.lang.reflect.*;
public class P8E21To23Proxy {
    public static void main(String []args){

    }
}

//*******************************************
interface Interface{
  void doSomething();
  void somethingElse(String arg);
}

class RealObject implements Interface {
  public void doSomething(){System.out.println("doSomething");}
  public void somethingElse(String arg){ System.out.println("somethingElse" + arg);}
}

class SimpleProxy implements Interface {
  private Interface proxied;
  //E21 
  private static int count=0;
  public SimpleProxy(Interface proxied){
    this.proxied = proxied;
  }
  
  public void doSomething(){
    System.out.println("SimpleProxy somethingElse");
	proxied.doSomething();
	System.out.println(++count);
  }

  public void somethingElse(String arg){
    System.out.println("SimpleProxy somethingElse" + arg);
	proxied.somethingElse(arg); 
  }
}

class SimpleProxyDemo {
   public static void consumer(Interface iface){
     iface.doSomething();
	 iface.somethingElse("bonobo");
   }
   public static void main(String[] args){
     consumer(new RealObject());
	 consumer(new SimpleProxy(new RealObject()));
   }
}

//
class DynamicProxyHandler implements InvocationHandler {
  private Object proxied;
  public DynamicProxyHandler(Object proxied){
    this.proxied = proxied;
  }
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
    System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args:" +args);
	if(args != null){
	  for(Object arg :args){
	    System.out.println(" "+args);
	  }
	}
	return method.invoke(proxied,args);
  }
}

class SimpleDynamicProxy {
  public static void consumer(Interface iface){
    iface.doSomething();
	iface.somethingElse("bonobo");
  }
  
  public static void main(String[] args){
    RealObject real = new RealObject();
    //E22
	//SimpleProxy sim = new SimpleProxy(real);
	consumer(real);
	Interface proxy = (Interface)Proxy.newProxyInstance(
			Interface.class.getClassLoader(),
			new Class[]{Interface.class},
			new DynamicProxyHandler(real));
	consumer(proxy);
  }
}

//***************
class MethodSelector implements InvocationHandler {
  private Object proxied;
  public MethodSelector(Object proxied){
    this.proxied=proxied;
  }
  public Object invoke(Object proxy, Method method , Object[] args) throws Throwable{
    if(method.getName().equals("interesting"))
		System.out.println("Proxy detected the interesting method");
	return method.invoke(proxied,args);
  }
}

interface SomeMethods {
  void boring1();
  void boring2();
  void interesting(String arg);
  void boring3();
}

class Implementation implements SomeMethods {

  public void boring1(){System.out.println("boring1");}
  public void boring2(){System.out.println("boring2");}
  public void interesting(String arg){System.out.println("interesting "+arg);}
  public void boring3(){System.out.println("boring3");}
}

class SelectingMethods{
  public static void main(String[] args){
    SomeMethods proxy = (SomeMethods)Proxy.newProxyInstance(
			 SomeMethods.class.getClassLoader(),
			 new Class[]{SomeMethods.class},
			 new MethodSelector(new Implementation())
			);
	proxy.boring1();
	proxy.boring2();
	proxy.boring3();
	proxy.interesting("hello world");
  }
}
//E23
//

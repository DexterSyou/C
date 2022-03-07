import java.util.LinkedList;

public class P6EFStack {

    public static void main(String []args){

    }

}

//*******************************************
class Stack<T> {
  private LinkedList<T> storage = new LinkedList<T>();
  public void push(T v) { storage.addFirst(v);         }
  public T    peek()    { return storage.getFirst();   }
  public T    pop()     { return storage.removeFirst();}
  public boolean empty(){ return storage.isEmpty();    }
  public String toString(){ return storage.toString(); }
}

class StackTest {
	public static void main(String[] args){
	   Stack<String> stack = new Stack<String>();
	   for(String s: "My dog has fleas".split(" ")){
	     stack.push(s);
	   }
	   while(!stack.empty()){
	     System.out.println(stack.pop() + " ");
	   }
	}
}

class EF {

  static String str = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---";
  public static void main(String[] args){
    char c;
	Stack<Character> stack = new Stack<Character>();
	for(int i=0;i<str.length();i++) {
	  c = str.charAt(i);
      if('+'==c){
		i++;
		c=str.charAt(i);   
	    stack.push(c); 
	  }else if('-' == c){
	    System.out.print(stack.pop()); 
	  }
    }
	System.out.println();
  }
}




public class P5RTE {
    static void f() {
      throw new RuntimeException("From f()");	 
    }
	  
    static void g(){
	   f();
	}	

    public static void main(String []args){
        // RuntimeException , 编译器不需要声明，在程序结束前调用printStackTrace
		// RuntimeException代表的是编程错误，忽略RuntimeException及其子类类型的异常
		// 其他类型异常处理都是由编译器强制实施的
		g();
    }

}

//*******************************************

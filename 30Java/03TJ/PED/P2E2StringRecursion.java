import java.util.*;
class P2E2StringRecursion{}
//**************************************************************** */
class ArrayListDiplay {
   public static void main(String[] args){
       ArrayList<String> strs = new ArrayList<String>();
       for(int i=0;i<10 ;i++){
           strs.add("a ");
       }
       System.out.println(strs);
   }
}

class InfiniteRecursion {
    public String toString(){
        //E2
        /*
          return " InfiniteRecursion address: " + this + "\n";
          字符串 + this，this会被转换成字符串，即会调用toString 产生递归调用
        */
        //Object.toString() 无法从静态上下文中引用非静态 方法 toString()
        return " InfiniteRecursion address: " + super.toString() + "\n";
    }
    public static void main(String[] args){
        List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
        for(int i =0; i < 10; i++){
            v.add(new InfiniteRecursion());
        }
        System.out.println(v);
    }
}

import java.util.*;
public class P3E5To7List{}
//*********************************** */
/* 特定序列中
 ArrayList 
 LinkedList
*/
class ListFeatures {
  //E5 E6
  public static void main(String[] args){
     Random rand = new Random(47);
     //
     List<String> pets = new ArrayList<String>();
     Collections.addAll(pets,"Rat","Manx","Cymric","Mutt","Pug","Cymric","Pug");
     System.out.println("1: "+ pets);
     System.out.println("\n//Automatically resizes-------------------------------");
     String h = "Hamster";
     pets.add(h);
     System.out.println("2: "+ pets);
     System.out.println("3: "+ pets.contains(h));//contains确定某个对象是否在列表中
     pets.remove(h);
     //
     System.out.println("\n//Must be the exact object-----------------------------");
     String p = pets.get(2);
     System.out.println("4: "+ p +" "+pets.indexOf(p));
     String cymric = "Cymric";//new String();//List 的移除，发现某个元素都会用到equals
     System.out.println("5: "+ pets.indexOf(cymric));
     System.out.println("6: "+ pets.remove(cymric));
     System.out.println("7: "+ pets.remove(p));
     System.out.println("8: "+ pets);
     //插入，删除代价高
     System.out.println("\n//Insert-----------------------------");
     pets.add(3,"Mouse");
     System.out.println("9: "+ pets);
     System.out.println("\n//Sorted-----------------------------");
     /*
       subList所产的列表就是初始化列表，对返回的列表修改都会反映到初始化列表
       pets.containsAll(sub)，containsAll不受sub顺序影响
      */ 
     List<String> sub = pets.subList(1,4);
     System.out.println("subList: "+ sub);
     System.out.println("10: "+ pets.containsAll(sub));
     Collections.sort(sub);
     System.out.println("sorted subList: "+ sub);
     System.out.println("11: "+ pets.containsAll(sub));
     Collections.shuffle(sub,rand);
     System.out.println("shuffleed subList: "+ sub);
     System.out.println("12: "+ pets.containsAll(sub));
     //
     System.out.println("\n//fresh copy-----------------------------");
     List<String>copy = new ArrayList<String>(pets);
     sub = Arrays.asList(pets.get(1),pets.get(4));
     System.out.println("sub: "+ sub);
     copy.retainAll(sub); //依赖于equals
     System.out.println("13: "+ copy);
     //
     copy = new ArrayList<String>(pets);
     copy.remove(2);//使用索引，不必担心equals的影响
     System.out.println("14: "+ copy);
     copy.removeAll(sub);//依赖于equals
     System.out.println("15: "+ copy);
     copy.set(1,"Mouse"); //replace
     System.out.println("16: "+ copy);
     System.out.println("\n//clear-----------------------------");
     copy.addAll(2,sub);
     System.out.println("17: "+ copy);
     System.out.println("18: "+ pets.isEmpty());
     pets.clear();
     System.out.println("19: "+ pets);
     System.out.println("20: "+ pets.isEmpty());
     //
     List<String> l21 = new ArrayList<String>();
     Collections.addAll(l21,"Manx","Cymric","Rat","EgyptianMau");
     pets.addAll(l21);
     System.out.println("21: "+ pets);
     Object[] o = pets.toArray();
     System.out.println("22: "+ o[3]);
     String[] pa = pets.toArray(new String[0]);
     System.out.println("23: "+ pa[3]);
  }
}

class E7 {

   public static void main(String[] args){
       List<E7> e7List = new ArrayList(Arrays.asList(new E7(),new E7(),new E7()));
       List<E7> sub = e7List.subList(0,2);
       System.out.println(e7List);
       System.out.println(sub);
       e7List.removeAll(sub);
       System.out.println(e7List);

   }
}

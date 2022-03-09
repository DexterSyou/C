import java.util.*;
class EHToQ {}
//**************************************** */
//EH
class Gerbil {
  private String name;
  public Gerbil(String name){
    this.name = name;
  }
  public void hop(){
    System.out.println("gerbil "+ name +" is jumpping");
  }
}
class E17{
   public static void main(String[] args){
        Map<String,Gerbil> map= new HashMap<String,Gerbil>();
        map.put("Fuzzy",new Gerbil("Fuzzy"));
        map.put("Spot",new Gerbil("Spot"));

        Set keySet = map.keySet();
        Iterator it = keySet.iterator();
        String key;
        while(it.hasNext()){
            key = (String)it.next();
            System.out.println("KEY: " +key);
            map.get(key).hop();
        }  
   }
}
//**************************************** */
//EI
class E18 {
   public static void main(String[] args){
      Map<String,Integer> map = new HashMap<String,Integer>();
      map.put("2abc",3);
      map.put("3hello",5);
      map.put("1world",5);
      map.put("34how",3);
      map.put("5are",3);
      for(String key : map.keySet()){
          System.out.println("key: "+key+" has " + map.get(key) + " chars");
      } 
      //SortedMap
      Map<String,Integer> s = new TreeMap<String,Integer>(map);
      System.out.println("//******************************");
      for(String key : map.keySet()){
          System.out.println("key: "+key+" has " + map.get(key) + " chars");
      } 
      Map<String,Integer> l = new LinkedHashMap<String,Integer>(s);
      System.out.println("//******************************");
      for(String key : map.keySet()){
          System.out.println("key: "+key+" has " + map.get(key) + " chars");
      } 
   }
}
//**************************************** */
//EJ
class E19{
   public static void main(String[] args){
       System.out.println("//HashSet1*******************************");
       Set<String> set1 = new HashSet<String>();//使用散列维护顺序
       set1.add("9");
       set1.add("1");
       set1.add("3");
       set1.add("10");
       for(String i : set1){
           System.out.print(i+" ");
       }       
       System.out.println("\n//TreeSet1*******************************");
       SortedSet<String> sortedSet1 = new TreeSet<String>();  
       sortedSet1.add("2"); 
       sortedSet1.add("1"); 
       sortedSet1.add("10");
       sortedSet1.add("9");
       for(String i : sortedSet1){
           System.out.print(i+" ");
       }
       System.out.println("\n//LinkedHashSet1*******************************");
       Set<String> linkedSet1 = new LinkedHashSet<String>();
       linkedSet1.add("9");
       linkedSet1.add("1");
       linkedSet1.add("3");
       linkedSet1.add("10");
       for(String i : linkedSet1){
           System.out.print(i+" ");
       }       
      System.out.println("\n//LinkedHashSet1 TreeSet2*******************************");
      SortedSet<String> sortedSet2 = new TreeSet<String>(linkedSet1);  
      for(String i : sortedSet2){
           System.out.print(i+" ");
      }
      System.out.println("\n//LinkedHashSet1 HashSet2*******************************");
      Set<String> set2 = new HashSet<String>(linkedSet1);//使用散列维护顺序
      for(String i : set2){
           System.out.print(i+" ");
      }
      System.out.println();
   } 
}
//**************************************** */
//EK 
//EG E16
class E20{
   
   public static void main(String[] args){
      //Assumue TextFIle
      List<Character> list = new ArrayList<Character>(Arrays.asList('a','b','v','u','e','o','a','b','a','b'));
      Map<Character,Integer> map = new HashMap<Character,Integer>();
      for(Character lc : list){
        for(Character c : "aiueo".toCharArray()){  
          if(lc == c){    
            Integer freqc = map.get(c);
            map.put(lc,freqc==null?1:freqc+1);
          }
        }
      }

      System.out.println(map);
  }
}
//**************************************** */
//EL E21
class E21{
    //UniqueWords
    public static void main(String[] args){
       //Map<String,Integer> map = new HashMap<String,Integer>(new TextFile("test.dat","\\W"));
       Map<String,Integer> map = new HashMap<>();
       List<String> keyList = new ArrayList<>(map.keySet());
       Collections.sort(keyList, String.CASE_INSENSITIVE_ORDER);
       System.out.println(map);

    }
}
//EM E22
class Cnt {
    private String   word;
    private Integer  cntWord;
}
class E22{
    public static void main(String[] args){
       Set<Cnt> set = new HashSet<Cnt>();
       /*
       Loop TextFile Words:
       if(Has Word)
           Cnt.cntWotd +1
       else
          create Cnt of the word    
       */
    }
}

//EN E23
class E23{   
    public static void test(){
       Random rand = new Random();
       //Random rand = new Random(47);
       Map<Integer,Integer> map = new HashMap<Integer,Integer>();
       for(int i=0;i<10000;i++){
           int r = rand.nextInt(20);
           Integer freq = map.get(r);
           map.put(r,freq==null?1:freq+1);
       } 
      
      System.out.println(map);
    }
    public static void main(String[] args){
      for(int i = 0; i<10;i++)test();
    }
}
//EO E24
class E24{
    public static void main(String[] args){

      Map<String,Integer> map = new LinkedHashMap<String,Integer>();
      map.put("2abc",3);
      map.put("3hello",5);
      map.put("1world",5);
      map.put("34how",3);
      map.put("5are",3);
      for(String key : map.keySet()){
          System.out.println("key: "+key+" has " + map.get(key) + " chars");
      } 
      // keySet()方法返回值是Map中key值的集合；entrySet()的返回值也是返回一个Set集合，此集合的类型为Map.Entry
      // Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>
      // 它表示Map中的一个实体（一个key-value对）,接口中有getKey(),getValue方法
      List<Map.Entry<String,Integer>> b = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
      Collections.sort(b,new Comparator<Map.Entry<String,Integer>>(){
        public int compare(Map.Entry<String,Integer> c, Map.Entry<String,Integer> d){
             return c.getKey().compareTo(d.getKey());
        }
      });
      map.clear();
      for(Map.Entry<String,Integer> c : b ){
          map.put(c.getKey(),c.getValue());
      } 

      for(String key : map.keySet()){
          System.out.println("key: "+key+" has " + map.get(key) + " chars");
      } 
    }
}
//EP //EQ
class E25E26{

    public static void main(String[] args){
        //Get TextFile Words
        Map<String,ArrayList<Integer>> posMap = new HashMap<String,ArrayList<Integer>>();
        List<String> list = new ArrayList<String>(Arrays.asList("I am hello world how are you hello world".split(" ")));
        for(int i=0;i<list.size();i++){
            if(posMap.containsKey(list.get(i))){
                ArrayList<Integer> postiArrayList = posMap.get(list.get(i));
                postiArrayList.add(new Integer(i));
                posMap.put(list.get(i),postiArrayList); 
            }else{
                ArrayList<Integer> postiArrayList =new ArrayList<Integer>();
                postiArrayList.add(new Integer(i));
                posMap.put(list.get(i),postiArrayList); 
            }
        }
        System.out.println(posMap);

        List<Integer> position = new ArrayList<Integer>();
        for(String key : posMap.keySet()){
            for(Integer i : posMap.get(key))
              position.add(i);
        }
        Collections.sort(position);
        System.out.println(position);
        List<String> newStr = new ArrayList<String>();

        for(Integer i : position){
           for(String key : posMap.keySet()){
              if(posMap.get(key).contains(i)){
                  newStr.add(key);
              }
          }
        }
        System.out.println(newStr);

    }
}



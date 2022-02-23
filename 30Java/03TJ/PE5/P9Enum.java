enum Spiciness{
   NOT,MILD,MEDIUM,HOT,FLAMING //常量
}

public class P9Enum{

    public static void main(String[] args){
       //
       Spiciness howHot = Spiciness.MEDIUM;
       System.out.println(howHot);
       //编译器自动添加有用属性
       //toString，方便显示实例名字
       //ordinal 表示某个特定enum常量的声明顺序
       //static values()按照enum常量的声明顺序，产生由这些常量值构成的数组
       for(Spiciness s : Spiciness.values()){
            System.out.println(s + ", ordinal "+s.ordinal());
       }

       //
       Burrito plain = new Burrito(Spiciness.NOT);
       plain.describe();
       Burrito greenChile = new Burrito(Spiciness.MEDIUM);
       greenChile.describe();
       Burrito jalapeno = new Burrito(Spiciness.HOT);
       jalapeno.describe();
    }
}

class Burrito{

    Spiciness degree;
    Burrito(Spiciness degree){
        this.degree = degree;
    }
    public void describe(){
        System.out.println("This buttito is ");
        switch(degree){
            case NOT : System.out.println("not spicy at all.");break;
            case MILD: 
            case MEDIUM:System.out.println("a little not.");break;
            case HOT:
            case FLAMING:
            default:   System.out.println("may be too not."); 
        }
    }
}

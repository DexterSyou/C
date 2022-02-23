enum Coin{ //enum 产生枚举类时，某些编译器的行为
   ONE,TWO,THREE,FOUR,FIVE,SIX //常量
}  //会生成Coin.class

public class Test{

    public static void main(String[] args){
       //

       for(Coin c : Coin.values()){
            System.out.println(c + ", ordinal "+c.ordinal());
       }
       Coin f =  Coin.THREE;
       switch(f){
            case ONE : System.out.println("ONE");break;
            case TWO: System.out.println("TWO");break;
            case THREE:System.out.println("THREE");break;
            case FOUR:System.out.println("FOUR");break;
            case FIVE:System.out.println("FIVE");break;
            case SIX:System.out.println("SIX");break;
        }
   
    }
}

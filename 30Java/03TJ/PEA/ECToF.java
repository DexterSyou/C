public class ECToF{

    public static void main(String[] args){
         //
         EC ec =new EC();
         ec.testAnonymousInner();
         //
         ED ed = new ED();
         IECD ied = ed.makeAnonymousInner();
         ied.printSomething();
         // 
         EE ee = new EE();
         DangerousMonster dee = ee.mth1();
         Vampire vee = ee.mth2();
         //
         EF ef = new EF();
         EFBase efb = ef.method();
    }
}
//E12 E13 
//EC  ED
interface IECD{
    void printSomething();
} 

class EC {

    private String str = "hello.";
    private void printStr(){ System.out.println("EC: " + str);}

    public IECD makeAnonymousInner(){
        return new IECD(){
            public void printSomething(){
                System.out.println("EC.makeAnonymousInner.printSomething : "+str);
                str = "changing";
                printStr();
            }
        };
    }

    public void testAnonymousInner(){
        IECD iec = makeAnonymousInner();
        iec.printSomething();
    }
 }

 class ED {

    public IECD makeAnonymousInner(){
        return new IECD(){
            public void printSomething(){
                System.out.println("ED.makeAnonymousInner.printSomething : ");
            }
        };
    }
 }
 //E14 EE
interface Monster { void menace(); }
interface DangerousMonster extends Monster { void destroy();}
interface Lethal { void kill(); }
interface Vampire extends  DangerousMonster,Lethal { void drinkBlood();}
class EE {
 public DangerousMonster mth1(){
    return new DangerousMonster(){
        public void menace(){}
        public void destroy(){}
    };
 }
 public Vampire mth2(){
    return new Vampire(){
        public void menace(){}
        public void destroy(){} 
        public void kill(){}
        public void drinkBlood(){} 
    };
 }

}
 //E15 EF
 class EFBase {

      EFBase(int i){
          System.out.println("EFBase : " +i);
      }
 }

 class EF{

     public EFBase method(){
         return new EFBase(10){
            
         };
     }
 }

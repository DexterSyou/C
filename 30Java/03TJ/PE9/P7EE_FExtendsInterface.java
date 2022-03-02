public class Test{}

interface Monster{
    void menace();
}

interface DangerousMonster extends Monster{
    void destroy();
}

interface Lethal{
    void kill();
}

class DragonZilla implements DangerousMonster{
    public void menace(){}
    public void destroy(){}
}
//
interface Vampire extends DangerousMonster, Lethal{
    void drinkBlood();
}

class VeryBadVampire implements Vampire {
    public void menace(){}
    public void destroy(){}
    public void kill(){}
    public void drinkBlood(){}
}

class HorrorShow{
    static void u(Monster b){b.menace();}
    static void v(DangerousMonster d){
        d.menace();
        d.destroy();
    }
    static void w(Lethal l){l.kill();}

    public static void main(String[] args){
        DangerousMonster barney = new DragonZilla();
        u(barney);
        v(barney);
        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
    }
}

//EE
//EF
interface EE1{ //void m11();void m12();
}
interface EE2{ //void m21();void m22();
}
interface EE3{ //void m31();void m32();
}
interface EE extends EE1,EE2,EE3{
    void nm();
}

abstract class EF {

}

class EECls extends EF implements EE{
    public void nm(){}
    static void t1(EE1 ee1){}
    static void t2(EE2 ee2){}
    static void t3(EE3 ee3){}
    static void te(EE ee){}
    static void tf(EF ef){}


    public static void main(String[] args){
        EECls  eecls = new EECls();
        t1(eecls);
        t2(eecls);
        t3(eecls);
        te(eecls);
        tf(eecls);
    }

}







public class P9ComExtnds{

    public static void main(String[] args){
    Car car = new Car();
    car.left.window.rollup();
    car.wheel[0].inflate(72);
    }
}

class Engine{

    public void start(){}
    public void rev(){}
    public void stop(){}
}

class Wheel{
    public void inflate(int psi){}
}

class Window{
    public void rollup(){}
    public void rolldown(){}
}

class Door{
    public Window window=new Window();
    public void open(){}
    public void close(){}
}

class Car{
    /**
       1. 用户只是知道新定义类的接口，而非嵌入子类对象的接口
          只是使用了子类的功能 has-a
       2. 继承，使用现有类，并开发一个它的特殊版本
          通用类的特殊化      is-a
     */
     //声明public有助于理解新类功能，一般为private
    public Engine engine = new Engine(); // has-a 显示的放置子对象，is-a 隐式放置子对象
    public Wheel[] wheels = new Wheel[4];
    public Door left = new Door(),
                right = new Door();
    public Car(){
        for(int i=0;i<4;i++)}{
            wheel[i] = new Wheel();
        }
    }             
}

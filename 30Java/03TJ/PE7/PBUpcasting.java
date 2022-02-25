public class PBUpcasting{

 public static void main(String[] args){  
   Wind flute = new Wind();
   // 将Wind引用转换为Instrument引用
   // 专用类型向通用类型转换
   // 是否需要向上转型（使用继承）
   //
   Instrument.tune(flute);
  }
}

class Instrument{
   public void play(){}
   static void tune(Instrument i){
       i.play();
   }
}

class Wind extends Instrument{

}

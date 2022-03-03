public class P1E1InnerCLs {
   
   public static void main(String[] args){
      Parcel1 p1 = new Parcel1();
      p1.ship("Tasmania");
      //E1
      Parcel2 p2 = new Parcel2();
      p2.ship("Tasmania");
      Parcel2 q = new Parcel2();
      Parcel2.Contents c = q.contents();  //OuterClass.InnerClass
      Parcel2.Destination d = q.to("Borneo"); 
   }
}

//******************************************************** 
class Parcel1 {
    //InnerClass
    class Contents {
      private int i = 11;
      public int value(){return i;}
    }

    class Destination{
        private String label;
        Destination(String whereTo){
            label = whereTo;
        }
        String readLabel(){return label;}
    }

    public void ship(String dest){
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
    }
}
//******************************************************** 
class Parcel2{
    class Contents {
      private int i = 11;
      public int value(){return i;}
    }

    class Destination{
        private String label;
        Destination(String whereTo){
            label = whereTo;
        }
        String readLabel(){return label;}
    }
   
   public Destination to(String s){
       return new Destination(s);
   }

   public Contents contents(){
       return new Contents();
   }

   public void ship(String dest){
       Contents c = contents();
       Destination d = to(dest);
       System.out.println(d.readLabel());
   }

   
}

public class Pet {
   private int id;
    private String name;
    private double height;
    private double weight;

    public Pet(){
        id=0;
        name="";
        height=0.;
        weight=0.;
    }
    public Pet(int i,String nam,double hei,double wei){
        id=i;
        name=nam;
        height=hei;
        weight=wei;
    }
    @Override
    public boolean equals(Object o){
        Pet pomocna=(Pet)o;
        if(this.id==pomocna.id)return true;
        return false;
    }

    @Override
    public String toString(){
        return name;
    }
}


public class Z1{
    private int x,y;
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x=x;
        this.y=this.y-x;
        if(this.y<0)this.y=0;
    }
    public void setY(int y){
        this.y=y;
    }
    Z1(){x=0;y=0;}
    Z1(int mn){
        x=y=mn;
    }



}
import java.io.Serializable;

public class Z1 implements Cloneable{
    private int x,y;


  /*  @Override
    public int compareTo(Object o){
        Z1 pomocna=(Z1) o;
        if(x>pomocna.getX())return 1;
        else if(x== pomocna.getX())return 0;
        else return -1;
    }*/

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x=x;
        y+=x;
        if(y>10000)y=0;
    }
    public void setY(int y){
        this.y=y;
    }
    Z1(){
        x=0;y=0;
    }
    Z1(int q){
        x=y=q;
    }


}
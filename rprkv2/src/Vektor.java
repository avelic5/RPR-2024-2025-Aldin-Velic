import java.util.Objects;

public class Vektor {
    private int x,y;

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    Vektor(){
        this.x=0;
        this.y=0;
    }

    Vektor(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void duplaj(){
        if(x<100&&y<100){x*=2;y*=2;}
    }





    public void dodaj(Vektor b){
        x+=b.x;
        y+=b.y;
    }

    public void dodajAkoJePozitivan(Vektor b){
        if(x+b.x>0&&y+b.y>0){x+=b.x;y+=b.y;}

    }


}

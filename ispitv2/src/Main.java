public class Main {

    public static int sumacifara(int broj){
        int predznak=1;
        int suma=0;
        if(broj<0){predznak=-1;broj*=-1;}
        while(broj!=0){
            suma+=broj%10;
            broj/=10;
        }
return suma*predznak;
    }
    public static void main(String[] args){

    System.out.print(sumacifara(0));


    }
}

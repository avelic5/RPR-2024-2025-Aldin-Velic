import java.util.*;

public class Main{

    public static Boolean prost(Integer n){
        if(n==2)return true;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)return false;
        }
        return true;

    }

    public static void main(String[] args) {
       Proba x=Proba.DIKTATURA;
       System.out.print(x);

    }}
import java.util.*;

public class Main {
    public static boolean prost(int broj){
    if(broj==2)return true;
    for(int i=2;i<=Math.sqrt(broj);i++)if(broj%i==0)return false;
    return true;
    }
    public static void main(String[] args) {
        int n=0,m=0;
        Scanner ulaz=new Scanner(System.in);
        n=ulaz.nextInt();
        m= ulaz.nextInt();
        int suma=0;
        for(int i=2;i<n+1;i++) {
            if (suma+i > m || i > n) break;
            if (prost(i)) {
                suma += i;
                System.out.println(i);
            }
        }

        }
    }

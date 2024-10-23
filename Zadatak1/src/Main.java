import java.util.Scanner;

public class Main {
    public static void main(String[] args) {





            System.out.println("Unesite n: ");
            int n=0;
            boolean x=true;
            Scanner ulaz=new Scanner(System.in);
            do{
                n=ulaz.nextInt();
                if(n<2){System.out.println("Nije moguce izvrsiti izracunavanje prostih brojeva");
                    return;}
                if(n>500)System.out.println("Ponovite unos");
           } while(n>500);
            for(int i=2;i<2*n;i=i+1){
                for(int j=2;j<2*n/j;j=j+1){
                    if(i%j==0){x=false;break;}}
                        if(x||i==2||i==3)System.out.print(i+" ");

                        x=true;


            }


    }
}
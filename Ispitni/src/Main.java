import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner ulaz=new Scanner(System.in);
        Set<Integer> s1=new HashSet<>();

        ArrayList<Integer> lista=new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            System.out.print("Unesi"+i+". broj");
            var x=ulaz.nextInt();
           if(x%2==0) lista.add(x);
        }

        s1.addAll(lista);
        lista.clear();
        lista.addAll(s1);
        lista.sort(null);
        System.out.print("[");
        int i=0;
        for(i=0;i<lista.size()-1;i++) System.out.print(lista.get(i)+",");
       if(i!=0) System.out.print(lista.get(i));
       System.out.print("]");


        }
    }

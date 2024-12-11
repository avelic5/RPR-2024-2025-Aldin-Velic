import java.util.ArrayList;
import java.util.List;

public class Rjesenje {
static String poruka;
    public interface porukice {
        String dajPoruku()throws PUNINBOX ;
        default String xa(){
            return "12";
        }
    }
    public static class PUNINBOX extends Exception{
        PUNINBOX(String message){
            super(message);
        }
    }
    public  class SMS  implements porukice{
        Rjesenje.SMS poruka=new SMS();
        List<String> lista=new ArrayList<>();

        @Override
        public String dajPoruku()throws PUNINBOX{
            if(poruka.equals(""))throw new PUNINBOX("jebiga");

            return poruka+"SMS";
        }

    }


    public class EMAIL extends SMS implements porukice{

        @Override
        public String dajPoruku(){
            return poruka+"EMAIL";
        }
    }

    public class INBOX implements porukice{
        EMAIL X=new EMAIL();
        @Override
        public String dajPoruku(){
            return poruka+"INBOX";
        }
    }
}

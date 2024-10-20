//paziti na povratnetipove i imena promjenjivih
public class Kalkulator{
    public enum Operator{plus,minus,puta,podijeljeno}

    public class Controller{
        private Model model;
        private EkranView ekran;
        public Controller(Model m,EkranView e){
            model=m;
            ekran=e;
        }
        public void plusBtn(){
            model.setUkupniRezultat(model.getUkupniRezultat()+model.getTrenutniBroj());
            model.setTrenutniBroj(0);
            ekran.setTekst(String.valueOf(model.getUkupniRezultat()));

        }

        public void putaBtn(){
            model.setUkupniRezultat(model.getUkupniRezultat()*model.getTrenutniBroj());
            model.setTrenutniBroj(0);
            ekran.setTekst(String.valueOf(model.getUkupniRezultat()));
        }
    }

    public class Model{
        private int trenutniBroj,ukupniRezultat;
        public int getTrenutniBroj(){return trenutniBroj;}
        public int getUkupniRezultat(){return ukupniRezultat;}
        public void setTrenutniBroj(int b){trenutniBroj=b;}
        public void setUkupniRezultat(int b){ukupniRezultat=b;}

        public void SpremiRezultat(Operator o){
            if(o==Operator.plus)ukupniRezultat+=trenutniBroj;
            else ukupniRezultat*=trenutniBroj;
        }

        public Model(int tr){trenutniBroj=tr;ukupniRezultat=0;}
    }

    public class EkranView{
        private String tekst;
        public String getTekst(){return tekst;}
        public void setTekst(String s){tekst=s;}

    }


}
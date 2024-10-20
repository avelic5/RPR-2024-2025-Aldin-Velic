public class Main {
    public static void main(String[] args){
        Kalkulator k = new Kalkulator();
        Kalkulator.Model model = k.new Model(5);
        Kalkulator.EkranView ekranView = k.new EkranView();
        Kalkulator.Controller controller = k.new Controller(model, ekranView);
        controller.plusBtn();
        System.out.println(ekranView.getTekst());
        controller.putaBtn();
        System.out.println(ekranView.getTekst());
    }
}
